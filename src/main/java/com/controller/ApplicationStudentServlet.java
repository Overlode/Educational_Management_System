package com.controller;

import com.entity.ErrorMessage;
import com.entity.User;
import com.service.ServiceFactory;
import com.service.StudentService;
import com.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/application-student")
public class ApplicationStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user.getType() == 1) {
            req.getRequestDispatcher("/WEB-INF/jsp/application-student.jsp").forward(req, resp);
        } else {
            ErrorMessage errorMessage = new ErrorMessage("权限不足", "请重新登录后再尝试", "You don't have permission to access the URL on this server.");
            req.getSession().setAttribute("errorMessage", errorMessage);
            req.getRequestDispatcher("/error").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        String d = req.getParameter("date");
        String email = req.getParameter("email");
        String url;
        if (ServiceFactory.getStudentService().updateRequest(userId, d, email)) {
            url = "/home";
        } else {
            url = "/error";
        }
        resp.sendRedirect(url);
    }
}
