package com.entity;

public class Teacher {
    private int id;
    private String name;
    private String academy;
    private String sex;
    private String email;
    private String phone;
    private int core;

    public int getCore() {
        return core;
    }

    public void setCore(int core) {
        this.core = core;
    }

    public Teacher(int id, String name, String academy, String sex) {
        this.id = id;
        this.name = name;
        this.academy = academy;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
