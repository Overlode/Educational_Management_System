package com.controller;

import com.entity.Course;
import com.entity.ErrorMessage;
import com.entity.User;
import com.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacher/application-teacher/check/allow")
public class ApplicationAllowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user.getType() == 3) {
            int sid = Integer.parseInt(req.getParameter("sid"));
            ServiceFactory.getTeacherService().ApplicationAllow(sid);
            req.getRequestDispatcher("/WEB-INF/jsp/teacher.jsp").forward(req, resp);
        } else {
            ErrorMessage errorMessage = new ErrorMessage("权限不足", "请重新登录后再尝试", "You don't have permission to access the URL on this server.");
            req.getSession().setAttribute("errorMessage", errorMessage);
            req.getRequestDispatcher("/error").forward(req, resp);
        }
    }
}
