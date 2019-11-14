package com.mp.mypage.common;

public class Result {
    private int id;
    private String description;
    private Object attribute;

    public Result(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Result setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getAttribute() {
        return attribute;
    }

    public Result setAttribute(Object attribute) {
        this.attribute = attribute;
        return this;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
