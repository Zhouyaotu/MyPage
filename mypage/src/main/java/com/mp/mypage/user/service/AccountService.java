package com.mp.mypage.user.service;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.mp.mypage.common.Result;
import com.mp.mypage.user.dao.UserBaseMapper;
import com.mp.mypage.user.dao.UserInfoMapper;
import com.mp.mypage.user.entity.UserBase;
import com.mp.mypage.user.entity.UserInfo;
import com.mp.mypage.user.util.UserUtil;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 该类提供了对用户基本账户信息的处理方法
 * @author 刘鑫源
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
            return new Result(UserUtil.ACCOUNT_EXIST, "账户已存在");
        userBaseMapper.insertSelective(userBase);
        userInfoMapper.insertSelective(new UserInfo().setId(userBase.getId()));
        return new Result(UserUtil.OPERATOR_SUCCESS, "注册成功");
    }

    /**
     * 该方法用于用户登录
     * @param username 用户名
     * @param password 用户密码
     * @return 结果信息
     */
    public Result login(String username, String password){
        UserBase userBase = userBaseMapper.selectByUsername(username);
        if(userBase == null)
            return new Result(UserUtil.ACCOUNT_NOT_EXIST, "账户不存在");
        int accountStatus = userBase.getAccountStatus().intValue();
        if(accountStatus == 1)
            return new Result(UserUtil.ACCOUNT_BAN, "账户被封停");
        else if(accountStatus == 2)
            return new Result(UserUtil.ACCOUNT_FREEZE, "账户被冻结");
        if(!userBase.getPassword().equals(password))
            return new Result(UserUtil.PASSWORD_WRONG, "密码错误");
        return new Result(UserUtil.OPERATOR_SUCCESS, "登陆成功");
    }

    /**
     * 该方法用于修改用户密码
     * @param id 用户id
     * @param newPassword 新密码
     * @return 结果信息
     */
    public Result modifyPassword(long id, String newPassword){
        UserBase userBase = new UserBase().setId(id).setPassword(newPassword);
        userBaseMapper.updateByPrimaryKeySelective(userBase);
        return new Result(UserUtil.OPERATOR_SUCCESS, "密码修改成功");
    }

    /**
     * 该方法用于修改用户头像
     * @param id 用户账号
     * @param imgUrl 头像存储位置url
     * @return 结果信息
     */
    public Result modifyHeadImg(long id, String imgUrl){
        UserBase userBase = new UserBase().setId(id).setHeadImg(imgUrl);
        userBaseMapper.updateByPrimaryKeySelective(userBase);
        return new Result(UserUtil.OPERATOR_SUCCESS, "头像更换成功");
    }

    /**
     * 该方法用于修改用户信息
     * @param id 用户id
     * @param userInfo 包含修改后的用户信息
     * @return 结果信息
     */
    public Result modifyUserInfo(long id, UserInfo userInfo){
        userInfo.setId(id);
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
        return new Result(UserUtil.OPERATOR_SUCCESS, "信息设置成功");
    }

    /**
     * 该方法用于获取用户详细信息
     * @param id 用户id
     * @return 处理结果
     */
    public Result getUserInfo(long id){
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        return new Result(UserUtil.OPERATOR_SUCCESS, "信息获取成功").setAttribute(userInfo);
    }
}
