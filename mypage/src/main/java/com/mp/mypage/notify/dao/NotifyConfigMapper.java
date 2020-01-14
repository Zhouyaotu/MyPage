package com.mp.mypage.notify.dao;

import com.mp.mypage.notify.entity.NotifyConfig;

public interface NotifyConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NotifyConfig record);

    int insertSelective(NotifyConfig record);

    NotifyConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NotifyConfig record);

    int updateByPrimaryKey(NotifyConfig record);
}