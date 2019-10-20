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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLabelContent() {
        return labelContent;
    }

    public void setLabelContent(String labelContent) {
        this.labelContent = labelContent == null ? null : labelContent.trim();
    }

    public Byte getLabelType() {
        return labelType;
    }

    public void setLabelType(Byte labelType) {
        this.labelType = labelType;
    }
}