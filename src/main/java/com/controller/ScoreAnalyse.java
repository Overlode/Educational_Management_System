package com.controller;

import com.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/scoreanalyse")
public class ScoreAnalyse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("result", ServiceFactory.getTeacherService().analyseByCid(Integer.parseInt(req.getParameter("cid"))));
        req.getRequestDispatcher("/WEB-INF/jsp/scoreanalyse.jsp").forward(req, resp);
    }
}
