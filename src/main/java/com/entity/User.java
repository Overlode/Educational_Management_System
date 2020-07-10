package com.entity;

public class User {
    private int id;
    private String userName;
    private String password;
    private int type;

    public User(int id, String userName, String password, int type) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.type = type; //1学生 2老师 3管理员
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
