package com.service.impl;

import com.entity.User;
import com.service.UserService;
import com.util.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserServiceImpl implements UserService{
    @Override
    public User getUser(int id , String password) {
        User user = null;
        String sql = "SELECT * FROM student WHERE id=? AND password = ?";
        try(Connection conn = DataSourceUtils.getConnection();
            PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, id);
            st.setString(2, password);
            try(ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"),1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(user==null){
            sql = "SELECT * FROM teacher WHERE id=? AND password = ?";
            try(Connection conn = DataSourceUtils.getConnection();
                PreparedStatement st = conn.prepareStatement(sql)) {
                st.setInt(1, id);
                st.setString(2, password);
                try(ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        if(rs.getInt("core")==0) user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"),2);
                        else user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"),3);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
