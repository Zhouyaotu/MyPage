package com.mp.mypage.user.dao;

import com.mp.mypage.user.entity.UserFollower;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserFollowerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserFollower record);

    int insertSelective(UserFollower record);

    UserFollower selectByPrimaryKey(Long id);

    List<UserFollower> selectAll();

    int updateByPrimaryKeySelective(UserFollower record);

    int updateByPrimaryKey(UserFollower record);
}