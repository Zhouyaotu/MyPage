package com.mp.mypage.notify.entity;

import java.util.Date;

public class NotifyAnnounce {
    private Long id;

    private String title;

    private String content;

    private Long sender;

    private Date createTime;

    @Override
    public String toString() {
        return "NotifyAnnounce{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", sender=" + sender +
                ", createTime=" + createTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public NotifyAnnounce setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public NotifyAnnounce setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public NotifyAnnounce setContent(String content) {
        this.content = content;
        return this;
    }

    public Long getSender() {
        return sender;
    }

    public NotifyAnnounce setSender(Long sender) {
        this.sender = sender;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public NotifyAnnounce setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }
}