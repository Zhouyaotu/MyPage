package com.mp.mypage.notify.entity;

import java.util.Date;

public class NotifyRemind {
    private Long id;

    private Integer type;

    private Integer subjectType;

    private Long subjectId;

    private Integer action;

    private Integer objectType;

    private Long objectId;

    private Date createTime;

    @Override
    public String toString() {
        return "NotifyRemind{" +
                "id=" + id +
                ", type=" + type +
                ", subjectType=" + subjectType +
                ", subjectId=" + subjectId +
                ", action=" + action +
                ", objectType=" + objectType +
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

    public Integer getSubjectType() {
        return subjectType;
    }

    public NotifyRemind setSubjectType(Integer subjectType) {
        this.subjectType = subjectType;
        return this;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public NotifyRemind setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
        return this;
    }

    public Integer getAction() {
        return action;
    }

    public NotifyRemind setAction(Integer action) {
        this.action = action;
        return this;
    }

    public Integer getObjectType() {
        return objectType;
    }

    public NotifyRemind setObjectType(Integer objectType) {
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