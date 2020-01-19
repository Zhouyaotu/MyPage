package com.mp.mypage.notify.dao;

import com.mp.mypage.notify.entity.NotifyBox;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface NotifyBoxMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NotifyBox record);

    int insertSelective(NotifyBox record);

    NotifyBox selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NotifyBox record);

    int updateByPrimaryKey(NotifyBox record);

////////////////////////////////////////////////////////
    Date selectLatestNotifyTime(Long userId, Integer notifyType);
    List<NotifyBox> selectByUserId(Long userId);

}