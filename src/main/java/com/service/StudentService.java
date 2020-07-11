package com.service;

import java.util.List;

import com.entity.P_P;
import com.entity.Score;
import com.entity.Student;

public interface StudentService {
    public Student getStudent(int id);//获取学生数据
    public List<Score> getScoreBySid(int sid);
    public List<P_P> getP_PBySid(int sid);
}
