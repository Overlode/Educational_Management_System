package com.service.impl;

import com.entity.P_P;
import com.entity.Score;
import com.entity.Student;
import com.service.StudentService;
import com.util.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public Student getStudent(int id) {
        Student s=null;
        String sql = "SELECT * FROM student WHERE id=?";
        try(Connection conn = DataSourceUtils.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, id);
            try(ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    s = new Student(rs.getInt("id"), rs.getString("name"),rs.getString("sex"),rs.getString("academy"));
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
        return null;
    }

    @Override
    public List<Score> getScoreByCid(int cid) {
        List<Score> scores = new ArrayList<>();
        String sql = "SELECT score.ssid,score.score,student.name FROM score,student,s_c where score.scid=? and score.ssid=student.id and score.ssid=s_c.scsid and score.scid=s_c.sccid order by score.score desc";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, cid);
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
        String sql = "Insert into student values(?,?,?,?,?)";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
        ) {
            st.setInt(1, userId);
            st.setString(2, userName);
            st.setString(3, sex);
            st.setString(4, academy);
            st.setString(5, password);
            st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
