package com.mp.mypage.user.dto;

public class UserSimpleInfoDTO {
    private long uid;
    private String username;
    private String headImg;
    private String introduction;

    @Override
    public String toString() {
        return "UserSimpleInfoDTO{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", headImg='" + headImg + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }

    public long getUid() {
        return uid;
    }

    public UserSimpleInfoDTO setUid(long uid) {
        this.uid = uid;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserSimpleInfoDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getHeadImg() {
        return headImg;
    }

    public UserSimpleInfoDTO setHeadImg(String headImg) {
        this.headImg = headImg;
        return this;
    }

    public String getIntroduction() {
        return introduction;
    }

    public UserSimpleInfoDTO setIntroduction(String introduction) {
        this.introduction = introduction;
        return this;
    }
}
