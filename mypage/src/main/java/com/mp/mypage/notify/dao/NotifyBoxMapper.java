package com.mp.mypage.notify.dao;

import com.mp.mypage.notify.entity.NotifyBox;

public interface NotifyBoxMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NotifyBox record);

    int insertSelective(NotifyBox record);

    NotifyBox selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NotifyBox record);

    int updateByPrimaryKey(NotifyBox record);
}