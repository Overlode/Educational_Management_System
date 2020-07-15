package com.entity;

import java.sql.Date;

public class Task {
    private String date;
    private int cid;
    private String detail;
    private String cName;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Task(String date, int cid, String detail, String cName) {
        this.date = date;
        this.cid = cid;
        this.detail = detail;
        this.cName = cName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
}
