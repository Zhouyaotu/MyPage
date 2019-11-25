package com.mp.mypage.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mp.mypage.common.Result;
import com.mp.mypage.user.dao.UserBaseMapper;
import com.mp.mypage.user.dao.UserInfoMapper;
import com.mp.mypage.user.dto.UserInfoDTO;
import com.mp.mypage.user.entity.UserBase;
import com.mp.mypage.user.entity.UserInfo;
import com.mp.mypage.common.Constant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description 该类提供了对用户基本账户信息的处理方法
 * @author 刘鑫源
 * @time 2019/11/12
 * @lastUpdateMan 刘鑫源
 * @lastUpdateTime 2019/11/17
 * @version 1.0
 */
@Service
public class AccountService {
    @Resource
    UserBaseMapper userBaseMapper;

    @Resource
    UserInfoMapper userInfoMapper;


    /**
     * 该方法用于注册用户信息
     * @param userBase 包含用户注册信息
     * @return 结果信息
     */
    public Result register(UserBase userBase){
        String username = userBase.getUsername();
        if(null != userBaseMapper.selectByUsername(username))
            return new Result(Constant.ACCOUNT_EXIST, "账户已存在");
        userBaseMapper.insertSelective(userBase);
        userInfoMapper.insertSelective(new UserInfo().setId(userBase.getId()));
        return new Result(Constant.OPERATOR_SUCCESS, "注册成功");
    }

    /**
     * 该方法用于用户登录
     * @param username 用户名
     * @param password 用户密码
     * @return 结果信息，包含 用户id
     */
    public Result login(String username, String password){
        //System.out.println(username);
        UserBase userBase = userBaseMapper.selectByUsername(username);
        if(userBase == null)
            return new Result(Constant.ACCOUNT_NOT_EXIST, "账户不存在");
        int accountStatus = userBase.getAccountStatus().intValue();
        if(accountStatus == 1)
            return new Result(Constant.ACCOUNT_BAN, "账户被封停");
        else if(accountStatus == 2)
            return new Result(Constant.ACCOUNT_FREEZE, "账户被冻结");
        if(!userBase.getPassword().equals(password))
            return new Result(Constant.PASSWORD_WRONG, "密码错误");
        return new Result(Constant.OPERATOR_SUCCESS, "登陆成功")
                //.setAttribute(userBase.getId())
                .addAttribute("uid", userBase.getId());
    }

    /**
     * 该方法用于修改用户密码
     * @param id 用户id
     * @param newPassword 新密码
     * @return 结果信息
     */
    public Result modifyPassword(long id, String newPassword){
        UserBase userBase = new UserBase().setId(id).setPassword(newPassword);
        if(userBaseMapper.updateByPrimaryKeySelective(userBase) != 0)
            return new Result(Constant.OPERATOR_SUCCESS, "密码修改成功");
        else
            return new Result(Constant.ACCOUNT_NOT_EXIST, "账户不存在");
    }

    /**
     * 该方法用于修改用户头像
     * @param id 用户账号
     * @param imgUrl 头像访问位置url
     * @return 结果信息, 包含图片访问位置url
     */
    public Result modifyHeadImg(long id, String imgUrl){
        UserInfo userInfo = new UserInfo().setId(id).setHeadImg(imgUrl);
        if(userInfoMapper.updateByPrimaryKeySelective(userInfo) != 0)
            return new Result(Constant.OPERATOR_SUCCESS, "头像更换成功")
                .addAttribute("imgUrl", imgUrl);
        else
            return new Result(Constant.ACCOUNT_NOT_EXIST, "账户不存在");
    }

    /**
     * 该方法用于修改用户信息
     * @param id 用户id
     * @param userInfo 包含修改后的用户信息
     * @return 结果信息
     */
    public Result modifyUserInfo(long id, UserInfo userInfo){
        userInfo.setId(id);
        if(userInfoMapper.updateByPrimaryKeySelective(userInfo) != 0)
            return new Result(Constant.OPERATOR_SUCCESS, "信息设置成功");
        else
            return new Result(Constant.ACCOUNT_NOT_EXIST, "账户不存在");
    }

    /**
     * 该方法用于获取用户详细信息
     * @param id 用户id
     * @return 处理结果， 包含 用户详细信息
     */
    public Result getUserInfo(long id){
        UserInfoDTO userInfo = userInfoMapper.selectDTOByUserId(id);
        if(userInfo != null)
            return new Result(Constant.OPERATOR_SUCCESS, "信息获取成功").addAttribute(userInfo);
        else
            return new Result(Constant.ACCOUNT_NOT_EXIST, "账户不存在");
    }

    /**
     * 该方法用于获取所有用户详细信息
     * @return 处理结果， 包含 用户详细信息列表
     */
    public Result getAllUserInfo(int pageNum, int pageSize){
        PageHelper.offsetPage(pageNum * pageSize, pageSize);
        List<UserInfoDTO> userInfos = userInfoMapper.selectAllDTO();
        if(userInfos != null){
            PageInfo pageInfo = new PageInfo<>(userInfos);
            return new Result(Constant.OPERATOR_SUCCESS, "信息获取成功")
                    .addAttribute("pages", pageInfo.getPages())
                    .addAttribute("users", userInfos);
        }
        return new Result(Constant.RESULT_EMPTY, "结果为空");
    }
}
