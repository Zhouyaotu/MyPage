package com.mp.mypage.user.service;

import com.mp.mypage.common.Result;
import com.mp.mypage.user.dao.UserFollowerMapper;
import com.mp.mypage.user.dao.UserGroupMapper;
import com.mp.mypage.user.dao.UserLabelMapper;
import com.mp.mypage.user.entity.UserFollower;
import com.mp.mypage.user.entity.UserLabel;
import com.mp.mypage.user.util.UserUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 该类提供了对用户之间交互的处理方法
 * @author 刘鑫源
 */
@Service
public class UserService {
    @Resource
    UserGroupMapper userGroupMapper;

    @Resource
    UserFollowerMapper userFollowerMapper;

    @Resource
    UserLabelMapper userLabelMapper;

    /**
     * 该方法用于进行用户关注
     * @param srcId 关注者id
     * @param destId 被关注者id
     * @param groupId 分组id
     * @return 结果信息
     */
    public Result follow(long srcId, long destId, long groupId){
        UserFollower userFollower = new UserFollower().setSubjectUserId(srcId).
                setObjectUserId(destId).setUserGroupId(groupId);
        userFollowerMapper.insertSelective(userFollower);
        return new Result(UserUtil.OPERATOR_SUCCESS, "关注成功");
    }

    /**
     * 该方法用于取消用户关注
     * @param srcId 关注者id
     * @param destId 被关注者id
     * @return 结果信息
     */
    public Result unfollow(long srcId, long destId){
        UserFollower userFollower = new UserFollower().setSubjectUserId(srcId).
                setObjectUserId(destId);
        userFollowerMapper.deleteByUserIdPair(srcId, destId);
        return new Result(UserUtil.OPERATOR_SUCCESS, "取消关注成功");
    }

    /**
     * 该方法用于修改用户所在分组
     * @param srcId 关注者id
     * @param destId 被关注者id
     * @param newGroupId 新的分组id
     * @return 结果信息
     */
    public Result modifyUserGroup(long srcId, long destId, long newGroupId){
        UserFollower userFollower = new UserFollower().setSubjectUserId(srcId).
                setObjectUserId(destId).setUserGroupId(newGroupId != 0 ? newGroupId : 0);
        userFollowerMapper.updateByUserIdPair(userFollower);
        return new Result(UserUtil.OPERATOR_SUCCESS, "修改成功");
    }

    /**
     * 该方法用于获得用户的关注列表
     * @param srcId 关注者id
     * @return 结果信息
     */
    public Result getAllFollowersByUserId(long srcId){
        //TODO: 查询用户所有的关注者，返回其基本信息
        return new Result(UserUtil.NOT_IMPLEMENT,"未实现");
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
        return new Result(UserUtil.OPERATOR_SUCCESS, "标签添加成功");
    }

    /**
     * 该方法用于给用户去除指定标签
     * @param userLabelId 用户标签表中的id
     * @return 结果信息
     */
    public Result untagLabel(long userLabelId){
        userLabelMapper.deleteByPrimaryKey(userLabelId);
        return new Result(UserUtil.OPERATOR_SUCCESS, "标签添加成功");
    }

    /**
     * 该方法用于获得用户的所有标签
     * @param userId 用户id
     * @return 结果信息，其属性包含标签列表
     */
    public Result getAllLabelsByUserId(long userId){
        List<UserLabel> labels = userLabelMapper.selectAllLabelsByUserId(userId);
        return new Result(UserUtil.OPERATOR_SUCCESS, "标签获取成功").setAttribute(labels);
    }



}
