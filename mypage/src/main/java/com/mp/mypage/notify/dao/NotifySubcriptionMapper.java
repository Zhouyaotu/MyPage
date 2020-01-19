package com.mp.mypage.notify.dao;

import com.mp.mypage.notify.entity.NotifySubcription;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotifySubcriptionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NotifySubcription record);

    int insertSelective(NotifySubcription record);

    NotifySubcription selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NotifySubcription record);

    int updateByPrimaryKey(NotifySubcription record);

    //////////////////////////////////////////////////////////
    List<NotifySubcription> selectByUserId(Long userId);
    int deleteByDetail(Long userId, Integer subjectType, Long subjectId, Integer action);
}