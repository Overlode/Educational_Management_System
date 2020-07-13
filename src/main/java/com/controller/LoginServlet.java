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
            List<PassRequest> requests = null;
            if (user.getType() == 1) {
                requests = ServiceFactory.getStudentService().getRequests(id);
                Student s = ServiceFactory.getStudentService().getStudent(id);
                List<Score> scores = ServiceFactory.getStudentService().getScoreBySid(id);
                List<P_P> pplist = ServiceFactory.getStudentService().getP_PBySid(id);
                req.getSession().setAttribute("scores", scores);
                req.getSession().setAttribute("student", s);
                req.getSession().setAttribute("pplist", pplist);
                url = "/home";
            } else if (user.getType() == 2 || user.getType() == 3) {
                requests = ServiceFactory.getStudentService().getAllRequests();
                int count = 0;
                for (int i = 0; i < requests.size(); i++) {
                    if (requests.get(i).getConfirm() == 0) count += 1;
                }
                req.getSession().setAttribute("teacher", ServiceFactory.getTeacherService().getTeacher(id));
                req.getSession().setAttribute("requestCount", count);
                url = "/teacher";
            }
            req.getSession().setAttribute("requests", requests);
        }
        else{
            url = "/login";
        }
        resp.sendRedirect(url);
    }
}