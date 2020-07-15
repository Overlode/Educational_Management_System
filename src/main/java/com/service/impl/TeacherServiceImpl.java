package com.service.impl;

import com.entity.*;
import com.service.TeacherService;
import com.util.DataSourceUtils;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    @Override
    public boolean register(String userName, String password, int userId, String sex, String academy) {
        String sql = "Insert into teacher(id,name,sex,academy,password) values(?,?,?,?,?)";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
        ) {
            st.setInt(1, userId);
            st.setString(2, userName);
            st.setString(3, sex);
            st.setString(4, academy);
            st.setString(5, password);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Teacher getTeacher(int tid) {
        Teacher t = null;
        String sql = "SELECT * FROM teacher WHERE id=?";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, tid);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    t = new Teacher(rs.getInt("id"), rs.getString("name"), rs.getString("academy"), rs.getString("sex"));
                    t.setEmail(rs.getString("email"));
                    t.setPhone(rs.getString("phone"));
                    t.setCore(rs.getInt("core"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public boolean updateProfile(int id, String name, String academy, String phone, String email, String password) {
        String sql = "update teacher set name=?,academy=? , phone =?,email=?,password=? where id=?";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, name);
            st.setString(2, academy);
            st.setString(3, phone);
            st.setString(4, email);
            st.setString(5, password);
            st.setInt(6, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Classroom> getClassrooms() {
        List<Classroom> classrooms = new ArrayList<>();
        Classroom c = new Classroom("0cr", -1, -1);
        classrooms.add(c);
        String sql = "SELECT * FROM classroom";
        String sqll = "SELECT sessionid,session.classroomid,classroomname,courseid,course.name,classid,week,time,day FROM session,classroom,course where classroom.classroomid=session.classroomid and courseid=course.id";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    c = new Classroom(rs.getString("classroomname"), rs.getInt("classroomid"), rs.getInt("maxstudent"));
                    classrooms.add(c);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement stt = conn.prepareStatement(sqll)) {
            try (ResultSet rss = stt.executeQuery()) {
                while (rss.next()) {
                    int cid = rss.getInt("courseid");
                    int classid = rss.getInt("classid");
                    int week = rss.getInt("week");
                    int time = rss.getInt("time");
                    int day = rss.getInt("day");
                    int classroomid = rss.getInt("classroomid");
                    String name = rss.getString("name");
                    classrooms.get(classroomid).getWeeks().get(week).getDays().get(day).getSessions().get(time).setClassid(classid);
                    classrooms.get(classroomid).getWeeks().get(week).getDays().get(day).getSessions().get(time).setCid(cid);
                    classrooms.get(classroomid).getWeeks().get(week).getDays().get(day).getSessions().get(time).setCourseName(name);
                    classrooms.get(classroomid).getWeeks().get(week).getDays().get(day).getSessions().get(time).setStatus(false);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classrooms;
    }

    @Override
    public List<Course> getCourse() {
        String sql = "SELECT * FROM course";
        List<Course> courses = new ArrayList<>();
        Course c;
        try (Connection connection = DataSourceUtils.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    c = new Course(rs.getInt("id"), rs.getString("name"), rs.getDouble("score"));
                    courses.add(c);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public List<PassRequest> listPassRequests() {
        List<PassRequest> passRequests = new ArrayList<>();
        String sql = "SELECT * FROM request";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                PassRequest passRequest = new PassRequest(rs.getInt("confirm"), rs.getInt("rsid"), rs.getInt("count"));
                passRequests.add(passRequest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return passRequests;
    }

    @Override
    public void ApplicationAllow(int sid) {
        String sql = "update request set confirm = 2 where rsid = ?";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, sid);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ApplicationNotAllow(int sid) {
        String sql = "update request set confirm = 1 where rsid = ?";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, sid);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void addP_P(int ppsid, String date, int type, String detail) {
        String sql = "INSERT INTO p_p(ppsid,date,type,detail) VALUES(?,?,?,?)";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, ppsid);
            st.setString(2, date);
            st.setInt(3, type);
            st.setString(4, detail);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> listStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Student student = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("sex"), rs.getString("academy"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public int[] getClassNum(int cid) {
        int[] list = new int[10];
        for (int i = 0; i < 10; i++) list[i] = -1;
        int count = 0;
        String sql = "SELECT classid FROM s_c where sccid=? and status=0 group by classid";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, cid);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    list[count++] = rs.getInt("classid");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean uploadSession(int courseid, int classid, int week, int day, int time, int classroomid) {
        String sql = "insert into session(courseid,classid,week,day,time,classroomid) values(?,?,?,?,?,?)";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql);
        ) {
            st.setInt(1, courseid);
            st.setInt(2, classid);
            st.setInt(3, week);
            st.setInt(4, day);
            st.setInt(5, time);
            st.setInt(6, classroomid);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean uploadTask(int cid, String date, String detail) {
        String sql = "Insert into task(tcid,date,detail) values(?,?,?)";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, cid);
            st.setString(2, date);
            st.setString(3, detail);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Task> getTask(int cid) {
        List<Task> list = new ArrayList<>();
        Task t;
        String sql = "SELECT count,date,tcid,detail,name FROM task,course where tcid=course.id and tcid = ?";
        try (Connection connection = DataSourceUtils.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, cid);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    t = new Task(rs.getString("date"), rs.getInt("tcid"), rs.getString("detail"), rs.getString("name"));
                    t.setCount(rs.getInt("count"));
                    list.add(t);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deleteTask(int count) {
        String sql = "delete from task where count = ?";
        try (Connection connection = DataSourceUtils.getConnection();
             PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, count);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateCourse(int cid, String cName, double score) {
        String sql = "update course set name = ?,score=? where id = ? ";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, cName);
            st.setDouble(2, score);
            st.setInt(3, cid);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public int countStu(int cid, int tid) {
        int count = 0;
        String sql = "SELECT Count(scsid) FROM course,c_t,teacher,s_c where c_t.cttid=teacher.id and teacher.id=? and ctcid=course.id and sccid=ctcid and course.id=?";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, tid);
            st.setInt(2, cid);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    count = rs.getInt("Count(scsid)");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return count;
    }

    @Override
    public List<Course> getCourseByTid(int tid) {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT ctcid,course.name,score FROM course,c_t,teacher where c_t.cttid=teacher.id and teacher.id=? and ctcid=course.id";
        try (Connection conn = DataSourceUtils.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, tid);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Course c = new Course(rs.getInt("ctcid"), rs.getString("name"), rs.getDouble("score"));
                    c.setCountStu(countStu(c.getCid(), tid));
                    courses.add(c);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public int[] analyseByCid(int cid) {
        double[] front = new double[5];
        front[0] = 0;
        front[1] = 60;
        front[2] = 70;
        front[3] = 80;
        front[4] = 90;
        double[] back = new double[5];
        back[0] = 59;
        back[1] = 69;
        back[2] = 79;
        back[3] = 89;
        back[4] = 101;
        int[] countScore = new int[5];//0-59 60-69 70-79 80-89 90-100
        for (int i = 0; i < 5; i++) countScore[i] = 0;
        String sql = "SELECT count(score) FROM test.score where scid=? and score<? and score>=?";
        for (int i = 0; i < 5; i++) {
            try (Connection conn = DataSourceUtils.getConnection();
                 PreparedStatement st = conn.prepareStatement(sql)) {
                st.setInt(1, cid);
                st.setDouble(2, back[i]);
                st.setDouble(3, front[i]);
                try (ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        countScore[i] = rs.getInt("count(score)");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return countScore;
    }
}
