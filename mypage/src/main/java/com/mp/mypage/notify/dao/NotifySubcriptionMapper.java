package com.mp.mypage.notify.dao;

import com.mp.mypage.notify.entity.NotifySubcription;

public interface NotifySubcriptionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NotifySubcription record);

    int insertSelective(NotifySubcription record);

    NotifySubcription selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NotifySubcription record);

    int updateByPrimaryKey(NotifySubcription record);
}