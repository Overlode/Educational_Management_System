package com.entity;

public class PassRequest {
    private int confirm;
    private int sid;
    private int id;

    public int getConfirm() {
        return confirm;
    }

    public void setConfirm(int confirm) {
        this.confirm = confirm;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PassRequest(int confirm, int sid, int id) {
        this.confirm = confirm;
        this.sid = sid;
        this.id = id;
    }
}
