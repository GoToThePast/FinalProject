<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/16
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>最家</title>
    <link rel="stylesheet" type="text/css" href="../css/cc_css/public.css"/>
    <link rel="stylesheet" type="text/css" href="../css/cc_css/myorder.css"/>
</head>
<body>
<!------------------------------head------------------------------>
<%@ include file="header.jsp" %>
<!------------------------------idea------------------------------>
<div class="address mt">
    <div class="wrapper clearfix">
        <a href="index.jsp" class="fl">首页</a>
        <span>/</span>
        <a href="mygxin.jsp">个人中心</a><span>/</span><a href="myorderq.jsp" class="on">我的订单</a></div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3><a href="#"><img src="../photo/cc_img/tx.png"/></a>
                <p class="clearfix"><span class="fl">[${buyer.name}]</span><span class="fr">[退出登录]</span></p></h3>
            <div><h4>我的交易</h4>
                <ul>
                    <li><a href="cart.jsp">我的购物车</a></li>
                    <li><a href="myorderq.jsp">我的订单</a></li>
                    <li><a href="#">评价晒单</a></li>
                </ul>
                <h4>个人中心</h4>
                <ul>
                    <li><a href="mygxin.jsp">我的中心</a></li>
                    <li><a href="#">地址管理</a></li>
                </ul>
                <h4>账户管理</h4>
                <ul>
                    <li class="on"><a href="mygrxx.html">个人信息</a></li>
                    <li><a href="#">修改密码</a></li>
                </ul>
            </div>
        </div>
        <div class="you fl">
            <div class="my clearfix"><h2 class="fl">我的订单</h2><a href="#" class="fl">请谨防钓鱼链接或诈骗电话，了解更多&gt;</a></div>
            <div class="dlist clearfix">
                <ul class="fl clearfix" id="wa">
                    <li class="on"><a href="#2">全部有效订单</a></li>
                    <li><a href="#2">待支付</a></li>
                    <li><a href="#2l">待收货</a></li>
                    <li><a href="#2">已关闭</a></li>
                </ul>
                <form action="#" method="get" class="fr clearfix"><input type="text" name="" id="d" value=""
                                                                         placeholder="请输入商品名称、订单号"/><input type="button"
                                                                                                           name=""
                                                                                                           id="s"
                                                                                                           value=""/>
                </form>
            </div>
            <c:forEach var="rs" items="${buyerOrderList}">
                <div class="dkuang"><p class="one">${rs.order.orderStatus}</p>
                    <div class="word clearfix">
                        <ul class="fl clearfix">
                            <li>${rs.order.createrTime}</li>
                            <li>${buyer.name}</li>
                            <li>订单号:${rs.order.orderNum}</li>
                            <li>在线支付</li>
                        </ul>
                        <p class="fr">订单金额：<span>${rs.order.totalPrice}</span>元</p></div>
                    <div class="shohou clearfix">
                        <a href="#" class="fl"><img src="/${rs.goods[0].goodsPicUrl}"/></a>
                        <p class="fl"><a href="#">${rs.goods[0].goodsName}</a><a href="#">¥${rs.goods[0].goodsPrice}×1</a></p>
                        <p class="fr"><a href="#">待评价</a><a href="#">订单详情</a></p>
                    </div>
                </div>
            </c:forEach>

            <div class="fenye clearfix"><a href="#">
                <img src="../photo/cc_img/zuo.jpg"/></a>
                <a href="#">1</a><a href="#"><img src="../photo/cc_img/you.jpg"/>
                </a>
            </div>
        </div>
    </div>
</div><!--返回顶部-->
<div class="gotop">
    <a href="cart.html">
        <dl>
            <dt><img src="../photo/cc_img/gt1.png"/></dt>
            <dd>去购<br/>物车</dd>
        </dl>
    </a><a href="#" class="dh">
    <dl>
        <dt><img src="../photo/cc_img/gt2.png"/></dt>
        <dd>联系<br/>客服</dd>
    </dl>
</a><a href="mygxin.html">
    <dl>
        <dt><img src="../photo/cc_img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none">
    <dl>
        <dt><img src="../photo/cc_img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>400-800-8200</p></div><!--footer-->
<div class="footer">
    <div class="top">
        <div class="wrapper">
            <div class="clearfix"><a href="#2" class="fl"><img src="../photo/cc_img/foot1.png"/></a><span class="fl">7天无理由退货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="../photo/cc_img/foot2.png"/></a><span class="fl">15天免费换货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="../photo/cc_img/foot3.png"/></a><span class="fl">满599包邮</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="../photo/cc_img/foot4.png"/></a><span class="fl">手机特色服务</span>
            </div>
        </div>
    </div>
    <p class="dibu">坨根家居&copy;2020-2021团队版权所有 京ICP备080100-44备0000111888号<br/>
        违法和不良信息举报电话：400-800-8200，本网站所列数据，除特殊说明，所有数据均出自我队自行测试</p></div>
<script src="../js/cc_js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/cc_js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/cc_js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
