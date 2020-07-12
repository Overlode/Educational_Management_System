package com.controller;

import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.service.impl.UserServiceImpl;

@WebServlet("/testr")
public class TestRServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/testR.jsp").forward(req, resp);
    }

    /*@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        int userId = Integer.parseInt(req.getParameter("userId"));
        String academy;
        String sex;
        if(req.getParameter("sex").equals("0")) sex="男";
        else sex="女";
        switch (Integer.parseInt(req.getParameter("identity"))){
            case 1:academy="信息与计算机工程学院";break;
            case 2:academy="文法学院";break;
            case 3:academy="理学院";break;
            case 4:academy="生命科学学院";break;
            case 5:academy="经济管理学院";break;
        }
        int identity=Integer.parseInt(req.getParameter("identity"));//1学生 2老师
        if(identity==1){

        }
        else if(identity==2){

        }
    }*/
}
