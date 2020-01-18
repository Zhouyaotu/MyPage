package com.mp.mypage.notify.entity;

import java.util.ArrayList;
import java.util.List;

public class NotifyConfig {
    private Long id;

    private Long userId;

    private Boolean like;

    private Boolean comment;

    private Boolean follow;

    private Boolean publish;

    private Boolean privateMsg;

    private String other;

    @Override
    public String toString() {
        return "NotifyConfig{" +
                "id=" + id +
                ", userId=" + userId +
                ", like=" + like +
                ", comment=" + comment +
                ", follow=" + follow +
                ", publish=" + publish +
                ", privateMsg=" + privateMsg +
                ", other='" + other + '\'' +
                '}';
    }

    public List<Boolean> convertToConfigVector(){
        List<Boolean> vector = new ArrayList<>();
        vector.add(like);
        vector.add(comment);
        vector.add(follow);
        vector.add(publish);
        vector.add(privateMsg);
        return vector;
    }

    public Long getId() {
        return id;
    }

    public NotifyConfig setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public NotifyConfig setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Boolean getLike() {
        return like;
    }

    public NotifyConfig setLike(Boolean like) {
        this.like = like;
        return this;
    }

    public Boolean getComment() {
        return comment;
    }

    public NotifyConfig setComment(Boolean comment) {
        this.comment = comment;
        return this;
    }

    public Boolean getFollow() {
        return follow;
    }

    public NotifyConfig setFollow(Boolean follow) {
        this.follow = follow;
        return this;
    }

    public Boolean getPublish() {
        return publish;
    }

    public NotifyConfig setPublish(Boolean publish) {
        this.publish = publish;
        return this;
    }

    public Boolean getPrivateMsg() {
        return privateMsg;
    }

    public NotifyConfig setPrivateMsg(Boolean privateMsg) {
        this.privateMsg = privateMsg;
        return this;
    }

    public String getOther() {
        return other;
    }

    public NotifyConfig setOther(String other) {
        this.other = other;
        return this;
    }

    public NotifyConfig setDefaultAttr(){
        this.like = true;
        this.comment = true;
        this.follow = true;
        this.publish = true;
        this.privateMsg = true;
        this.other = "{}";
        return this;
    }
}