package com.controller;

import com.entity.ErrorMessage;
import com.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletetask")
public class DeleteTaskServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] count = req.getParameterValues("deleteCount");
        String url = "/classroom";
        for (int i = 0; i < count.length; i++) {
            int id = Integer.parseInt(count[i]);
            if (!ServiceFactory.getTeacherService().deleteTask(id)) {
                ErrorMessage errorMessage = new ErrorMessage("操作失败", "请联系数据库管理员", "Please make contact with admin");
                req.getSession().setAttribute("errorMessage", errorMessage);
                url = "/error";
                break;
            }
        }
        resp.sendRedirect(url);
    }
}
