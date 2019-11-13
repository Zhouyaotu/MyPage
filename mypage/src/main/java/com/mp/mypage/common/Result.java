package com.mp.mypage.common;

public class Result {
    private int id;
    private String description;

    public Result(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
