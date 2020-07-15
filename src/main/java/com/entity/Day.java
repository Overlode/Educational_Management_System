package com.entity;

import java.util.ArrayList;
import java.util.List;

public class Day {
    private List<Session> sessions = buildSessions();//一天12节(0) 34节(1) 56节(2) 78节(3) 91011节(4)

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    private List<Session> buildSessions() {
        List<Session> sessions = new ArrayList<>();
        Session s;
        for (int i = 0; i < 6; i++) {
            s = new Session();
            sessions.add(s);
        }
        return sessions;
    }
}
