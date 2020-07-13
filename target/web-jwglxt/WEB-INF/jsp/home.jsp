<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-07-10
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>U+教务管理系统</title>
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
            <a class="navbar-brand" style="color: white" href="/main" >U+教务管理系统</a>
        </div>

        <!--collapse用于导航栏折叠之后数据在button按钮里点击显示-->
        <div class="collapse navbar-collapse" id="demo-navbar">
            <!--nav navbar-nav表示显示在导航栏里-->
            <ul class="nav navbar-nav">
                <li style="background-color: dodgerblue;color: white"><a href="/home" style="color: white">首页</a></li>
                <li style="color: white"><a href="/application-student" style="color: white">审核申请</a></li>
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

                <!-- 1 -->
                <div class="panel panel-primary" style="opacity: 0.9;">
                    <div class="panel-heading">
                        <h3 class="panel-title">毕业审核申请进度</h3>
                    </div>
                    <div class="panel-body">
                        <c:forEach items="${requests}" var="r" varStatus="rs">
                            <c:if test="${r.confirm==0}">
                                <div class="alert alert-warning" role="alert">
                                    <strong>提示</strong> 您的申请(${r.id})等待审核中
                                </div>
                            </c:if>
                            <c:if test="${r.confirm==1}">
                                <div class="alert alert-danger" role="alert">
                                    <strong>提示</strong> 您的申请(${r.id})被打回
                                </div>
                            </c:if>
                            <c:if test="${r.confirm==2}">
                                <div class="alert alert-info" role="alert">
                                    <strong>提示</strong> 您的申请(${r.id})已经审批通过
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>

                </div>

                <!-- 2 -->
                <div class="panel panel-primary" style="opacity: 0.9;">
                    <div class="panel-heading">
                        <h3 class="panel-title">个人信息</h3>
                    </div>

                    <div class="panel-body">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>个人信息</th>
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
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>

                <!-- 3 -->
                <div class="panel panel-primary" style="opacity: 0.9;">
                    <div class="panel-heading">
                        <h3 class="panel-title">个人成绩</h3>
                    </div>
                    <div class="panel-body">
                        <table class="table">
                            <c:if test="${scores.size()<1}">
                                <tr>
                                    <th>暂无个人成绩</th>
                                </tr>
                            </c:if>
                            <c:if test="${scores.size()>=1}">
                                <thead>
                                <tr>
                                    <th></th>
                                    <th>学科</th>
                                    <th>最终成绩</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${scores}" var="s" varStatus="vs">
                                    <tr>
                                        <th>${vs.count}</th>
                                        <th>${s.cName}</th>
                                        <th>${s.score}</th>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </c:if>
                        </table>
                    </div>
                </div>

                <!-- 4 -->
                <div class="panel panel-primary" style="opacity: 0.9;">
                    <div class="panel-heading">
                        <h3 class="panel-title">奖惩信息</h3>
                    </div>
                    <div class="panel-body">
                        <table class="table">
                            <thead>
                            <tr>
                                <th></th>
                                <th>事件</th>
                                <th>详细内容</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pplist}" var="s" varStatus="vs">
                                <tr>
                                    <th>${vs.count}</th>
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

</div>


<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
