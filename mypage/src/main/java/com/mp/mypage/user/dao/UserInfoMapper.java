package com.mp.mypage.user.dao;

import com.mp.mypage.user.dto.UserInfoDTO;
import com.mp.mypage.user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    List<UserInfo> selectAll();

    UserInfoDTO selectDTOByUserId(Long id);

    List<UserInfoDTO> selectAllDTO();

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}