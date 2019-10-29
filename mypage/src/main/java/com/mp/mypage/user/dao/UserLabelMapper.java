package com.mp.mypage.user.dao;

import com.mp.mypage.user.entity.UserLabel;

public interface UserLabelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserLabel record);

    int insertSelective(UserLabel record);

    UserLabel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserLabel record);

    int updateByPrimaryKey(UserLabel record);
}