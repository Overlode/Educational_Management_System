package com.service;

import com.entity.Teacher;
import com.service.impl.TeacherServiceImpl;
import com.service.impl.UserServiceImpl;
import com.service.impl.StudentServiceImpl;

public class ServiceFactory {
    private static final UserService userService = createUserService();
    private static final StudentService studentService = createStudentService();
    private static final TeacherService teacherService = createTeacherService();

    private static StudentService createStudentService(){return new StudentServiceImpl();}
    private static UserService createUserService() {
        return new UserServiceImpl();
    }

    private static TeacherService createTeacherService() {
        return new TeacherServiceImpl();
    }

    public static UserService getUserService() {
        return userService;
    }
    public static StudentService getStudentService() {
        return studentService;
    }

    public static TeacherService getTeacherService() {
        return teacherService;
    }
}