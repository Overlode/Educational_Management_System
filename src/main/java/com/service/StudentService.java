package com.service;

import java.util.Date;
import java.util.List;

import com.entity.P_P;
import com.entity.PassRequest;
import com.entity.Score;
import com.entity.Student;

public interface StudentService {
    public Student getStudent(int id);

    //获取学生数据
    public List<Score> getScoreBySid(int sid);

    //获取学生个人成绩
    public List<P_P> getP_PBySid(int sid);

    //获取奖惩信息
    public List<Score> getScoreByCidClassId(int cid, int classId);
    //获取成绩单

    public boolean register(String userName, String password, int userId, String sex, String academy);

    public List<PassRequest> getRequests(int sid);
    public List<PassRequest> getAllRequests();
    public boolean updateRequest(int sid, String date, String email);

    public List<Score> newScores(int classId, int cid);

    public boolean uploadScore(int sid, int cid, double score);

    PassRequest getCurrentRequest(int sid);

}
