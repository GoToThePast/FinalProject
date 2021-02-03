<%--
  Created by IntelliJ IDEA.
  User: 王大哥
  Date: 2021/1/7
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
    <link rel="stylesheet" href="../css/wei/sellerUserInfo.css">
</head>
<body class="clearFix">
<h1>商家信息</h1>
<div id="main_body">
    <div class="title">个人信息</div>
    <div class="content">
        <div class="info clearFix">
            <div class="text">头像</div>
            <img class="icon" src="../${onlineUser.user.icon}">
        </div>
        <div class="info">
            <div class="text">账号</div>
            <div class="user_info"> <p>${onlineUser.user.id}</p></div>
        </div>
        <div class="info">
            <div class="text">名字</div>
            <div class="user_info"> <p>${onlineUser.user.name}</p></div>
        </div>
        <div class="info">
            <div class="text">邮箱</div>
            <div class="user_info"> <p>${onlineUser.user.email}</p></div>
        </div>
        <div class="info">
            <div class="text">类型</div>
            <div class="user_info"> <p>${onlineUser.user.type}</p></div>
        </div>
        <div class="info">
            <div class="text">银行卡</div>
            <div class="user_info"> <p>${onlineUser.user.bankCard}</p></div>
        </div>
        <div class="info">
            <div class="text">发货地址</div>
            <div class="user_info"> <p>${onlineUser.user.deliveryAddr}</p></div>
        </div>
    </div>
</div>
</body>
</html>
