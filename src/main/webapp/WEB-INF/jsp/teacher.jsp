<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-07-13
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript">
    function disp_prompt() {
        var name = prompt("请输入修改后的信息", "");
        if (name != null && name != "") {
            alert("当前输入的是：" + name);
        }
    }
</script>
<meta charset="utf-8">
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
                <li style="background-color: dodgerblue;color: white"><a href="/teacher" style="color: white">首页</a>
                </li>
                <li style="color: white"><a href="" style="color: white">审核管理</a></li>
                <li style="color: white"><a href="#" style="color: white">学生奖惩</a></li>
                <li style="color: white"><a href="#" style="color: white">课程安排</a></li>
                <li style="color: white"><a href="#" style="color: white">学生成绩</a></li>
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
                <c:if test="${teacher.core==1&&requestCount>0}">
                    <div class="panel panel-primary" style="opacity: 0.9;">
                        <div class="panel-heading">
                            <h3 class="panel-title">最新提醒</h3>
                        </div>
                        <div class="panel-body">
                            <div class="alert alert-warning" role="alert">
                                <strong>提示</strong> 有${requestCount}份毕业申请等待审核
                            </div>
                        </div>
                    </div>
                </c:if>

                <!-- 2 -->
                <div class="panel panel-primary" style="opacity: 0.9;">
                    <div class="panel-heading">
                        <h3 class="panel-title">个人信息</h3>
                    </div>
                    <div class="panel-body">
                        <form action="/teacher" method="post">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>个人信息</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th>姓名</th>
                                    <th><input type="text" value="${teacher.name}" name="userName"></th>
                                </tr>
                                <tr>
                                    <th>性别</th>
                                    <th>${teacher.sex}</th>
                                </tr>
                                <tr>
                                    <th>所属学院</th>
                                    id
                                    <th><input type="text" value="${teacher.academy}" name="academy"></th>
                                </tr>
                                <tr>
                                    <th>教师号</th>
                                    <th><input type="text" value="${teacher.id}" name="tid" readonly></th>
                                </tr>
                                <tr>
                                    <th>密码</th>
                                    <th><input type="password" value="${user.password}" name="password"></th>
                                </tr>
                                <tr>
                                    <th>E-mail</th>
                                    <th><input type="text" value="${teacher.email}" name="email"></th>
                                </tr>
                                <tr>
                                    <th>电话</th>
                                    <th><input type="text" value="${teacher.phone}" name="phone"></th>
                                </tr>
                                <tr>
                                    <th></th>
                                    <th>
                                        <button type="submit" class="btn btn-primary">点击修改个人信息</button>
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
</div>


<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
