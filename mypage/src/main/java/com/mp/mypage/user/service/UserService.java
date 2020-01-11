package com.mp.mypage.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mp.mypage.common.Result;
import com.mp.mypage.user.dao.UserFollowerMapper;
import com.mp.mypage.user.dao.UserGroupMapper;
import com.mp.mypage.user.dao.UserLabelMapper;
import com.mp.mypage.user.dto.UserGroupDTO;
import com.mp.mypage.user.dto.UserIdolDTO;
import com.mp.mypage.user.dto.UserInfoDTO;
import com.mp.mypage.user.dto.UserSimpleInfoDTO;
import com.mp.mypage.user.entity.UserFollower;
import com.mp.mypage.user.entity.UserGroup;
import com.mp.mypage.user.entity.UserLabel;
import com.mp.mypage.common.Constant;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description  该类提供了对用户之间交互的处理方法
 * @author 刘鑫源
 * @time 2019/11/12
 * @lastUpdateMan 刘鑫源
 * @lastUpdateTime 2019/1/10
 * @version 1.0
 */
@Service
public class UserService {
    @Resource
    UserGroupMapper userGroupMapper;

    @Resource
    UserFollowerMapper userFollowerMapper;

    @Resource
    UserLabelMapper userLabelMapper;

    public boolean isFollower(long srcId, long destId){
        UserFollower userFollower = new UserFollower().setSubjectUserId(srcId).setObjectUserId(destId);
        return userFollowerMapper.selectByUserPair(userFollower) != null;
    }

    /**
     * 该方法用于进行用户关注
     * @param srcId 关注者id
     * @param destId 被关注者id
     * @param groupId 分组id
     * @return 结果信息
     */
    public Result follow(long srcId, long destId, long groupId){
        //正向关注设置
        UserFollower srcFollower = new UserFollower().setSubjectUserId(srcId)
                .setObjectUserId(destId).setUserGroupId(groupId);

        //反向关注设置
        //如果被关注者也关注了关注者，则设置被关注者为双向关注；否则无事发生
        UserFollower destFollower = new UserFollower().setSubjectUserId(destId)
                .setObjectUserId(srcId).setFollowStatus(true);
        //数据库操作的返回值代表受影响的列
        //返回值为0表明不存在反向关注， 则应将正向关注设为单向关注；否则为双向关注
        if(userFollowerMapper.updateByUserIdPairSelective(destFollower) == 0)
            srcFollower.setFollowStatus(false);
        else
            srcFollower.setFollowStatus(true);
        //执行正向关注
        if(isFollower(srcId, destId))
            return new Result(Constant.FOLLOW_REPEAT, "不可重复关注");
        try{
            userFollowerMapper.insertSelective(srcFollower);
            return new Result(Constant.OPERATOR_SUCCESS, "关注成功");
        } catch (DataAccessException e){
            e.printStackTrace();
            return new Result(Constant.ACCOUNT_NOT_EXIST, "用户不存在");
        }
    }

    /**
     * 该方法用于取消用户关注
     * @param srcId 关注者id
     * @param destId 被关注者id
     * @return 结果信息
     */
    public Result unfollow(long srcId, long destId){
        UserFollower destFollower = new UserFollower().setSubjectUserId(destId).
                setObjectUserId(srcId).setFollowStatus(false);
        if(userFollowerMapper.deleteByUserIdPair(srcId, destId) != 0){
            userFollowerMapper.updateByUserIdPairSelective(destFollower);
            return new Result(Constant.OPERATOR_SUCCESS, "取消关注成功");
        }
        else
            return new Result(Constant.ACCOUNT_NOT_EXIST, "用户不存在或不存在关注");
    }

    /**
     * 该方法用于修改用户所在分组
     * @param srcId 关注者id
     * @param destId 被关注者id
     * @param newGroupId 新的分组id
     * @return 结果信息
     */
    public Result modifyDestGroup(long srcId, long destId, long newGroupId){
        UserFollower userFollower = new UserFollower().setSubjectUserId(srcId).
                setObjectUserId(destId).setUserGroupId(newGroupId);
        if(userFollowerMapper.updateByUserIdPairSelective(userFollower) != 0)
            return new Result(Constant.OPERATOR_SUCCESS, "修改成功");
        else
            return new Result(Constant.ACCOUNT_NOT_EXIST, "用户不存在");
    }

    /**
     * 该方法用于创建用户分组
     * @param srcId 分组所属用户的id
     * @param groupName 分组名称
     * @return 结果信息
     */
    public Result createUserGroup(long srcId, String groupName){
        try {
            userGroupMapper.insert(new UserGroup().setUserId(srcId).setGroupName(groupName));
            return new Result(Constant.OPERATOR_SUCCESS, "分组创建成功");
        } catch (DataAccessException e){
            e.printStackTrace();
            return new Result(Constant.ACCOUNT_NOT_EXIST, "用户不存在");
        }
    }

