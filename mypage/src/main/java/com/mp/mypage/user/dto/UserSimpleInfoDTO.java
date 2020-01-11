package com.mp.mypage.user.dto;

public class UserSimpleInfoDTO {
    private long uid;
    private String username;
    private String headImg;

    @Override
    public String toString() {
        return "UserSimpleInfo{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", headImg='" + headImg + '\'' +
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
}
