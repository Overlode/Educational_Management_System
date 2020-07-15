package com.service.impl;

import com.entity.*;
import com.service.ServiceFactory;
import com.service.StudentService;
import com.util.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public Student getStudent(int id) {
        Student s=null;
        List<Score> list = getScoreBySid(id);
        List<Course> courses = ServiceFactory.getTeacherService().getCourse();
        double score = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < courses.size(); j++) {
                if (list.get(i).getCid() == courses.get(j).getCid()) {
                    if (list.get(i).getScore() >= 60) score += courses.get(j).getScore();
                    break;
                }
            }
        }
        String sql = "SELECT * FROM student WHERE id=?";
        try(Connection conn = DataSourceUtils.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, id);
            try(ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    s = new Student(rs.getInt("id"), rs.getString("name"),rs.getString("sex"),rs.getString("academy"));
                    s.setScore(score);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public List<Score> getScoreBySid(int sid) {
        List<Score> list = new ArrayList<>();
        Score s=null;
        String sql = "select course.name,score.score,course.id from score,course where score.ssid = ? and course.id=score.scid";
        try(Connection conn = DataSourceUtils.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, sid);
            try(ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    s = new Score(rs.getInt("id"), sid , rs.getDouble("score"));
                    s.setcName(rs.getString("name"));
                    list.add(s);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<P_P> getP_PBySid(int sid) {
        List<P_P> pplist = new ArrayList<>();
        String sql = "select * from p_p where ppsid = ?";
        P_P pp;
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, sid);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    pp = new P_P(rs.getDate("date"), rs.getString("detail"));
                    pp.setType(rs.getInt("type"));
                    pplist.add(pp);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pplist;
    }

    @Override
    public List<Score> getScoreByCidClassId(int cid, int classId) {
        List<Score> scores = new ArrayList<>();
        String sql = "SELECT score.ssid,score.score,student.name FROM score,student,s_c where score.scid=? and score.ssid=student.id and score.ssid=s_c.scsid and score.scid=s_c.sccid and s_c.classid=? order by score.score desc";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, cid);
            st.setInt(2, classId);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Score s = new Score(cid, rs.getInt("ssid"), rs.getDouble("score"));
                    s.setsName(rs.getString("name"));
                    scores.add(s);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scores;
    }

    @Override
    public boolean register(String userName, String password, int userId, String sex, String academy) {
        String sql = "Insert into student values(?,?,?,?,?)";//Insert into student values(2017212421,"林北王雷","男","理学院","123456")
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
        ) {
            st.setInt(1, userId);
            st.setString(2, userName);
            st.setString(3, sex);
            st.setString(4, academy);
            st.setString(5, password);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<PassRequest> getRequests(int sid) {
        List<PassRequest> requests = new ArrayList<>();
        String sql = "select * from request where rsid = ?";
        PassRequest pr;
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, sid);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    pr = new PassRequest(rs.getInt("confirm"), rs.getInt("rsid"), rs.getInt("count"));
                    requests.add(pr);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    @Override
    public List<PassRequest> getAllRequests() {
        List<PassRequest> requests = new ArrayList<>();
        String sql = "select * from request";
        PassRequest pr;
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    pr = new PassRequest(rs.getInt("confirm"), rs.getInt("rsid"), rs.getInt("count"));
                    pr.setEmail(rs.getString("email"));
                    requests.add(pr);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    @Override
    public boolean updateRequest(int sid, String date, String email) {
        String sql = "Insert into request(rsid,date,email) values(?,?,?)";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
        ) {
            st.setInt(1, sid);
            st.setString(2, date);
            st.setString(3, email);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Score> newScores(int classId, int cid) {
        List<Score> scores = new ArrayList<>();
        String sql = "SELECT student.name,scsid,sccid FROM s_c,student where sccid=? and classid = ? and status=0 and scsid=id";
        Score s;
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
        ) {
            st.setInt(1, cid);
            st.setInt(2, classId);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    s = new Score(cid, rs.getInt("scsid"), 0);
                    s.setsName(rs.getString("name"));
                    s.setClassId(classId);
                    scores.add(s);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scores;
    }

    @Override
    public boolean uploadScore(int sid, int cid, double score) {
        String sql = "insert into score(ssid,scid,score) values(?,?,?)";
        String sqll = "update s_c set status = 1 where scsid = ? and status =0 and sccid = ?";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
             PreparedStatement stt = conn.prepareStatement(sqll)
        ) {
            st.setInt(1, sid);
            st.setInt(2, cid);
            st.setDouble(3, score);
            stt.setInt(1, sid);
            stt.setInt(2, cid);
            st.executeUpdate();
            stt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    @Override
    public PassRequest getCurrentRequest(int sid) {
        String sql = "select * from request where rsid = ? and confirm = 0";
        PassRequest pr = null;
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, sid);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    pr = new PassRequest(rs.getInt("confirm"), rs.getInt("rsid"), rs.getInt("count"));
                    pr.setEmail(rs.getString("email"));
                    pr.setDate(rs.getDate("date"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pr;
    }
}
