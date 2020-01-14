package com.mp.mypage.notify.entity;

public class NotifyConfig {
    private Long id;

    private Integer userId;

    private String config;

    @Override
    public String toString() {
        return "NotifyConfig{" +
                "id=" + id +
                ", userId=" + userId +
                ", config='" + config + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public NotifyConfig setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public NotifyConfig setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getConfig() {
        return config;
    }

    public NotifyConfig setConfig(String config) {
        this.config = config;
        return this;
    }
}