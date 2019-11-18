package com.mp.mypage.user.dto;

public class UserGroupDTO {
    private Long id;
    private String groupName;

    @Override
    public String toString() {
        return "UserGroupDTO{" +
                "userId=" + id +
                ", groupName='" + groupName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public UserGroupDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getGroupName() {
        return groupName;
    }

    public UserGroupDTO setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }
}
