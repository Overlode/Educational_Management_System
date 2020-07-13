package com.service;

import com.entity.Teacher;

public interface TeacherService {
    public boolean register(String userName, String password, int userId, String sex, String academy);

    public Teacher getTeacher(int tid);

    public boolean updateProfile(int id, String name, String academy, String phone, String email, String password);
}
