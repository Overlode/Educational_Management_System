package com.entity;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private List<Week> weeks = buildWeeks();//周数
    private String roomName;
    private int roomId;
    private int maxStudent;

    public Classroom(String roomName, int roomId, int maxStudent) {
        this.roomName = roomName;
        this.roomId = roomId;
        this.maxStudent = maxStudent;
    }

    public int getMaxStudent() {
        return maxStudent;
    }

    public void setMaxStudent(int maxStudent) {
        this.maxStudent = maxStudent;
    }

    private List<Week> buildWeeks() {
        List<Week> list = new ArrayList<>();
        Week wk;
        for (int i = 0; i < 21; i++) {
            wk = new Week();
            list.add(wk);
        }
        return list;
    }

    public List<Week> getWeeks() {
        return weeks;
    }

    public void setWeeks(List<Week> weeks) {
        this.weeks = weeks;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}




