package com.mp.mypage.user.dto;

import java.util.List;

public class UserIdolDTO {
    private long groupId;
    private String groupName;
    private List<UserSimpleInfoDTO> users;

    @Override
    public String toString() {
        return "UserIdolDTO{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", users=" + users +
                '}';
    }

    public long getGroupId() {
        return groupId;
    }

    public UserIdolDTO setGroupId(long groupId) {
        this.groupId = groupId;
        return this;
    }

    public String getGroupName() {
        return groupName;
    }

    public UserIdolDTO setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public List<UserSimpleInfoDTO> getUsers() {
        return users;
    }

    public UserIdolDTO setUsers(List<UserSimpleInfoDTO> users) {
        this.users = users;
        return this;
    }
}

