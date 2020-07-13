<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-07-13
  Time: 8:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>毕业申请</title>
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
    <script>
        function checkusername() {//检验用户名
            var username = document.getElementById("username");
            var usernamespan = document.getElementById("usernamespan");
            if (username.value == "") {
                usernamespan.innerHTML = "<font color='red'>请输入姓名</font>"
                return false;
            }
            var regex = /^[\u4e00-\u9fa5]+$/;
            if (!regex.test(username.value)) {
                usernamespan.innerHTML = "<font color='red'>格式错误</font>";
                return false;
            }
            usernamespan.innerHTML = "<font color='green'>通过</font>";
            return true;
        }

        function checkstnumber() {//检验学号/教师号
            var stnumberid = document.getElementById("stnumber");
            var stnumberspan = document.getElementById("stnumberspan");
            if (stnumberid.value == "") {
                stnumberspan.innerHTML = "<font color='red'>请输入学号</font>";
                return false;
            }
            var regex = /^\d{6,}/;
            if (!regex.test(stnumberid.value)) {
                stnumberspan.innerHTML = "<font color='red'>格式错误</font>";
                return false;
            }
            stnumberspan.innerHTML = "<font color='green'>通过</font>";
            return true;
        }

        function checkemail() {//检验邮箱
            var emmailid = document.getElementById("emailid");
            var emailspan = document.getElementById("emailispan");
            if (emailid.value == "") {
                emailspan.innerHTML = "<font color='red'>请输入邮箱地址</font>";
                return false;
            }
            var regex = /^([a-zA-Z0-9])+@([a-zA-Z0-9])+((\.[a-zA-Z0-9_-]{2,3}){1,2})/;
            if (!regex.test(emmailid.value)) {
                emailspan.innerHTML = "<font color='red'>邮箱地址不合法</font>";
                return false;
            }
            emailspan.innerHTML = "<font color='green'>邮箱地址正确</font>";
            return true;
        }

        function checkmajor() {//检验学院
            var major = document.getElementById("major");
            var majorspan = document.getElementById("majorspan");
            if (major.value == "") {
                majorspan.innerHTML = "<font color='red'>请选择学院</font>"
                return false;
            }
            majorspan.innerHTML = "<font color='green'>学院选择成功</font>";
            return true;
        }

        function checksubmitdate() {//检验申请时间
            var submitdate = document.getElementById("submitdate");
            var submitdatespan = document.getElementById("submitdatespan");
            if (submitdate.value == "") {
                submitdatespan.innerHTML = "<font color='red'>请选择时间</font>"
                return false;
            }
            submitdatespan.innerHTML = "<font color='green'>通过</font>";
            return true;
        }
    </script>
</head>
<body>
<div class="bg">
    <div class="tableCenter"></div>
    <form action="/application-student" method="post">
        <table class="table" id="application" width="60%" style="alignment: center" cellspacing="0" border="1px">
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
            <td width="40%" align="right">姓名：</td>
            <td>
                <input type="username" style="width:70%;" id="username" onblur="checkusername()" name="userName"
                       value="${user.userName}" readonly>
                <span id="usernamespan"></span>
            </td>
        </tr>
        <tr>
            <td width="40%" align="right">学号：</td>
            <td>
                <input type="text" style="width:70%;" id="stnumber" onblur="checkstnumber()" name="userId"
                       value="${user.id}" readonly>
                <span id="stnumberspan"></span>
            </td>
        </tr>
        <tr>
            <td width="40%" align="right">E-mail：
            </td>
            <td>
                <input type="email" style="width:70%;" id="emailid" onblur="checkemail()" name="email">
                <span id="emailispan"></span>
            </td>
        </tr>
        <tr>
            <td width="40%" align="right">
                所属学院：
            </td>
            <td>
                <input style="width:70%;" name="academy" value="${student.academy}" readonly>
                <span id="majorspan"></span>
                <br>
            </td>
        </tr>
        <tr>
            <td width="40%" align="right">申请时间：</td>
            <td>
                <input type="date" style="width:70%;" id="submitdate" onblur="checksubmitdate()"
                       placeholder="输入格式:****-**-**" name="date">
                <span id="submitdatespan"></span>
            </td>
        </tr>
        </tbody>
        <tfoot>
        <th>
            <button type="submit">提交申请</button>
        </th>
        </tfoot>
    </table>
    </form>
</div>
</div>
</body>
</html>
