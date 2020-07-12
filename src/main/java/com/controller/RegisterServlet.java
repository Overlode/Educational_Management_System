package com.controller;

import com.entity.Teacher;
import com.entity.User;
import com.service.StudentService;
import com.service.TeacherService;
import com.service.impl.StudentServiceImpl;
import com.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    private TeacherService teacherService = new TeacherServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/html/register.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        int userId = Integer.parseInt(req.getParameter("userId"));
        String academy = "信息与计算机工程学院";
        String sex;
        String url = "/register";
        if (req.getParameter("sex").equals("0")) sex = "男";
        else sex = "女";
        switch (Integer.parseInt(req.getParameter("identity"))) {
            case 1:
                academy = "信息与计算机工程学院";
                break;
            case 2:
                academy = "文法学院";
                break;
            case 3:
                academy = "理学院";
                break;
            case 4:
                academy = "生命科学学院";
                break;
            case 5:
                academy = "经济管理学院";
                break;
        }
        int identity = Integer.parseInt(req.getParameter("identity"));//1学生 2老师
        if (identity == 1) {
            if (studentService.register(userName, password, userId, sex, academy)) {
                User u = new User(userId, userName, password, 1);
                req.getSession().setAttribute("user", u);
                url = "/home";
            } else {
                url = "/error";
            }
        } else if (identity == 2) {
            if (teacherService.register(userName, password, userId, sex, academy)) {
                User u = new User(userId, userName, password, 2);
                req.getSession().setAttribute("user", u);
                url = "/home";
            } else {
                url = "/error";
            }
        }
        resp.sendRedirect(url);
    }
}
