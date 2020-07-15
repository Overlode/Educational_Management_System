package com.entity;

import java.util.ArrayList;
import java.util.List;

public class Week {
    private List<Day> days = buildDays();//周一1周二2周三3周四4周五5周六6周日7

    private List<Day> buildDays() {
        List<Day> list = new ArrayList<>();
        Day d;
        for (int i = 0; i < 8; i++) {
            d = new Day();
            list.add(d);
        }
        return list;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }
}
