package com.entity;

public class Course {
    private int cid;
    private String cName;
    private double score;
    private int countStu;

    public Course(int cid, String cName, double score) {
        this.cid = cid;
        this.cName = cName;
        this.score = score;
    }

    public int getCountStu() {
        return countStu;
    }

    public void setCountStu(int countStu) {
        this.countStu = countStu;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
