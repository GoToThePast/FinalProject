<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="index.html"><img src="../photo/cc_img/logo.png"/></a></h1>
            <div class="fr clearfix" id="top1"><p class="fl">
            	<c:if test="${isLogin !=1 }">
            		<a href="login.jsp" id="login">登录</a><a href="reg.jsp" id="reg">注册</a>
            	
            	</c:if>
            	
            	<c:if test="${isLogin ==1 }">
            		<b>你好：</b><a href="login.jsp" id="login">${buyer.name}</a>
            	
            	</c:if>
            </p>
                <form action="#" method="get" class="fl"><input type="text" placeholder="热门搜索：干花花瓶"/><input
                        type="button"/></form>
                <div class="btn fl clearfix">
                    <a href="mygxin.jsp"><img src="../photo/cc_img/grzx.png"/>
                      <c:if test="${isLogin ==1 }">  
                        <a href="cart.html"><img src="../photo/cc_img/gwc.png"/></a>
                       </c:if> 
                        
                    <p><a href="#"><img src="../photo/cc_img/smewm.png"/></a></p></div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="../getGoodsByType">首页</a>
                <div class="sList">
                    <div class="wrapper  clearfix"><a href="paint.html">
                        <dl>
                            <dt><img src="../photo/cc_img/nav1.jpg"/></dt>
                            <dd>装饰摆件</dd>
                        </dl>
                    </a><a href="paint.html">
                        <dl>
                            <dt><img src="../photo/cc_img/nav2.jpg"/></dt>
                            <dd>布艺软饰</dd>
                        </dl>
                    </a><a href="paint.html">
                        <dl>
                            <dt><img src="../photo/cc_img/nav3.jpg"/></dt>
                            <dd>墙式壁挂</dd>
                        </dl>
                    </a><a href="paint.html">
                        <dl>
                            <dt><img src="../photo/cc_img/nav6.jpg"/></dt>
                            <dd>蜡艺香薰</dd>
                        </dl>
                    </a><a href="#1">
                        <dl>
                            <dt><img src="../photo/cc_img/nav7.jpg"/></dt>
                            <dd>创意家居</dd>
                        </dl>
                    </a></div>
                </div>
            </li>
            <li><a href="../getGoodsByType?type=餐厅家具">餐厅家具</a></li>
            <li><a href="../getGoodsByType?type=书房家具">书房家具</a></li>
            <li><a href="../getGoodsByType?type=厨房家具">厨房家具</a></li>
            <li><a href="../getGoodsByType?type=卫生间家具">卫生间家具</a></li>
            <li><a href="../getGoodsByType?type=户外家具">户外家具</a></li>
        </ul>
    </div>
</div>