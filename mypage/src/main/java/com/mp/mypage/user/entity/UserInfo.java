package com.mp.mypage.user.entity;

import java.util.Date;
import java.util.Objects;

public class UserInfo {
    private Long id;

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

    public UserInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public Boolean getSex() {
        return sex;
    }

    public UserInfo setSex(Boolean sex) {
        this.sex = sex;
        return this;
    }

    public Date getBirthYear() {
        return birthYear;
    }

    public UserInfo setBirthYear(Date birthYear) {
        this.birthYear = birthYear;
        return this;
    }

    public String getHomeProvince() {
        return homeProvince;
    }

    public UserInfo setHomeProvince(String homeProvince) {
        this.homeProvince = homeProvince;
        return this;
    }

    public String getHomeCity() {
        return homeCity;
    }

    public UserInfo setHomeCity(String homeCity) {
        this.homeCity = homeCity;
        return this;
    }

    public String getLiveProvince() {
        return liveProvince;
    }

    public UserInfo setLiveProvince(String liveProvince) {
        this.liveProvince = liveProvince;
        return this;
    }

    public String getLiveCity() {
        return liveCity;
    }

    public UserInfo setLiveCity(String liveCity) {
        this.liveCity = liveCity;
        return this;
    }

    public String getMajor() {
        return major;
    }

    public UserInfo setMajor(String major) {
        this.major = major;
        return this;
    }

    public Date getEnrollmentYear() {
        return enrollmentYear;
    }

    public UserInfo setEnrollmentYear(Date enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
        return this;
    }

    public Boolean getWorkStatus() {
        return workStatus;
    }

    public UserInfo setWorkStatus(Boolean workStatus) {
        this.workStatus = workStatus;
        return this;
    }

    public Boolean getEmotionStatus() {
        return emotionStatus;
    }

    public UserInfo setEmotionStatus(Boolean emotionStatus) {
        this.emotionStatus = emotionStatus;
        return this;
    }
}