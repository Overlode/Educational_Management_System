package com.controller;

import com.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/setclass")
public class SetClassServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int[] list = ServiceFactory.getTeacherService().getClassNum(((int) req.getSession().getAttribute("courseId")));
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (list[i] != -1) {
                count++;
            }
        }
        if (count == 0) {
            resp.sendRedirect("/error");
        } else {
            req.getSession().setAttribute("classNum", list);
            req.getSession().setAttribute("classNumCount", count);
            req.getRequestDispatcher("/WEB-INF/jsp/setclass.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int classroomId = (int) req.getSession().getAttribute("classroomId");
        int week = (int) req.getSession().getAttribute("week");
        int day = (int) req.getSession().getAttribute("day");
        int courseId = (int) req.getSession().getAttribute("courseId");
        int time = (int) req.getSession().getAttribute("time");
        int classNum = Integer.parseInt(req.getParameter("cNum"));
        String url;
        if (ServiceFactory.getTeacherService().uploadSession(courseId, classNum, week, day, time, classroomId)) {
            url = "/teacher";
        } else {
            url = "/error";
        }
        resp.sendRedirect(url);
    }
}
