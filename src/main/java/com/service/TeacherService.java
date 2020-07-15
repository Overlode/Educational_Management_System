package com.service;

import com.entity.*;

import java.util.ArrayList;
import java.util.List;

public interface TeacherService {
    public boolean register(String userName, String password, int userId, String sex, String academy);

    //教师注册
    public Teacher getTeacher(int tid);

    //获取教师信息
    public boolean updateProfile(int id, String name, String academy, String phone, String email, String password);

    //修改教室个人信息
    public List<Classroom> getClassrooms();

    //获取教室数据
    public List<Course> getCourse();

    //获取课程数据
    public void ApplicationAllow(int sid);

    //申请通过
    public void ApplicationNotAllow(int sid);

    //申请未通过
    public void addP_P(int ppsid, String date, int type, String detail);

    //添加奖惩信息
    public List<PassRequest> listPassRequests();

    public List<Student> listStudents();

    public int[] getClassNum(int cid);

    public boolean uploadSession(int courseid, int classid, int week, int day, int time, int classroomid);

    public boolean uploadTask(int cid, String date, String detail);

    public List<Task> getTask(int cid);

    public boolean deleteTask(int count);

    public boolean updateCourse(int cid, String cName, double score);

    public int countStu(int cid, int tid);

    public List<Course> getCourseByTid(int tid);

    public int[] analyseByCid(int cid);
}
