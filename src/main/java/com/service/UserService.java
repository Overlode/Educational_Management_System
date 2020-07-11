package com.service;

import com.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 基于ID获取指定用户
     * @param id
     * @return
     */
    public User login(int id,String password);
}
