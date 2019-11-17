package com.mp.mypage.user.dto;

public class UserBaseDTO {
    private long uid;
    private String username;
    private byte accountType;
    private byte accountStatus;

    @Override
    public String toString() {
        return "UserBaseDTO{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", accountType=" + accountType +
                ", accountStatus=" + accountStatus +
                '}';
    }

    public long getUid() {
        return uid;
    }

    public UserBaseDTO setUid(long uid) {
        this.uid = uid;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserBaseDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public byte getAccountType() {
        return accountType;
    }

    public UserBaseDTO setAccountType(byte accountType) {
        this.accountType = accountType;
        return this;
    }

    public byte getAccountStatus() {
        return accountStatus;
    }

    public UserBaseDTO setAccountStatus(byte accountStatus) {
        this.accountStatus = accountStatus;
        return this;
    }
}
