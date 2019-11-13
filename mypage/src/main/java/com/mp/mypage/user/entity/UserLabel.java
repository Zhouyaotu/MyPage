package com.mp.mypage.user.entity;

public class UserLabel {
    private Long id;

    private Long userId;

    private String labelContent;

    private Byte labelType;

    @Override
    public String toString() {
        return "UserLabel{" +
                "id=" + id +
                ", userId=" + userId +
                ", labelContent='" + labelContent + '\'' +
                ", labelType=" + labelType +
                '}';
    }

    public Long getId() {
        return id;
    }

    public UserLabel setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public UserLabel setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getLabelContent() {
        return labelContent;
    }

    public UserLabel setLabelContent(String labelContent) {
        this.labelContent = labelContent;
        return this;
    }

    public Byte getLabelType() {
        return labelType;
    }

    public UserLabel setLabelType(Byte labelType) {
        this.labelType = labelType;
        return this;
    }
}