package com.service.impl;

import com.entity.Teacher;
import com.service.TeacherService;
import com.util.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherServiceImpl implements TeacherService {
    @Override
    public boolean register(String userName, String password, int userId, String sex, String academy) {
        String sql = "Insert into teacher(id,name,sex,academy,password) values(?,?,?,?,?)";
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
    public Teacher getTeacher(int tid) {
        Teacher t = null;
        String sql = "SELECT * FROM teacher WHERE id=?";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, tid);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    t = new Teacher(rs.getInt("id"), rs.getString("name"), rs.getString("academy"), rs.getString("sex"));
                    t.setEmail(rs.getString("email"));
                    t.setPhone(rs.getString("phone"));
                    t.setCore(rs.getInt("core"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public boolean updateProfile(int id, String name, String academy, String phone, String email, String password) {
        String sql = "update teacher set name=?,academy=? , phone =?,email=?,password=? where id=?";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, name);
            st.setString(2, academy);
            st.setString(3, phone);
            st.setString(4, email);
            st.setString(5, password);
            st.setInt(6, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
