package com.service;

import com.service.impl.UserServiceImpl;
import com.service.impl.StudentServiceImpl;

public class ServiceFactory {
    private static final UserService userService = createUserService();
    private static final StudentService studentService = createStudentService();

    private static StudentService createStudentService(){return new StudentServiceImpl();}
    private static UserService createUserService() {
        return new UserServiceImpl();
    }
    public static UserService getUserService() {
        return userService;
    }

    public static StudentService getStudentService() {
        return studentService;
    }
}