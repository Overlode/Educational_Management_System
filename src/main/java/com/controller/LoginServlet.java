package com.controller;


import com.entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.service.ServiceFactory;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/html/login.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=null;
        String userName = req.getParameter("username");
        int id=Integer.parseInt(userName);
        String password = req.getParameter("password");
        user = ServiceFactory.getUserService().login(id, password);
        String url= "/login";
        if(user!=null){
            req.getSession().setAttribute("user", user);
            if (user.getType() == 1) {
                url = "/home";
            } else if (user.getType() == 2 || user.getType() == 3) {
                url = "/teacher";
            }
        }
        else{
            ErrorMessage errorMessage = new ErrorMessage("登录失败", "请检查帐号与密码", "Please check account and password");
            req.getSession().setAttribute("errorMessage", errorMessage);
            url = "/error";
        }
        resp.sendRedirect(url);
    }
}