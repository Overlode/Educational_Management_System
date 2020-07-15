<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-07-13
  Time: 15:30
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
                <li style="color: white"><a href="/classroom" style="color: white">课程管理</a></li>
                <li style="background-color: dodgerblue;color: white"><a href="/scoremodel"
                                                                         style="color: white">学生成绩</a></li>
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
                <div class="panel panel-primary" style="opacity: 0.9;">
                    <div class="panel-heading">
                        <h3 class="panel-title">成绩导出</h3>
                    </div>
                    <div class="panel-body">
                        <form action="/uploadscores" method="post">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th></th>
                                    <th>姓名</th>
                                    <th>学号</th>
                                    <th>课程编号</th>
                                    <th>班级编码</th>
                                    <th>成绩</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${scores}" var="sl" varStatus="s">
                                    <tr>
                                        <th>${s.count}</th>
                                        <th>${sl.sName}</th>
                                        <th>${sl.sid}</th>
                                        <th>${sl.cid}</th>
                                        <th>${sl.classId}</th>
                                        <th><input type="number" name="scores[${s.index}].score" required></th>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <th></th>
                                    <th>
                                        <button type="submit" class="btn btn-primary">上传成绩单</button>
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
