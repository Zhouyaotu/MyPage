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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubjectUserId() {
        return subjectUserId;
    }

    public void setSubjectUserId(Long subjectUserId) {
        this.subjectUserId = subjectUserId;
    }

    public Long getObjectUserId() {
        return objectUserId;
    }

    public void setObjectUserId(Long objectUserId) {
        this.objectUserId = objectUserId;
    }

    public Long getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Long userGroupId) {
        this.userGroupId = userGroupId;
    }

    public Boolean getFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(Boolean followStatus) {
        this.followStatus = followStatus;
    }
}