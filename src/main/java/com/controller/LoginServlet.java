package com.controller;


import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.service.impl.UserServiceImpl;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserServiceImpl userService = new UserServiceImpl();
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
        user=userService.getUser(id,password);
        String url= "/login";
        if(user!=null){
            if(user.getType()==1){
                req.getSession().setAttribute("user", user);
                url = "/home";
            }
        }
        else{
            url = "/login";
        }
        resp.sendRedirect(url);
    }
}