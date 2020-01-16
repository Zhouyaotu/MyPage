package com.mp.mypage.notify.dao;

import com.mp.mypage.notify.entity.NotifyRemind;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NotifyRemindMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NotifyRemind record);

    int insertSelective(NotifyRemind record);

    NotifyRemind selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NotifyRemind record);

    int updateByPrimaryKey(NotifyRemind record);
}