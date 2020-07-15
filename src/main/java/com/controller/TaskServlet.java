package com.controller;

import com.entity.Task;
import com.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/task")
public class TaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cid = Integer.parseInt(req.getParameter("cid"));
        List<Task> list = ServiceFactory.getTeacherService().getTask(cid);
        req.getSession().setAttribute("tasks", list);
        req.getRequestDispatcher("/WEB-INF/jsp/task.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String d = req.getParameter("date");
        int cid = Integer.parseInt(req.getParameter("cid"));
        String detail = new String(req.getParameter("detail").getBytes("iso-8859-1"), "utf-8");
        String url;
        if (ServiceFactory.getTeacherService().uploadTask(cid, d, detail)) {
            url = "/teacher";
        } else {
            url = "/error";
        }
        resp.sendRedirect(url);
    }
}