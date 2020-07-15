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

@WebServlet("/course")
public class CourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user.getType() == 3) {
            int cid = Integer.parseInt(req.getParameter("cid"));
            Course course = null;
            for (int i = 0; i < ServiceFactory.getTeacherService().getCourse().size(); i++) {
                if (ServiceFactory.getTeacherService().getCourse().get(i).getCid() == cid) {
                    course = ServiceFactory.getTeacherService().getCourse().get(i);
                    break;
                }
            }
            req.getSession().setAttribute("course", course);
            req.getRequestDispatcher("/WEB-INF/jsp/course.jsp").forward(req, resp);
        } else {
            ErrorMessage errorMessage = new ErrorMessage("权限不足", "请重新登录后再尝试", "You don't have permission to access the URL on this server.");
            req.getSession().setAttribute("errorMessage", errorMessage);
            req.getRequestDispatcher("/error").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cid = Integer.parseInt(req.getParameter("cid"));
        String cName = new String(req.getParameter("cName").getBytes("iso-8859-1"), "utf-8");
        double cScore = Double.parseDouble(req.getParameter("cScore"));
        String url = "";
        if (ServiceFactory.getTeacherService().updateCourse(cid, cName, cScore)) {
            url = "/classroom";
        } else {
            ErrorMessage errorMessage = new ErrorMessage("操作失败", "请联系数据库管理员", "Please make contact with admin");
            req.getSession().setAttribute("errorMessage", errorMessage);
            url = "/error";
        }
        resp.sendRedirect(url);
    }
}
