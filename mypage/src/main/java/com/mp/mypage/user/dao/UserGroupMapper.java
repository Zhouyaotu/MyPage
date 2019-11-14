package com.mp.mypage.user.dao;

import com.mp.mypage.user.entity.UserGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserGroupMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserGroup record);

    int insertSelective(UserGroup record);

    UserGroup selectByPrimaryKey(Long id);

    List<UserGroup> selectAll();

    int updateByPrimaryKeySelective(UserGroup record);

    int updateByPrimaryKey(UserGroup record);
}