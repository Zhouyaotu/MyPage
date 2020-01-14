package com.mp.mypage.notify.dao;

import com.mp.mypage.notify.entity.NotifyAnnounce;

public interface NotifyAnnounceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NotifyAnnounce record);

    int insertSelective(NotifyAnnounce record);

    NotifyAnnounce selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NotifyAnnounce record);

    int updateByPrimaryKey(NotifyAnnounce record);
}