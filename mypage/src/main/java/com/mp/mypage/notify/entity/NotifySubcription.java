package com.mp.mypage.notify.entity;

import java.util.Date;

public class NotifySubcription {
    private Long id;

    private Long userId;

    private Long objectId;

    private String objectType;

    private Date createTime;

    @Override
    public String toString() {
        return "NotifySubcription{" +
                "id=" + id +
                ", userId=" + userId +
                ", objectId=" + objectId +
                ", objectType='" + objectType + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public NotifySubcription setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public NotifySubcription setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getObjectId() {
        return objectId;
    }

    public NotifySubcription setObjectId(Long objectId) {
        this.objectId = objectId;
        return this;
    }

    public String getObjectType() {
        return objectType;
    }

    public NotifySubcription setObjectType(String objectType) {
        this.objectType = objectType;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public NotifySubcription setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
}