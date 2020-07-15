package com.controller;

import com.entity.Score;
import com.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@WebServlet("/uploadscores")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("scores", ServiceFactory.getStudentService().newScores(Integer.parseInt(req.getParameter("classId")), Integer.parseInt(req.getParameter("cid"))));
        req.getRequestDispatcher("/WEB-INF/jsp/uploadscores.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Score> scores = (List<Score>) req.getSession().getAttribute("scores");
        for (int i = 0; i < scores.size(); i++) {
            String index = "scores[" + i + "].score";
            double score = Double.parseDouble(req.getParameter(index));
            ServiceFactory.getStudentService().uploadScore(scores.get(i).getSid(), scores.get(i).getCid(), score);
        }
        resp.sendRedirect("/scoremodel");
    }
}
