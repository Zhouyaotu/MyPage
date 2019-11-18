package com.mp.mypage.user.entity;

import java.util.Date;
import java.util.Objects;

public class UserInfo {
    private Long id;

    private Long userId;

    private Boolean sex;

    private Date birthYear;

    private String homeProvince;

    private String homeCity;

    private String liveProvince;

    private String liveCity;

    private String major;

    private Date enrollmentYear;

    private Boolean workStatus;

    private Boolean emotionStatus;

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", sex=" + sex +
                ", birthYear=" + birthYear +
                ", homeProvince='" + homeProvince + '\'' +
                ", homeCity='" + homeCity + '\'' +
                ", liveProvince='" + liveProvince + '\'' +
                ", liveCity='" + liveCity + '\'' +
                ", major='" + major + '\'' +
                ", enrollmentYear=" + enrollmentYear +
                ", workStatus=" + workStatus +
                ", emotionStatus=" + emotionStatus +
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

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Date birthYear) {
        this.birthYear = birthYear;
    }

    public String getHomeProvince() {
        return homeProvince;
    }

    public void setHomeProvince(String homeProvince) {
        this.homeProvince = homeProvince == null ? null : homeProvince.trim();
    }

    public String getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity == null ? null : homeCity.trim();
    }

    public String getLiveProvince() {
        return liveProvince;
    }

    public void setLiveProvince(String liveProvince) {
        this.liveProvince = liveProvince == null ? null : liveProvince.trim();
    }

    public String getLiveCity() {
        return liveCity;
    }

    public void setLiveCity(String liveCity) {
        this.liveCity = liveCity == null ? null : liveCity.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public Date getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(Date enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public Boolean getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(Boolean workStatus) {
        this.workStatus = workStatus;
    }

    public Boolean getEmotionStatus() {
        return emotionStatus;
    }

    public void setEmotionStatus(Boolean emotionStatus) {
        this.emotionStatus = emotionStatus;
    }
}