package com.service;

import java.util.List;

import com.entity.P_P;
import com.entity.PassRequest;
import com.entity.Score;
import com.entity.Student;

public interface StudentService {
    public Student getStudent(int id);//获取学生数据
    public List<Score> getScoreBySid(int sid);
    public List<P_P> getP_PBySid(int sid);

    public List<Score> getScoreByCid(int cid);

    public boolean register(String userName, String password, int userId, String sex, String academy);

    public List<PassRequest> getRequests(int sid);
}
