package com.controller;

import com.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/scoremodel")
public class ScoreModelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("courses", ServiceFactory.getTeacherService().getCourse());
        req.getRequestDispatcher("/WEB-INF/jsp/scoremodel.jsp").forward(req, resp);
    }
}
