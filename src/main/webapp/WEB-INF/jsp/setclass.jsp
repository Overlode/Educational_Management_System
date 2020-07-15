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
                <ul class="nav navbar-nav">
                    <li style="color: white"><a href="/teacher" style="color: white">首页</a></li>
                    <li style="color: white"><a href="/teacher/application-list" style="color: white">审核管理</a></li>
                    <li style="color: white"><a href="/teacher/stu-list" style="color: white">学生奖惩</a></li>
                    <li style="background-color: dodgerblue;color: white"><a href="/classroom"
                                                                             style="color: white">课程管理</a></li>
                    <li style="color: white"><a href="/scoremodel" style="color: white">学生成绩</a></li>
                </ul>
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
                        <form action="/setclass" method="post">
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
                                        <c:forEach items="${classrooms}" var="classroom">
                                            <c:if test="${classroom.roomId==classroomId}">${classroom.roomName}</c:if>
                                        </c:forEach>
                                    </th>
                                </tr>
                                <tr>
                                    <th>周</th>
                                    <th>
                                        第${week}周
                                    </th>
                                </tr>
                                <tr>
                                    <th>日</th>
                                    <th>
                                        <c:if test="${day==1}">周一</c:if>
                                        <c:if test="${day==2}">周二</c:if>
                                        <c:if test="${day==3}">周三</c:if>
                                        <c:if test="${day==4}">周四</c:if>
                                        <c:if test="${day==5}">周五</c:if>
                                        <c:if test="${day==6}">周六</c:if>
                                        <c:if test="${day==7}">周日</c:if>
                                    </th>
                                </tr>
                                <tr>
                                    <th>课程</th>
                                    <th>
                                        <c:forEach items="${courses}" var="course">
                                            <c:if test="${course.cid==courseId}">${course.cName}</c:if>
                                        </c:forEach>
                                    </th>
                                </tr>
                                <tr>
                                    <th>节</th>
                                    <th>
                                        <c:if test="${time!=5}">第${time*2-1},${time*2}节</c:if>
                                        <c:if test="${time==5}">第9,10,11节</c:if>
                                    </th>
                                </tr>
                                <tr>
                                    <th>班级编号</th>
                                    <th>
                                        <select name="cNum" required>
                                            <c:forEach items="${classNum}" varStatus="vs">
                                                <c:if test="${classNum[vs.index]!=-1}">
                                                    <option value="${classNum[vs.index]}">${classNum[vs.index]}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>
                                    </th>
                                </tr>
                                <tr>
                                    <th>
                                    </th>
                                    <th>
                                        <button type="submit" class="btn btn-success">确认排课</button>
                                    </th>
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
