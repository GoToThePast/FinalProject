<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>蜡艺香薰</title>
    <link rel="stylesheet" type="text/css" href="../css/cc_css/public.css"/>
    <link rel="stylesheet" type="text/css" href="../css/cc_css/proList.css"/>
</head>
<body><!------------------------------head------------------------------>
<%@ include file="header.jsp" %>
<!-----------------banner------------------------------->
<div class="banner"><a href="#"><img src="../photo/cc_img/temp/perfume_Banner.jpg"/></a></div>
<!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix"><a href="index.jsp">首页</a><span>/</span><a href="perfume.html" class="on">创意家居</a>
    </div>
</div><!-----------------paintCon------------------------------->
<div class="paintCon">
    <section class="wrapper"><h3><img src="../photo/cc_img/temp/perfumeTit01.jpg"></h3><img src="../photo/cc_img/temp/xxB01.jpg"/>
        <div class="paintList">
            <c:forEach var="goods" begin="0" end="2" step="1"  items="${goodsList5}">
                <a href="../getGoodUseID?goodID=${goods.goodsID}">
                    <dl>
                        <dt><img src="/${goods.goodsPicUrl}"></dt>
                        <dd>${goods.goodsName}</dd>
                        <dd>¥${goods.goodsPrice}</dd>
                    </dl>
                </a>
            </c:forEach>
        </div>
    </section>
    <section class="wrapper"><h3><img src="../photo/cc_img/temp/perfumeTit02.jpg"></h3><img src="../photo/cc_img/temp/xxB02.jpg"/>
        <div class="paintList">
            <c:forEach var="goods" begin="3"  items="${goodsList5}">
                <a href="../getGoodUseID?goodID=${goods.goodsID}">
                    <dl>
                        <dt><img src="/${goods.goodsPicUrl}"></dt>
                        <dd>${goods.goodsName}</dd>
                        <dd>¥${goods.goodsPrice}</dd>
                    </dl>
                </a>
            </c:forEach>
        </div>
    </section>
</div><!--返回顶部-->
<div class="gotop"><a href="mcart.jsp">
    <dl>
        <dt><img src="../photo/cc_img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
    </dl>
</a><a href="#" class="dh">
    <dl>
        <dt><img src="../photo/cc_img/gt2.png"/></dt>
        <dd>联系<br/>客服</dd>
    </dl>
</a><a href="mygxin.jsp">
    <dl>
        <dt><img src="../photo/cc_img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none;">
    <dl>
        <dt><img src="../photo/cc_img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>400-800-8200</p></div>
<div class="msk"></div><!--footer-->
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
<script src="../js/cc_js/nav.js" type="text/javascript" charset="utf-8"></script>
<!--<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>--></body>
</html>