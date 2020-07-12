package com.entity;

public class Student {
    private int id;
    private String name;
    private String sex;
    private String academy;

    public Student(int id, String name, String sex, String academy) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.academy = academy;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }
}
