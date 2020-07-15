package com.entity;

public class ErrorMessage {
    private String tip1;
    private String tip2;
    private String tip3;

    public ErrorMessage(String tip1, String tip2, String tip3) {
        this.tip1 = tip1;
        this.tip2 = tip2;
        this.tip3 = tip3;
    }

    public String getTip1() {
        return tip1;
    }

    public void setTip1(String tip1) {
        this.tip1 = tip1;
    }

    public String getTip2() {
        return tip2;
    }

    public void setTip2(String tip2) {
        this.tip2 = tip2;
    }

    public String getTip3() {
        return tip3;
    }

    public void setTip3(String tip3) {
        this.tip3 = tip3;
    }
}
