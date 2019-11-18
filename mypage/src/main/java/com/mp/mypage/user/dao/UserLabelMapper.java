package com.mp.mypage.user.dao;

import com.mp.mypage.user.entity.UserLabel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserLabelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserLabel record);

    int insertSelective(UserLabel record);

    UserLabel selectByPrimaryKey(Long id);

    List<UserLabel> selectAllLabelsByUserId(long userId);

    int updateByPrimaryKeySelective(UserLabel record);

    int updateByPrimaryKey(UserLabel record);
}