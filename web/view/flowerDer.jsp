<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>布艺软饰</title>
    <link rel="stylesheet" type="text/css" href="../css/cc_css/public.css"/>
    <link rel="stylesheet" type="text/css" href="../css/cc_css/proList.css"/>
</head>
<body><!------------------------------head------------------------------>
<%@ include file="header.jsp" %>
<!------------------------------banner------------------------------>
<div class="banner"><a href="#"><img src="../photo/cc_img/temp/banner1.jpg"/></a></div>
<!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix"><a href="index.jsp">首页</a><span>/</span><a href="flowerDer.html" class="on">布艺软饰</a>
    </div>
</div><!-------------------current---------------------->
<div class="current">
    <div class="wrapper clearfix"><h3 class="fl">布艺软饰</h3>
        <div class="fr choice"><p class="default">排序方式</p>
            <ul class="select">
                <li>新品上市</li>
                <li>销量从高到低</li>
                <li>销量从低到高</li>
                <li>价格从高到低</li>
                <li>价格从低到高</li>
            </ul>
        </div>
    </div>
</div><!----------------proList------------------------->
<ul class="proList wrapper clearfix">
    <c:forEach var="goods" items="${goodsList2}">
        <li><a href='../getGoodUseID?goodID=${goods.goodsID}'>
            <dl>
                <dt><img src="/${goods.goodsPicUrl}"></dt>
                <dd>${goods.goodsName}</dd>
                <dd>￥${goods.goodsPrice}</dd>
            </dl>
        </a></li>
    </c:forEach>
</ul><!----------------mask------------------->
<div class="mask"></div><!-------------------mask内容------------------->
<div class="proDets"><img class="off" src="../photo/cc_img/temp/off.jpg"/>
    <div class="tit clearfix"><h4 class="fl">【最家】非洲菊仿真花干花</h4><span class="fr">￥17.90</span></div>
    <div class="proCon clearfix">
        <div class="proImg fl"><img class="list" src="../photo/cc_img/temp/proDet.jpg"/>
            <div class="smallImg clearfix"><img src="../photo/cc_img/temp/proDet01.jpg" data-src="../photo/cc_img/temp/proDet01_big.jpg"><img
                    src="../photo/cc_img/temp/proDet02.jpg" data-src="../photo/cc_img/temp/proDet02_big.jpg"><img src="../photo/cc_img/temp/proDet03.jpg"
                                                                                          data-src="../photo/cc_img/temp/proDet03_big.jpg"><img
                    src="../photo/cc_img/temp/proDet04.jpg" data-src="../photo/cc_img/temp/proDet04_big.jpg"></div>
        </div>
        <div class="fr">
            <div class="proIntro"><p>颜色分类</p>
                <div class="smallImg clearfix categ"><p class="fl"><img src="../photo/cc_img/temp/prosmall01.jpg" alt="白瓷花瓶+20支快乐花"
                                                                        data-src="../photo/cc_img/temp/proBig01.jpg"></p>
                    <p class="fl"><img src="../photo/cc_img/temp/prosmall02.jpg" alt="白瓷花瓶+20支兔尾巴草"
                                       data-src="../photo/cc_img/temp/proBig02.jpg"></p>
                    <p class="fl"><img src="../photo/cc_img/temp/prosmall03.jpg" alt="20支快乐花" data-src="../photo/cc_img/temp/proBig03.jpg"></p>
                    <p class="fl"><img src="../photo/cc_img/temp/prosmall04.jpg" alt="20支兔尾巴草" data-src="../photo/cc_img/temp/proBig04.jpg"></p>
                </div>
                <p>数量</p>
                <div class="num clearfix"><img class="fl sub" src="../photo/cc_img/temp/sub.jpg"><span class="fl"
                                                                                           contentEditable="true">1</span><img
                        class="fl add" src="../photo/cc_img/temp/add.jpg">
                    <p class="please fl">请选择商品属性!</p></div>
            </div>
            <div class="btns clearfix"><a href="#2"><p class="buy fl">立即购买</p></a><a href="#2"><p class="cart fr">
                加入购物车</p></a></div>
        </div>
    </div>
    <a class="more" href="getGoodUseID?$goodID={goods.goodsID}">查看更多细节</a></div><!--返回顶部-->
<div class="gotop"><a href="cart.html">
    <dl class="goCart">
        <dt><img src="../photo/cc_img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
        <span>1</span></dl>
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
<script src="../js/cc_js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/cc_js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>