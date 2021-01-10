<%--
  Created by IntelliJ IDEA.
  User: 王大哥
  Date: 2021/1/7
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
    <style>
        .container {
            width: 60%;
            margin: 10% auto 0;
            background-color: #f0f0f0;
            padding: 2% 5%;
            border-radius: 10px;
            text-align: center;
        }
        h1{
            width: 100%;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>&nbsp;&nbsp;账号注册成功！</h1>
    <h1>账号：${account}</h1>
    <a href="../manage/login.jsp">登录</a>
</div>
</body>
</html>
