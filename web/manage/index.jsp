<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/7
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/web/manage/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<script src="/web/manage/js/jquery2_14.js"></script>
<script src="/web/manage/js/index.js"></script>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="#" class="navbar-brand"></a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on"  href="#">首页</a></li>
                <li><a href="#" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="" class="welcomePage">信息</a></li>
                <li><a href="#">修改密码</a></li>
                <li><a href="../logout">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>Memus</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="#" class="icon-sel"><i class="icon-font selectIcon">&#xe009;</i>商品管理</a></li>
                        <li><a href="#" class="icon-sel"><i class="icon-font selectIcon">&#xe005;</i>订单管理</a></li>
                        <li><a href="#" class="icon-sel"><i class="icon-font selectIcon">&#xe006;</i>在线用户</a></li>
                        <li><a href="#" class="icon-sel"><i class="icon-font selectIcon">&#xe004;</i>留言管理</a></li>
                        <li><a href="#" class="icon-sel"><i class="icon-font selectIcon">&#xe012;</i>评论管理</a></li>
                        <li><a href="#" class="icon-sel"><i class="icon-font selectIcon">&#xe052;</i>友情链接</a></li>
                        <li><a href="#" class="icon-sel"><i class="icon-font selectIcon">&#xe033;</i>广告管理</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe018;</i>系统管理</a>
                    <ul class="sub-menu">
                        <li><a href="#" class="icon-sel"><i class="icon-font selectIcon">&#xe017;</i>系统设置</a></li>
                        <li><a href="#" class="icon-sel"><i class="icon-font selectIcon">&#xe037;</i>清理缓存</a></li>
                        <li><a href="#" class="icon-sel"><i class="icon-font selectIcon">&#xe046;</i>数据备份</a></li>
                        <li><a href="#" class="icon-sel"><i class="icon-font selectIcon">&#xe045;</i>数据还原</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list" id="navLocation"><i class="icon-font">&#xe06b;</i><span>欢迎使用 Breeze商城。</span></div>
        </div>
        <iframe  id="iframe-contains" src="../view/sellerUserInfo.jsp" frameborder="0" width="100%" height="90%"></iframe>
    </div>
<%--    class="iframe-contain"--%>
    <!--/main-->
</div>
</body>

</html>
