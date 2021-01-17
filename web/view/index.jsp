<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>坨根</title>
    <link rel="stylesheet" type="text/css" href="../css/cc_css/public.css"/>
    <link rel="stylesheet" type="text/css" href="../css/cc_css/index.css"/>
    <link rel="stylesheet" type="text/css" href="../css/cc_css/idea.css"/>

</head>
<body><!------------------------------head------------------------------>

<%@ include file="header.jsp" %>


<!-------------------------banner--------------------------->
<div class="block_home_slider">
    <div id="home_slider" class="flexslider">
        <ul class="slides">
            <li>
                <div class="slide"><img src="../photo/cc_img/banner2.jpg"/></div>
            </li>
            <li>
                <div class="slide"><img src="../photo/cc_img/banner1.jpg"/></div>
            </li>
        </ul>
    </div>
</div><!------------------------------thImg------------------------------>
<div class="thImg">
    <div class="clearfix"><a href=""><img src="../photo/cc_img/i1.jpg"/></a><a href=""><img
            src="../photo/cc_img/i2.jpg"/></a><a href=""><img src="../photo/cc_img/i3.jpg"/></a></div>
</div><!------------------------------news------------------------------>
<div class="news">
    <div class="wrapper"><h2><img src="../photo/cc_img/ih1.jpg"/></h2>
        <div class="top clearfix"><a href="#"><img src="../photo/cc_img/n1.jpg"/>
            <p></p></a><a href="#"><img src="../photo/cc_img/n2.jpg"/>
            <p></p></a><a href="#"><img src="../photo/cc_img/n3.jpg"/>
            <p></p></a></div>
        <div class="bott clearfix"><a href="#"><img src="../photo/cc_img/n4.jpg"/>
            <p></p></a><a href="#"><img src="../photo/cc_img/n5.jpg"/>
            <p></p></a><a href="#"><img src="../photo/cc_img/n6.jpg"/>
            <p></p></a></div>
        <h2><img src="../photo/cc_img/ih2.jpg"/></h2>
        <div class="flower clearfix tran">
            <c:forEach var="goods" begin="0" end="2" step="1" items="${goodsList1}">
                <a href="../getGoodUseID?goodID=${goods.goodsID}">
                    <dl>
                        <dt><span class="abl"></span><img src="/${goods.goodsPicUrl}"/><span class="abr"></span></dt>
                        <dd>${goods.goodsName}</dd>
                        <dd><span>¥ ${goods.goodsPrice}</span></dd>
                    </dl>
                </a>
            </c:forEach>
        </div>
        <div class="flower clearfix tran">
            <c:forEach var="goods" begin="3" end="5" step="1" items="${goodsList1}">
                <a href="../getGoodUseID?goodID=${goods.goodsID}">
                    <dl>
                        <dt><span class="abl"></span><img src="/${goods.goodsPicUrl}"/><span class="abr"></span></dt>
                        <dd>${goods.goodsName}</dd>
                        <dd><span>¥ ${goods.goodsPrice}</span></dd>
                    </dl>
                </a>
            </c:forEach>
        </div>
    </div>
</div><!------------------------------ad------------------------------><a href="#" class="ad"><img
        src="../photo/cc_img/ib1.jpg"/></a><!------------------------------people------------------------------>
<div class="people">
    <div class="wrapper"><h2><img src="../photo/cc_img/ih3.jpg"/></h2>
        <div class="pList clearfix tran">
            <c:forEach var="goods" begin="0" end="2" step="1" items="${goodsList2}">
                <a href="../getGoodUseID?goodID=${goods.goodsID}">
                    <dl>
                        <dt><span class="abl"></span><img src="/${goods.goodsPicUrl}"/><span class="abr"></span></dt>
                        <dd>${goods.goodsName}</dd>
                        <dd><span>¥ ${goods.goodsPrice}</span></dd>
                    </dl>
                </a>
            </c:forEach>
        </div>
        <div class="pList clearfix tran">
            <c:forEach var="goods" begin="3" end="5" step="1" items="${goodsList2}">
                <a href="../getGoodUseID?goodID=${goods.goodsID}">
                    <dl>
                        <dt><span class="abl"></span><img src="/${goods.goodsPicUrl}"/><span class="abr"></span></dt>
                        <dd>${goods.goodsName}</dd>
                        <dd><span>¥ ${goods.goodsPrice}</span></dd>
                    </dl>
                </a>
            </c:forEach>
        </div>
    </div>
</div>
<div class="imgList1">
    <div class="wrapper">
        <h2><img src="../photo/cc_img/ih5.jpg"/></h2>
        <div class="box2"><a href="#" class="banner"><img
                src="../photo/cc_img/idea22.jpg"/></a>
            <ul>
                <c:forEach var="goods" begin="0" end="3" step="1" items="${goodsList3}">
                    <li>
                        <a href="../getGoodUseID?goodID=${goods.goodsID}" class="on">
                            <dl>
                                <dt><img src="/${goods.goodsPicUrl}"/></dt>
                                <dd>${goods.goodsName}</dd>
                                <dd>¥${goods.goodsPrice}</dd>
                            </dl>
                        </a>
                    </li>
                </c:forEach>
            </ul>
            <ul>
                <c:forEach var="goods" begin="4" end="7" step="1" items="${goodsList3}">
                    <li>
                        <a href="../getGoodUseID?goodID=${goods.goodsID}" class="on">
                            <dl>
                                <dt><img src="/${goods.goodsPicUrl}"/></dt>
                                <dd>${goods.goodsName}</dd>
                                <dd>¥${goods.goodsPrice}</dd>
                            </dl>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <a name="1"></a>
        <h2><img src="../photo/cc_img/ih6.jpg"/></h2>
        <div class="box3">
            <ul>
                <c:forEach var="goods" begin="0" end="3" step="1" items="${goodsList4}">
                    <li>
                        <a href="../getGoodUseID?goodID=${goods.goodsID}" class="on">
                            <dl>
                                <dt><img src="/${goods.goodsPicUrl}"/></dt>
                                <dd>${goods.goodsName}</dd>
                                <dd>¥${goods.goodsPrice}</dd>
                            </dl>
                        </a>
                    </li>
                </c:forEach>
            </ul>
            <ul>
                <c:forEach var="goods" begin="4" end="7" step="1" items="${goodsList4}">
                    <li>
                        <a href="../getGoodUseID?goodID=${goods.goodsID}" class="on">
                            <dl>
                                <dt><img src="/${goods.goodsPicUrl}"/></dt>
                                <dd>${goods.goodsName}</dd>
                                <dd>¥${goods.goodsPrice}</dd>
                            </dl>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<!--返回顶部-->
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
</a><a href="#" class="toptop" style="display: none">
    <dl>
        <dt><img src="../photo/cc_img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>400-800-8200</p></div><!-------------------login--------------------------><!--footer-->
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
<script src="../js/cc_js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">$(function () {
    $('#home_slider').flexslider({
        animation: 'slide',
        controlNav: true,
        directionNav: true,
        animationLoop: true,
        slideshow: true,
        slideshowSpeed: 2000,
        useCSS: false
    });
});</script>
</body>
</html>