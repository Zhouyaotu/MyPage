package com.mp.mypage.user.entity;

public class UserGroup {
    private Long id;

    private Long userId;

    private String groupName;

    @Override
    public String toString() {
        return "UserGroup{" +
                "id=" + id +
                ", userId=" + userId +
                ", groupName='" + groupName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public UserGroup setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public UserGroup setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getGroupName() {
        return groupName;
    }

    public UserGroup setGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }
}