package com.mp.mypage.service;

import com.mp.mypage.entity.User;

import java.util.List;

public interface UserLoginService {
    public boolean isExist(String username);

    public User findByName(String username);

    public User get(String username, String password);
}
