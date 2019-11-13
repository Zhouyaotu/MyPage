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

@Service
public class AccountService {
    @Resource
    UserBaseMapper userBaseMapper;

    @Resource
    UserInfoMapper userInfoMapper;

    public Result register(UserBase userBase){
        String username = userBase.getUsername();
        if(null != userBaseMapper.selectByUsername(username))
            return new Result(UserUtil.ACCOUNT_EXIST, "账户已存在");
        userBaseMapper.insertSelective(userBase);
        userInfoMapper.insertSelective(new UserInfo().setId(userBase.getId()));
        return new Result(UserUtil.OPERATOR_SUCCESS, "注册成功");
    }

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

    public Result modifyPassword(long id, String newPassword){
        UserBase userBase = new UserBase().setId(id).setPassword(newPassword);
        userBaseMapper.updateByPrimaryKeySelective(userBase);
        return new Result(UserUtil.OPERATOR_SUCCESS, "密码修改成功");
    }

    public Result modifyHeadImg(long id, String imgUrl){
        UserBase userBase = new UserBase().setId(id).setHeadImg(imgUrl);
        userBaseMapper.updateByPrimaryKeySelective(userBase);
        return new Result(UserUtil.OPERATOR_SUCCESS, "头像更换成功");
    }

    public Result modifyUserInfo(long id, UserInfo userInfo){
        userInfo.setId(id);
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
        return new Result(UserUtil.OPERATOR_SUCCESS, "信息设置成功");
    }
}
