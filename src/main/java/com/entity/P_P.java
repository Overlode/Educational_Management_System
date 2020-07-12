package com.entity;

import java.util.Date;

public class P_P {
    private Date date;
    private String detail;
    private int type;
    public P_P(Date date, String detail) {
        this.date = date;
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
