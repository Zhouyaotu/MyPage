package com.mp.mypage.user.dao;

import com.mp.mypage.user.entity.UserBase;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface UserBaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserBase record) throws DataAccessException;

    int insertSelective(UserBase record) throws DataAccessException;

    UserBase selectByPrimaryKey(Long id);

    UserBase selectByUsername(String username);

    List<UserBase> selectAll();

    int updateByPrimaryKeySelective(UserBase record);

    int updateByPrimaryKey(UserBase record);
}