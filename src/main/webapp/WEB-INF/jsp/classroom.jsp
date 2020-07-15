<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-07-14
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>U+教务管理系统</title>
    <meta charset="utf-8">
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            margin-top: 50px;
        }

        .col-md-2 {
            background-color: #ccc;

        }

        #left-content {
            margin-top: 20px;
        }

        .list-group {
            padding-left: 0;
        }

        #panel-group {
            margin-top: 20px;
        }

        #onebtn {
            margin: 10px 0;
        }

        #btngroup button {
            width: 100%;
        }

        .progress {
            margin-top: 15px;
        }

    </style>
</head>

<body style="background-image: url(/assets/image/1.jpg)">
<nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation"
     style="background-color: steelblue">
    <!--container-fluid表示自适应大小，container表示居中-->
    <div class="container" style="margin-left: 8%;">
        <!--定义顶部导航栏-->
        <div class="navbar-header">
            <a class="navbar-brand" style="color: white" href="#">U+教务管理系统</a>
        </div>

        <!--collapse用于导航栏折叠之后数据在button按钮里点击显示-->
        <div class="collapse navbar-collapse" id="demo-navbar">
            <!--nav navbar-nav表示显示在导航栏里-->
            <ul class="nav navbar-nav">
                <li style="color: white"><a href="/teacher" style="color: white">首页</a></li>
                <li style="color: white"><a href="/teacher/application-list" style="color: white">审核管理</a></li>
                <li style="color: white"><a href="/teacher/stu-list" style="color: white">学生奖惩</a></li>
                <li style="background-color: dodgerblue;color: white"><a href="/classroom" style="color: white">课程管理</a>
                </li>
                <li style="color: white"><a href="/scoremodel" style="color: white">学生成绩</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-1"></div>

        <div class="col-md-10">
            <h2 style="color: steelblue">管理控制台</h2>
            <hr class="divider" style="background-color:steelblue;height:1.5px;border:none;">

            <div id="panel-group">
                <!-- 2 -->
                <div class="panel panel-primary" style="opacity: 0.9;">
                    <div class="panel-heading">
                        <h3 class="panel-title">排课系统</h3>
                    </div>
                    <div class="panel-body">
                        <form action="/classroom" method="post">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>排课信息</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th>教室</th>
                                    <th>
                                        <select name="classroomId" required>
                                            <c:forEach items="${classrooms}" var="classroom" varStatus="vs">
                                                <c:if test="${vs.index!=0}">
                                                    <option value="${classroom.roomId}">${classroom.roomName}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </th>
                                </tr>
                                <tr>
                                    <th>周</th>
                                    <th>
                                        <select name="week" required>
                                            <option value="1">第1周</option>
                                            <option value="2">第2周</option>
                                            <option value="3">第3周</option>
                                            <option value="4">第4周</option>
                                            <option value="5">第5周</option>
                                            <option value="6">第6周</option>
                                            <option value="7">第7周</option>
                                            <option value="8">第8周</option>
                                            <option value="9">第9周</option>
                                            <option value="10">第10周</option>
                                            <option value="11">第11周</option>
                                            <option value="12">第12周</option>
                                            <option value="13">第13周</option>
                                            <option value="14">第14周</option>
                                            <option value="15">第15周</option>
                                            <option value="16">第16周</option>
                                            <option value="17">第17周</option>
                                            <option value="18">第18周</option>
                                            <option value="19">第19周</option>
                                            <option value="20">第20周</option>
                                        </select>
                                    </th>
                                </tr>
                                <tr>
                                    <th>日</th>
                                    <th>
                                        <select name="day" required>
                                            <option value="1">周一</option>
                                            <option value="2">周二</option>
                                            <option value="3">周三</option>
                                            <option value="4">周四</option>
                                            <option value="5">周五</option>
                                            <option value="6">周六</option>
                                            <option value="7">周日</option>
                                        </select>
                                    </th>
                                </tr>
                                <tr>
                                    <th>课程</th>
                                    <th>
                                        <select name="courseId" required>
                                            <c:forEach items="${courses}" var="course">
                                                <option value="${course.cid}">${course.cName}</option>
                                            </c:forEach>
                                        </select>
                                    </th>
                                </tr>
                                <tr>
                                    <th>节</th>
                                    <th>
                                        <select name="time">
                                            <option value="1">第1,2节</option>
                                            <option value="2">第3,4节</option>
                                            <option value="3">第5,6节</option>
                                            <option value="4">第7,8节</option>
                                            <option value="5">第9,10,11节</option>
                                        </select>
                                    </th>
                                </tr>
                                <tr>
                                    <th>
                                    </th>
                                    <th>
                                        <button type="submit" class="btn btn-primary">选择班级进行排课</button>
                                    </th>
                                </tr>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>

                <div class="panel panel-primary" style="opacity: 0.9;">
                    <div class="panel-heading">
                        <h3 class="panel-title">安排教学任务</h3>
                    </div>
                    <div class="panel-body">
                        <form action="/task" method="post">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>教学任务信息</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th>课程</th>
                                    <th>
                                        <select name="cid" required>
                                            <c:forEach items="${courses}" var="course">
                                                <option value="${course.cid}">${course.cName}</option>
                                            </c:forEach>
                                        </select>
                                    </th>
                                </tr>
                                <tr>
                                    <th>日期</th>
                                    <th>
                                        <input type="date" style="width:70%;" placeholder="输入格式:****-**-**" name="date"
                                               required>
                                    </th>
                                </tr>
                                <tr>
                                    <th>详情</th>
                                    <th>
                                        <input name="detail" required>
                                    </th>
                                </tr>
                                <tr>
                                    <th>
                                    </th>
                                    <th>
                                        <button type="submit" class="btn btn-primary">安排教学任务</button>
                                    </th>
                                </tr>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
                <div class="panel panel-primary" style="opacity: 0.9;">
                    <div class="panel-heading">
                        <h3 class="panel-title">查询教学任务</h3>
                    </div>
                    <div class="panel-body">
                        <form action="/task" method="get">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>教学任务信息</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th>课程</th>
                                    <th>
                                        <select name="cid" required>
                                            <c:forEach items="${courses}" var="course">
                                                <option value="${course.cid}">${course.cName}</option>
                                            </c:forEach>
                                        </select>
                                    </th>
                                    <th></th>
                                </tr>
                                <tr>
                                    <th></th>
                                    <th>
                                        <button type="submit" class="btn btn-primary">查询教学任务</button>
                                    </th>
                                    <th></th>
                                </tr>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
                <div class="panel panel-primary" style="opacity: 0.9;">
                    <div class="panel-heading">
                        <h3 class="panel-title">修改课程信息</h3>
                    </div>
                    <div class="panel-body">
                        <form action="/course" method="get">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>课程信息</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th>课程</th>
                                    <th>
                                        <select name="cid" required>
                                            <c:forEach items="${courses}" var="course">
                                                <option value="${course.cid}">${course.cName}</option>
                                            </c:forEach>
                                        </select>
                                    </th>
                                    <th></th>
                                </tr>
                                <tr>
                                    <th>
                                    </th>
                                    <th>
                                        <button type="submit" class="btn btn-primary">查看课程信息</button>
                                    </th>
                                    <th></th>
                                </tr>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
