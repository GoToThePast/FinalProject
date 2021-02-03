<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="/web/css/public.css"/>
    <link rel="stylesheet" type="text/css" href="/web/css/login.css"/>
</head>
<body><!-------------------login-------------------------->
<div class="login">
    <form action="/web/Buyer/login" method="post"><h1><a href="#"><img src="/web/photo/cc_img/temp/logo.png"></a></h1>
        <p></p>
        <div class="msg-warn hide"><b></b>公共场所不建议自动登录，以防账号丢失</div>
        <p><input type="text" name="userName" value="" placeholder="昵称/邮箱/手机号"></p>
        <p><input type="text" name="passWord" value="" placeholder="密码"></p>
        <p><input type="submit" name="" value="登  录"></p>
        <p class="txt">
            <a href="/web/manage/login.jsp">商家登陆</a>
            <a class="" href="/web/view/register.html">免费注册</a>
            <a href="#">忘记密码？</a>
        </p>
    </form>
</div>
</body>
</html>