package com.mp.mypage.notify.entity;

import java.util.Date;

public class NotifyBox {
    private Long id;

    private Boolean isRead;

    private Long userId;

    private Integer notifyType;

    private Long notifyId;

    private Date createTime;

    @Override
    public String toString() {
        return "NotifyBox{" +
                "id=" + id +
                ", isRead=" + isRead +
                ", userId=" + userId +
                ", notifyType=" + notifyType +
                ", notifyId=" + notifyId +
                ", createTime=" + createTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public NotifyBox setId(Long id) {
        this.id = id;
        return this;
    }

    public Boolean getRead() {
        return isRead;
    }

    public NotifyBox setRead(Boolean read) {
        isRead = read;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public NotifyBox setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Integer getNotifyType() {
        return notifyType;
    }

    public NotifyBox setNotifyType(Integer notifyType) {
        this.notifyType = notifyType;
        return this;
    }

    public Long getNotifyId() {
        return notifyId;
    }

    public NotifyBox setNotifyId(Long notifyId) {
        this.notifyId = notifyId;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public NotifyBox setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
}