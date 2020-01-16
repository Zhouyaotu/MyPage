package com.mp.mypage.notify.entity;

import java.util.Date;

public class NotifySubcription {
    private Long id;

    private Long userId;

    private Integer subjectType;

    private Long subjectId;

    private Integer subjectAction;

    private Date createTime;

    @Override
    public String toString() {
        return "NotifySubcription{" +
                "id=" + id +
                ", userId=" + userId +
                ", subjectType=" + subjectType +
                ", subjectId=" + subjectId +
                ", subjectAction=" + subjectAction +
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

    public Integer getSubjectType() {
        return subjectType;
    }

    public NotifySubcription setSubjectType(Integer subjectType) {
        this.subjectType = subjectType;
        return this;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public NotifySubcription setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
        return this;
    }

    public Integer getSubjectAction() {
        return subjectAction;
    }

    public NotifySubcription setSubjectAction(Integer subjectAction) {
        this.subjectAction = subjectAction;
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