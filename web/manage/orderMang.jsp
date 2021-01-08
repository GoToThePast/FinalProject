<%@ page import="com.tuogen.model.Order" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/8
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>订单管理</title>
    <link rel="stylesheet" type="text/css" href="css/myorder.css"/>
</head>
<body>

<div class="all">
    <div class="order-head">
        <h2>我的订单</h2><span class="ordHeadTital">严防钓鱼事件。。<a>了解更多>></a></span>
    </div>
    <div class="order-center">
        <ul class="sel-left" id="wa">
            <li class="on">全部有效订单</li>
            <li>待支付</li>
            <li>待收货</li>
            <li>已关闭</li>
        </ul>
        <form action="#" method="get" class="serch-f">
            <input type="text" name="" id="search-box" value=""  placeholder="请输入商品名称、订单号"/>
            <input type="button" name="" id="search-button" value=""/>
        </form>
    </div>
    <div class="order-container">
        <c:forEach var="order" items="${sessionScope.orderList}">
        <div class="order-info">
            <div class="order-status">
                <h3>${order.orderStatus}</h3>
            </div>
            <div class="order-infomation">
                <div class="info-data">${order.createrTime}</div>
                <div class="info-buyerName">${order.orderUserNum}</div>
                <div class="info-roderNum">${order.orderNum}</div>
            </div>
            <div class="order-good">
                <div class="good-img">
                    <img src="" alt="">
                </div>
                <div class="goodInfo">
                    <div class="good-name"><p>${order.goodsListId}</p></div>
                    <div class="good-price">￥<span>99.45</span></div>
                </div>
                <div class="good-button">
                    <div class="but-1">确认</div>
                    <div class="but-2">详情</div>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
