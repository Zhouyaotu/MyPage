package com.mp.mypage.user.entity;

public class UserFollower {
    private Long id;

    private Long subjectUserId;

    private Long objectUserId;

    private Long userGroupId;

    private Boolean followStatus;

    @Override
    public String toString() {
        return "UserFollower{" +
                "id=" + id +
                ", subjectUserId=" + subjectUserId +
                ", objectUserId=" + objectUserId +
                ", userGroupId=" + userGroupId +
                ", followStatus=" + followStatus +
                '}';
    }

    public Long getId() {
        return id;
    }

    public UserFollower setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getSubjectUserId() {
        return subjectUserId;
    }

    public UserFollower setSubjectUserId(Long subjectUserId) {
        this.subjectUserId = subjectUserId;
        return this;
    }

    public Long getObjectUserId() {
        return objectUserId;
    }

    public UserFollower setObjectUserId(Long objectUserId) {
        this.objectUserId = objectUserId;
        return this;
    }

    public Long getUserGroupId() {
        return userGroupId;
    }

    public UserFollower setUserGroupId(Long userGroupId) {
        this.userGroupId = userGroupId;
        return this;
    }

    public Boolean getFollowStatus() {
        return followStatus;
    }

    public UserFollower setFollowStatus(Boolean followStatus) {
        this.followStatus = followStatus;
        return this;
    }
}