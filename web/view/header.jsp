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
            <li><a href="indexselect">首页</a></li>
            <li><a href="selectproductlist?fid=${f.CATE_ID }">客厅家具</a></li>
            <li><a href="selectproductlist?fid=${f.CATE_ID }">餐厅家具</a></li>
            <li><a href="selectproductlist?fid=${f.CATE_ID }">书房家具</a></li>
            <li><a href="selectproductlist?fid=${f.CATE_ID }">厨房家具</a></li>
            <li><a href="selectproductlist?fid=${f.CATE_ID }">卫生间家具</a></li>
            <li><a href="selectproductlist?fid=${f.CATE_ID }">户外家具</a></li>
        </ul>
    </div>
</div>