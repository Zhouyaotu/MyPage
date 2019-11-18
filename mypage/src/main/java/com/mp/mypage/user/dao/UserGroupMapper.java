package com.mp.mypage.user.dao;

import com.mp.mypage.user.dto.UserGroupDTO;
import com.mp.mypage.user.entity.UserGroup;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface UserGroupMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserGroup record) throws DataAccessException;

    int insertSelective(UserGroup record);

    UserGroup selectByPrimaryKey(Long id);

    List<UserGroup> selectAll();

    List<UserGroupDTO> selectUserGroupByUserId(Long userId);

    int updateByPrimaryKeySelective(UserGroup record);

    int updateByPrimaryKey(UserGroup record);
}