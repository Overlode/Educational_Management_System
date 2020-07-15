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
                <li style="color: white"><a href="/home" style="color: white">首页</a></li>
                <li style="color: white"><a href="/application-student" style="color: white">审核申请</a></li>
                <li style="background-color: dodgerblue;color: white"><a href="/infocard" style="color: white">个人学籍卡</a>
                </li>
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
                        <h3 class="panel-title">个人学籍卡</h3>
                    </div>
                    <div class="panel-body">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>学籍卡信息</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th>姓名</th>
                                <th>${student.name}</th>
                            </tr>
                            <tr>
                                <th>性别</th>
                                <th>${student.sex}</th>
                            </tr>
                            <tr>
                                <th>所属学院</th>
                                <th>${student.academy}</th>
                            </tr>
                            <tr>
                                <th>学号</th>
                                <th>${student.id}</th>
                                <th></th>
                            </tr>
                            <tr>
                                <th>已修学分</th>
                                <th>${student.score}</th>
                            </tr>
                            <tr>
                                <th></th>
                                <th></th>
                            </tr>
                            <tr>
                                <th>成绩单</th>
                                <th></th>
                            </tr>
                            <c:if test="${scores.size()<1}">
                                <tr>
                                    <th>暂无个人成绩</th>
                                    <th></th>
                                </tr>
                            </c:if>
                            <c:if test="${scores.size()>=1}">
                                <c:forEach items="${scores}" var="s">
                                    <tr>
                                        <th>${s.cName}</th>
                                        <th>${s.score}</th>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            <tr>
                                <th></th>
                                <th></th>
                            </tr>
                            <tr>
                                <th>奖惩信息</th>
                                <th></th>
                            </tr>
                            <c:forEach items="${pplist}" var="s">
                                <tr>
                                    <th>${s.date}</th>
                                    <th>${s.detail}</th>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
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
