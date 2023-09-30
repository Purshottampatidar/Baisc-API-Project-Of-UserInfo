package com.example.burning_beetle;

public class UserInfo {
    private String name;
    private int age;

    private String emailId;
    private int userId;

    public UserInfo(String name, int age, String emailId, int userId) {
        this.name = name;
        this.age = age;
        this.emailId = emailId;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
