package com.mp.mypage.user.entity;

public class UserBase {
    private Long id;

    private String username;

    private String password;

    private String headImg;

    private Byte accountType;

    private String safeEmail;

    private Byte accountStatus;

    @Override
    public String toString() {
        return "UserBase{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", headImg='" + headImg + '\'' +
                ", accountType=" + accountType +
                ", safeEmail='" + safeEmail + '\'' +
                ", accountStatus=" + accountStatus +
                '}';
    }

    public Long getId() {
        return id;
    }

    public UserBase setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserBase setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserBase setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getHeadImg() {
        return headImg;
    }

    public UserBase setHeadImg(String headImg) {
        this.headImg = headImg;
        return this;
    }

    public Byte getAccountType() {
        return accountType;
    }

    public UserBase setAccountType(Byte accountType) {
        this.accountType = accountType;
        return this;
    }

    public String getSafeEmail() {
        return safeEmail;
    }

    public UserBase setSafeEmail(String safeEmail) {
        this.safeEmail = safeEmail;
        return this;
    }

    public Byte getAccountStatus() {
        return accountStatus;
    }

    public UserBase setAccountStatus(Byte accountStatus) {
        this.accountStatus = accountStatus;
        return this;
    }
}