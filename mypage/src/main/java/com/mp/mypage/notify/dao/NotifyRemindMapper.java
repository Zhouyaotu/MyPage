package com.mp.mypage.notify.dao;

import com.mp.mypage.notify.entity.NotifyRemind;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface NotifyRemindMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NotifyRemind record);

    int insertSelective(NotifyRemind record);

    NotifyRemind selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NotifyRemind record);

    int updateByPrimaryKey(NotifyRemind record);

    /////////////////////////////////////////////////////
    List<NotifyRemind> selectSubscribedRemind(Long userId, Date createTime);
}