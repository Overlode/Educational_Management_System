package com.controller;

import com.entity.CommonExcel;
import com.entity.Score;
import com.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getscores")
public class GetScoresServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String classId = req.getParameter("cid");
        int cid = Integer.parseInt(classId);
        List<Score> scores = ServiceFactory.getStudentService().getScoreByCid(cid);
        String title = "成绩表";
        String[] rowsName = new String[]{"排名", "姓名", "学号", "成绩"};
        List<Object[]> dataList = new ArrayList<Object[]>();
        Object[] objs = null;
        for (int i = 0; i < scores.size(); i++) {
            objs = new Object[rowsName.length];
            objs[0] = i + 1;
            objs[1] = scores.get(i).getsName();
            objs[2] = scores.get(i).getSid();
            objs[3] = scores.get(i).getScore();
            dataList.add(objs);
        }
        String fileName = "成绩单.xls";

        CommonExcel ex = new CommonExcel(title, rowsName, dataList, resp, fileName);
        try {
            ex.downloadExcel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
