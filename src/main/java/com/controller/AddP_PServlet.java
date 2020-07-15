package com.controller;

import com.entity.ErrorMessage;
import com.entity.Student;
import com.entity.User;
import com.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/teacher/stu-list/add")
public class AddP_PServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getAttribute("user");
        if (user.getType() == 3) {
            int sid = Integer.parseInt(req.getParameter("sid"));
            Student student = ServiceFactory.getStudentService().getStudent(sid);
            req.setAttribute("student", student);
            req.getRequestDispatcher("/WEB-INF/jsp/add-pp.jsp").forward(req, resp);
        } else {
            ErrorMessage errorMessage = new ErrorMessage("权限不足", "请重新登录后再尝试", "You don't have permission to access the URL on this server.");
            req.getSession().setAttribute("errorMessage", errorMessage);
            req.getRequestDispatcher("/error").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceFactory.getTeacherService().addP_P(
                Integer.parseInt(req.getParameter("sid")),
                req.getParameter("date"),
                Integer.parseInt(req.getParameter("type")),
                new String(req.getParameter("detail").getBytes("iso-8859-1"), "utf-8"));
        resp.sendRedirect("/teacher");
    }
}