    /**
     * 该方法用于移除用户分组
     * @param groupId 分组id
     * @return 结果信息
     */
    public Result removeUserGroup(long groupId){
        List<Long> idols = userFollowerMapper.selectAllIdolByGroupId(groupId);
        if(idols != null && idols.size() != 0)
            return new Result(Constant.UNABLE_DELETE, "分组无法删除");
        if(userGroupMapper.deleteByPrimaryKey(groupId) != 0)
            return new Result(Constant.OPERATOR_SUCCESS, "分组删除成功");
        else
            return new Result(Constant.GROUP_NOT_EXIST, "分组不存在");
    }

    /**
     * 该方法用于修改用户分组的名称
     * @param groupId 分组id
     * @param newGroupName 新的分组名称
     * @return 结果信息
     */
    public Result renameUserGroup(long groupId, String newGroupName){
        if(userGroupMapper.updateByPrimaryKeySelective(new UserGroup().setId(groupId).setGroupName(newGroupName)) != 0)
            return new Result(Constant.OPERATOR_SUCCESS, "分组名称修改成功");
        else
            return new Result(Constant.GROUP_NOT_EXIST, "分组不存在");
    }

    /**
     * 该方法用于获得用户的粉丝列表
     * @param destId 关注者id
     * @return 结果信息， 包含粉丝列表
     */
    public Result getAllFollowersByUserId(long destId, int pageNum, int pageSize){
        PageHelper.offsetPage(pageNum * pageSize, pageSize);
        List<UserSimpleInfoDTO> followers = userFollowerMapper.selectAllFollowerByUserId(destId);
        PageInfo pageInfo = new PageInfo<>(followers);
        if(followers != null)
            return new Result(Constant.OPERATOR_SUCCESS, "关注列表获取成功")
                    .addAttribute("pages", pageInfo.getPages())
                    .addAttribute("followers", followers);
        else
            return new Result(Constant.RESULT_EMPTY, "结果为空");
    }

    /**
     * 该方法用于获取用户的分组列表
     * @param srcId 用户id
     * @return 结果信息， 包含分组列表
     */
    public Result getAllUserGroupByUserId(long srcId){
        List<UserGroupDTO> groups = userGroupMapper.selectUserGroupByUserId(srcId);
        if(groups != null)
            return new Result(Constant.OPERATOR_SUCCESS, "获取分组成功")
                    .setAttribute(groups);
        else
            return new Result(Constant.RESULT_EMPTY, "结果为空");
    }

    /**
     * 该方法用于获取用户的关注列表
     * @param groupId 用户分组id
     * @return 结果信息， 包含关注列表
     */
    @Deprecated
    public Result getAllIdolByGroupId(long groupId){
        List<Long> idolIds = userFollowerMapper.selectAllIdolByGroupId(groupId);
        if(idolIds != null)
            return new Result(Constant.OPERATOR_SUCCESS, "关注列表获取成功")
                    .setAttribute(idolIds);
        else
            return new Result(Constant.RESULT_EMPTY, "结果为空");
    }

    /**
     * 该方法用于直接根据用户id获取带有分组的被关注者信息
     * @param srcId 用户id
     * @return 结果信息， 包含带有详细信息的关注列表
     */
    public Result getAllIdolByUserId(long srcId, int pageNum, int pageSize){
        PageHelper.offsetPage(pageNum * pageSize, pageSize);
        List<UserIdolDTO> idols = userFollowerMapper.selectAllIdolByUserId(srcId);
        if(idols != null){
            PageInfo pageInfo = new PageInfo<>(idols);
            return new Result(Constant.OPERATOR_SUCCESS, "关注列表获取成功")
                    .addAttribute("pages", pageInfo.getPages())
                    .addAttribute("idols", idols);
        } else
            return new Result(Constant.RESULT_EMPTY, "结果为空");
    }

    /**
     * 该方法用于给用户贴标签
     * @param userId 用户id
     * @param content 标签内容
     * @param type 标签类型
     * @return 结果信息
     */
    public Result tagLabel(long userId, String content, byte type){
        UserLabel userLabel = new UserLabel().setUserId(userId)
                .setLabelContent(content).setLabelType(type);
        userLabelMapper.insert(userLabel);
        return new Result(Constant.OPERATOR_SUCCESS, "标签添加成功");
    }

    /**
     * 该方法用于给用户去除指定标签
     * @param userLabelId 用户标签表中的id
     * @return 结果信息
     */
    public Result untagLabel(long userLabelId){
        userLabelMapper.deleteByPrimaryKey(userLabelId);
        return new Result(Constant.OPERATOR_SUCCESS, "标签添加成功");
    }

    /**
     * 该方法用于获得用户的所有标签
     * @param userId 用户id
     * @return 结果信息，其属性包含标签列表
     */
    public Result getAllLabelsByUserId(long userId){
        List<UserLabel> labels = userLabelMapper.selectAllLabelsByUserId(userId);
        return new Result(Constant.OPERATOR_SUCCESS, "标签获取成功").addAttribute(labels);
    }



}
