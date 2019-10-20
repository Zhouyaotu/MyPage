package com.mp.mypage.user.dao;

import com.mp.mypage.user.entity.UserFollower;

public interface UserFollowerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserFollower record);

    int insertSelective(UserFollower record);

    UserFollower selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserFollower record);

    int updateByPrimaryKey(UserFollower record);
}