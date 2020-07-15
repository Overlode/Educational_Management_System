package com.controller;

import com.entity.PassRequest;
import com.entity.Score;
import com.entity.Student;
import com.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacher/application-teacher/check")
public class ApplicationTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sid = Integer.parseInt(req.getParameter("sid"));
        Student student = ServiceFactory.getStudentService().getStudent(sid);
        req.setAttribute("student", student);
        PassRequest passRequest = ServiceFactory.getStudentService().getCurrentRequest(sid);
        req.setAttribute("passrequest", passRequest);
        List<Score> scores = ServiceFactory.getStudentService().getScoreBySid(sid);
        req.setAttribute("scores", scores);
        req.getRequestDispatcher("/WEB-INF/jsp/application-teacher.jsp").forward(req, resp);
    }

}
