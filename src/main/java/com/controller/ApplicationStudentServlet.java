package com.controller;

import com.service.StudentService;
import com.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.*;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/application-student")
public class ApplicationStudentServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/application-student.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = new String(req.getParameter("userName").getBytes("iso-8859-1"), "utf-8");
        int userId = Integer.parseInt(req.getParameter("userId"));
        String d = req.getParameter("date");
        String email = req.getParameter("email");
        String academy = new String(req.getParameter("academy").getBytes("iso-8859-1"), "utf-8");
        String url;
        if (studentService.updateRequest(userId, d, email)) {
            url = "/home";
        } else {
            url = "/error";
        }
        resp.sendRedirect(url);
    }
}
