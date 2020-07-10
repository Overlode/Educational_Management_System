package com.service.impl;

import com.entity.Student;
import com.service.StudentService;
import com.util.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
