package com.mp.mypage.service;

import com.mp.mypage.dao.UserDao;
import com.mp.mypage.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class UserLoginServiceImpl implements UserLoginService{

    @Resource
    private UserDao userDao;

    @Override
    public boolean isExist(String username) {
        return userDao.findByUsername(username) != null;
    }

    @Override
    public User findByName(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User get(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }
}
