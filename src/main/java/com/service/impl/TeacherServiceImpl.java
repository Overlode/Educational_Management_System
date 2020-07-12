package com.service.impl;

import com.service.TeacherService;
import com.util.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
