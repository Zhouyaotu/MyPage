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

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    public Byte getAccountType() {
        return accountType;
    }

    public void setAccountType(Byte accountType) {
        this.accountType = accountType;
    }

    public String getSafeEmail() {
        return safeEmail;
    }

    public void setSafeEmail(String safeEmail) {
        this.safeEmail = safeEmail == null ? null : safeEmail.trim();
    }

    public Byte getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Byte accountStatus) {
        this.accountStatus = accountStatus;
    }
}