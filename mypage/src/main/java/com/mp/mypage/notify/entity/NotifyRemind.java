package com.mp.mypage.notify.entity;

import java.util.Date;

public class NotifyRemind {
    private Long id;

    private Integer type;

    private String sender;

    private String action;

    private String objectType;

    private Long objectId;

    private Date createTime;

    @Override
    public String toString() {
        return "NotifyRemind{" +
                "id=" + id +
                ", type=" + type +
                ", sender='" + sender + '\'' +
                ", action='" + action + '\'' +
                ", objectType='" + objectType + '\'' +
                ", objectId=" + objectId +
                ", createTime=" + createTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public NotifyRemind setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public NotifyRemind setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getSender() {
        return sender;
    }

    public NotifyRemind setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public String getAction() {
        return action;
    }

    public NotifyRemind setAction(String action) {
        this.action = action;
        return this;
    }

    public String getObjectType() {
        return objectType;
    }

    public NotifyRemind setObjectType(String objectType) {
        this.objectType = objectType;
        return this;
    }

    public Long getObjectId() {
        return objectId;
    }

    public NotifyRemind setObjectId(Long objectId) {
        this.objectId = objectId;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public NotifyRemind setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
}