package com.mp.mypage.user.dao;

import com.mp.mypage.user.entity.UserBase;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserBaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserBase record);

    int insertSelective(UserBase record);

    UserBase selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserBase record);

    int updateByPrimaryKey(UserBase record);
}