<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 14211
  Date: 2020/7/13
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <style type="text/css">
        * {
            margin: 0;
            padding: 5px;
        }

        .table {
            width: 60%;
            margin: auto;
            border-spacing: 0;
            border-collapse: inherit;
            table-layout: auto;
        }

        .tableCenter {
            text-align: center;
        }

        table thead,
        tfoot,
        tbody tr {
            display: table;
            width: 100%;
            table-layout: fixed;
        }

        table thead th {
            background: #ccc;
        }

        .bg {
            height: 600px;
            background-image: url(/assets/image/yzm.jpg);
            background-size: cover;
        }
    </style>
</head>
<body>

<div class="bg">
    <div class="tableCenter"></div>
    <table class="table" id="application" width="60%" cellspacing="0" border="1px">
        <caption>
            毕业申请
        </caption>
        <thead>
        <th>
            毕业申请表
        </th>
        </thead>
        <tbody>
        <tr>
            <th><p style="color: #ffffff;">姓名：</p></th>
            <th><p style="color: #ffffff;">${student.name}</p></th>
        </tr>
        <tr>
            <th><p style="color: #ffffff;">所属学院：</p></th>
            <th><p style="color: #ffffff;">${student.academy}</p></th>
        </tr>
        <tr>
            <th><p style="color: #ffffff;">学号：</p></th>
            <th><p style="color: #ffffff;">${student.id}</p></th>
        </tr>
        <tr>
            <th><p style="color: #ffffff;">邮箱：</p></th>
            <th><p style="color: #ffffff;">${passrequest.email}</p></th>
        </tr>
        <tr>
            <th><p style="color: #ffffff;">申请时间：</p></th>
            <th><p style="color: #ffffff;">${passrequest.date}</p></th>
        </tr>
        <c:forEach items="${scores}" var="s" varStatus="i">
            <tr>
                <th><p style="color: #ffffff;">${s.cName}</p></th>
                <th><p style="color: #ffffff;">${s.score}</p></th>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <th>
            <button style="background: #DC143C;"><a
                    href="/teacher/application-teacher/check/notallow?sid=${student.id}">拒绝申请</a></button>
        </th>
        <th>
            <button style="background: #7fff00;"><a href="/teacher/application-teacher/check/allow?sid=${student.id}">同意申请</a>
            </button>
        </th>
        <th>
            <button style="background: #00ffff;"><a href="/teacher/application-list" style="color: white">返回列表</a>
            </button>
        </th>
        </tfoot>
    </table>
</div>
</div>

</body>
</html>
