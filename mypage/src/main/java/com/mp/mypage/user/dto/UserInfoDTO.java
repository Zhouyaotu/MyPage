package com.mp.mypage.user.dto;

import com.mp.mypage.user.entity.UserInfo;

public class UserInfoDTO {
    private UserBaseDTO base;
    private UserInfo detail;

    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "base=" + base +
                ", detail=" + detail +
                '}';
    }

    public UserBaseDTO getBase() {
        return base;
    }

    public UserInfoDTO setBase(UserBaseDTO base) {
        this.base = base;
        return this;
    }

    public UserInfo getDetail() {
        return detail;
    }

    public UserInfoDTO setDetail(UserInfo detail) {
        this.detail = detail;
        return this;
    }
}
