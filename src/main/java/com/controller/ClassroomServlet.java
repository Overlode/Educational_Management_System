package com.controller;

import com.entity.Classroom;
import com.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/classroom")
public class ClassroomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("classrooms", ServiceFactory.getTeacherService().getClassrooms());
        req.getSession().setAttribute("courses", ServiceFactory.getTeacherService().getCourse());
        req.getRequestDispatcher("/WEB-INF/jsp/classroom.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = "/error";
        int classroomId = Integer.parseInt(req.getParameter("classroomId"));
        int week = Integer.parseInt(req.getParameter("week"));
        int day = Integer.parseInt(req.getParameter("day"));
        int courseId = Integer.parseInt(req.getParameter("courseId"));
        int time = Integer.parseInt(req.getParameter("time"));
        List<Classroom> classroom = ServiceFactory.getTeacherService().getClassrooms();
        if (classroom.get(classroomId).getWeeks().get(week).getDays().get(day).getSessions().get(time).isStatus()) {
            req.getSession().setAttribute("classroomId", classroomId);
            req.getSession().setAttribute("week", week);
            req.getSession().setAttribute("day", day);
            req.getSession().setAttribute("courseId", courseId);
            req.getSession().setAttribute("time", time);
            url = "/setclass";
        }
        resp.sendRedirect(url);
    }
}
