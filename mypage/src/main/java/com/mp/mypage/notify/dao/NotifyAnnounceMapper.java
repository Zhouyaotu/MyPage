package com.mp.mypage.notify.dao;

import com.mp.mypage.notify.entity.NotifyAnnounce;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface NotifyAnnounceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NotifyAnnounce record);

    int insertSelective(NotifyAnnounce record);

    NotifyAnnounce selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NotifyAnnounce record);

    int updateByPrimaryKey(NotifyAnnounce record);

    List<NotifyAnnounce> selectLaterThan(Date creatTime);
}