package com.mp.mypage.user.dao;

import com.mp.mypage.user.dto.UserIdolDTO;
import com.mp.mypage.user.dto.UserSimpleInfoDTO;
import com.mp.mypage.user.entity.UserFollower;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface UserFollowerMapper {
    int deleteByPrimaryKey(Long id);

    int deleteByUserIdPair(long srcId, long destId);

    int insert(UserFollower record) throws DataAccessException;

    int insertSelective(UserFollower record) throws DataAccessException;

    UserFollower selectByPrimaryKey(Long id);

    UserFollower selectByUserPair(UserFollower userFollower);

    List<UserSimpleInfoDTO> selectAllFollowerByUserId(long destId);

    List<Long> selectAllIdolByGroupId(long groupId);

    List<UserIdolDTO> selectAllIdolByUserId(long srcId);

    int updateByPrimaryKeySelective(UserFollower record);

    int updateByPrimaryKey(UserFollower record);

    int updateByUserIdPairSelective(UserFollower record);
}