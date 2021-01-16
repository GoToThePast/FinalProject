<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/8
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<script src="./js/jquery2_14.js"></script>
<html>
<head>
    <title>订单管理</title>
    <link rel="stylesheet" type="text/css" href="css/myorder.css"/>
    <script src="./js/jquery2_14.js"></script>
    <script src="./js/myorder.js"></script>
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
        <c:forEach var="orderQuery" items="${sessionScope.orderList}">
        <div class="order-info">
            <div class="order-status">
                <p>${orderQuery.order.orderStatus}</p>
            </div>
            <div class="order-infomation">
                <div class="info-data">${orderQuery.order.createrTime}</div>
                <div class="info-buyerName">${orderQuery.order.orderUserNum}</div>
                <div class="info-roderNum">${orderQuery.order.orderNum}</div>
            </div>
            <div class="good-button">
                <div class="but-1 orderSta"><p class="on">确认发货</p></div>
            </div>
            <c:forEach var="good" items="${orderQuery.goods}">
            <div class="order-good">
                <div class="good-img">
                    <img src="/${good.goodsPicUrl}" alt="">
                </div>
                <div class="goodInfo">
                    <div class="good-name"><p>${good.goodsName}</p></div>
                    <div class="good-price">￥<span>${good.goodsPrice}</span></div>
                </div>
            </div>
            </c:forEach>
        </div>
        </c:forEach>
        <div class="orderPag">
            <div class="prePage"><a href="#">上一页</a></div>
            <div class="indexPage">1</div>
            <div class="nextPage"><a href="#">下一页</a></div>
        </div>
    </div>
</div>
<script src="./js/jquery2_14.js"></script>
<script>
    $(".orderSta").click(function(){
        console.log("该发货啦！！")
    })
</script>
</body>
</html>
