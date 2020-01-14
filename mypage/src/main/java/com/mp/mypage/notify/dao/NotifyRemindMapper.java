package com.mp.mypage.notify.dao;

import com.mp.mypage.notify.entity.NotifyRemind;

public interface NotifyRemindMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NotifyRemind record);

    int insertSelective(NotifyRemind record);

    NotifyRemind selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NotifyRemind record);

    int updateByPrimaryKey(NotifyRemind record);
}