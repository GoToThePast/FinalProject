<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>详情页</title>
    <link rel="stylesheet" type="text/css" href="../css/cc_css/public.css"/>
    <link rel="stylesheet" type="text/css" href="../css/cc_css/proList.css"/>
</head>
<body><!------------------------------head------------------------------>

<%@ include file="header.jsp" %>

<!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix">
    		<a href="indexselect">首页</a><span>/</span>
    		<a href="selectproductlist?cid=${cate.CATE_ID }">${cate.CATE_NAME }</a><span>/</span>
    		<a href="#" class="on">${p.PRODUCT_NAME }</a>
    </div>
</div><!-----------------------Detail------------------------------>
<div class="detCon">
    <div class="proDet wrapper">
        <div class="proCon clearfix">
            <div class="proImg fl">
            <img class="det" src="images/product/${p.PRODUCT_FILENAME }"/>
                <div class="smallImg clearfix"><img src="images/product/${p.PRODUCT_FILENAME }"
                                                    data-src="images/product/${p.PRODUCT_FILENAME }"><img
                        src="../photo/cc_img/temp/proDet02.jpg" data-src="../photo/cc_img/temp/proDet02_big.jpg"><img
                        src="../photo/cc_img/temp/proDet03.jpg" data-src="../photo/cc_img/temp/proDet03_big.jpg"><img
                        src="../photo/cc_img/temp/proDet04.jpg" data-src="../photo/cc_img/temp/proDet04_big.jpg"></div>
            </div>
            <div class="fr intro">
                <div class="title"><h4>【最家】${p.PRODUCT_NAME }</h4>
                    <p>【${p.PRODUCT_DESCRIPTION }】</p><span>￥${p.PRODUCT_PRICE }.00</span></div>
                <div class="proIntro"><p>颜色分类</p>
                    <div class="smallImg clearfix categ"><p class="fl"><img src="images/product/${p.PRODUCT_FILENAME }"
                                                                            alt="白瓷花瓶+20支快乐花"
                                                                            data-src="images/product/${p.PRODUCT_FILENAME }"></p>
                        <p class="fl"><img src="../photo/cc_img/temp/prosmall02.jpg" alt="白瓷花瓶+20支兔尾巴草"
                                           data-src="../photo/cc_img/temp/proBig02.jpg"></p>
                        <p class="fl"><img src="../photo/cc_img/temp/prosmall03.jpg" alt="20支快乐花" data-src="../photo/cc_img/temp/proBig03.jpg">
                        </p>
                        <p class="fl"><img src="../photo/cc_img/temp/prosmall04.jpg" alt="20支兔尾巴草" data-src="../photo/cc_img/temp/proBig04.jpg">
                        </p></div>
                    <p>数量&nbsp;&nbsp;库存<span>${p.PRODUCT_STOCK }</span>件</p>
                    <div class="num clearfix">
                    		<img class="fl sub" src="../photo/cc_img/temp/sub.jpg">
                    		<span id="count" class="fl" contentEditable="true">1</span><img
                            class="fl add" src="../photo/cc_img/temp/add.jpg">
                        <p class="please fl">请选择商品属性!</p></div>
                </div>
                <div class="btns clearfix">
                	<a href="javascript:shopAdd(${p.PRODUCT_ID },'z')"><p class="buy fl">立即购买</p></a>
                	<a href="javascript:shopAdd(${p.PRODUCT_ID },'s')""><p class="cart fr"> 加入购物车</p></a></div>
            </div>
        </div>
    </div>
</div>

<script>
	function shopAdd(id, url) {
		var count = document.getElementById("count").innerHTML;
		
		location.href='cartadd?id='+id+'&count='+count+'&url='+url;
		
	}

</script>

<div class="introMsg wrapper clearfix">
    <div class="msgL fl">
        <div class="msgTit clearfix"><a class="on">商品详情</a><a>所有评价</a></div>
        <div class="msgAll">
            <div class="msgImgs"><img src="../photo/cc_img/temp/det01.jpg"><img src="../photo/cc_img/temp/det02.jpg"><img
                    src="../photo/cc_img/temp/det03.jpg"><img src="../photo/cc_img/temp/det04.jpg"><img src="../photo/cc_img/temp/det05.jpg"><img
                    src="../photo/cc_img/temp/det06.jpg"><img src="../photo/cc_img/temp/det07.jpg"></div>
            <div class="eva">
                <div class="per clearfix"><img class="fl" src="../photo/cc_img/temp/per01.jpg">
                    <div class="perR fl"><p>馨***呀</p>
                        <p>不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分</p>
                        <div class="clearfix"><p><img src="../photo/cc_img/temp/eva01.jpg"></p>
                            <p><img src="../photo/cc_img/temp/eva02.jpg"></p>
                            <p><img src="../photo/cc_img/temp/eva03.jpg"></p>
                            <p><img src="../photo/cc_img/temp/eva04.jpg"></p>
                            <p><img src="../photo/cc_img/temp/eva05.jpg"></p></div>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="../photo/cc_img/temp/per02.jpg">
                    <div class="perR fl"><p>么***周</p>
                        <p>花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！</p>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="../photo/cc_img/temp/per01.jpg">
                    <div class="perR fl"><p>馨***呀</p>
                        <p>不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分</p>
                        <div class="clearfix"><p><img src="../photo/cc_img/temp/eva01.jpg"></p>
                            <p><img src="../photo/cc_img/temp/eva02.jpg"></p>
                            <p><img src="../photo/cc_img/temp/eva03.jpg"></p>
                            <p><img src="../photo/cc_img/temp/eva04.jpg"></p>
                            <p><img src="../photo/cc_img/temp/eva05.jpg"></p></div>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="../photo/cc_img/temp/per02.jpg">
                    <div class="perR fl"><p>么***周</p>
                        <p>花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！</p>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="../photo/cc_img/temp/per01.jpg">
                    <div class="perR fl"><p>馨***呀</p>
                        <p>不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分</p>
                        <div class="clearfix"><p><img src="../photo/cc_img/temp/eva01.jpg"></p>
                            <p><img src="../photo/cc_img/temp/eva02.jpg"></p>
                            <p><img src="../photo/cc_img/temp/eva03.jpg"></p>
                            <p><img src="../photo/cc_img/temp/eva04.jpg"></p>
                            <p><img src="../photo/cc_img/temp/eva05.jpg"></p></div>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="../photo/cc_img/temp/per02.jpg">
                    <div class="perR fl"><p>么***周</p>
                        <p>花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！</p>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="../photo/cc_img/temp/per01.jpg">
                    <div class="perR fl"><p>馨***呀</p>
                        <p>不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分</p>
                        <div class="clearfix"><p><img src="../photo/cc_img/temp/eva01.jpg"></p>
                            <p><img src="../photo/cc_img/temp/eva02.jpg"></p>
                            <p><img src="../photo/cc_img/temp/eva03.jpg"></p>
                            <p><img src="../photo/cc_img/temp/eva04.jpg"></p>
                            <p><img src="../photo/cc_img/temp/eva05.jpg"></p></div>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="../photo/cc_img/temp/per02.jpg">
                    <div class="perR fl"><p>么***周</p>
                        <p>花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！</p>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="../photo/cc_img/temp/per01.jpg">
                    <div class="perR fl"><p>馨***呀</p>
                        <p>不好意思评价晚了，产品很好，价格比玻璃品便宜，没有我担心的杂色，发货快，包装好，全5分</p>
                        <div class="clearfix"><p><img src="../photo/cc_img/temp/eva01.jpg"></p>
                            <p><img src="../photo/cc_img/temp/eva02.jpg"></p>
                            <p><img src="../photo/cc_img/temp/eva03.jpg"></p>
                            <p><img src="../photo/cc_img/temp/eva04.jpg"></p>
                            <p><img src="../photo/cc_img/temp/eva05.jpg"></p></div>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
                <div class="per clearfix"><img class="fl" src="../photo/cc_img/temp/per02.jpg">
                    <div class="perR fl"><p>么***周</p>
                        <p>花瓶超级棒，我看图以为是光面的，收货发现是磨砂，但感觉也超有质感，很喜欢。磨砂上面还有点纹路，不过觉得挺自然的，不影响美观。包装也很好，绝对不会磕碎碰坏，好评！</p>
                        <p><span>2016年12月27日08:31</span><span>颜色分类：大中小三件套（不含花）</span></p></div>
                </div>
            </div>
        </div>
    </div>
    <div class="msgR fr" style="width:200px;"><h4>为你推荐</h4>
        <div class="seeList">
        <c:forEach var="cp" items="${classlist }">
        <a href="selectproductview?id=${cp.PRODUCT_ID }">
            <dl>
                <dt><img src="images/product/${cp.PRODUCT_FILENAME }"></dt>
                <dd>【学习猿地】${cp.PRODUCT_NAME }</dd>
                <dd>￥${cp.PRODUCT_PRICE }.00</dd>
            </dl>
        </a>
        </c:forEach>
        
        <a href="#">
            <dl>
                <dt><img src="../photo/cc_img/temp/see02.jpg"></dt>
                <dd>【最家】复古文艺风玻璃花瓶</dd>
                <dd>￥193.20</dd>
            </dl>
        </a>
        
        <a href="#">
            <dl>
                <dt><img src="../photo/cc_img/temp/see03.jpg"></dt>
                <dd>【最家】复古文艺风玻璃花瓶</dd>
                <dd>￥193.20</dd>
            </dl>
        </a><a href="#">
            <dl>
                <dt><img src="../photo/cc_img/temp/see04.jpg"></dt>
                <dd>【最家】复古文艺风玻璃花瓶</dd>
                <dd>￥193.20</dd>
            </dl>
        </a></div>
    </div>
</div>
<div class="like"><h4>最近访问</h4>
    <div class="bottom">
        <div class="hd"><span class="prev"><img src="../photo/cc_img/temp/prev.png"></span><span class="next"><img
                src="../photo/cc_img/temp/next.png"></span></div>
        <div class="imgCon bd">
            <div class="likeList clearfix">
                <div>
                
                
                 <c:forEach var="lp" items="${lastlylist }">
			        <a href="selectproductview?id=${lp.PRODUCT_ID }">
			            <dl>
			                <dt><img src="images/product/${lp.PRODUCT_FILENAME }"></dt>
			                <dd>【学习猿地】${lp.PRODUCT_NAME }</dd>
			                <dd>￥${lp.PRODUCT_PRICE }.00</dd>
			            </dl>
			        </a>
       			 </c:forEach>
                
                
                <a href="proDetail.html">
                    <dl>
                        <dt><img src="../photo/cc_img/temp/like01.jpg"></dt>
                        <dd>【最家】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a>
                
                <a href="proDetail.html">
                    <dl>
                        <dt><img src="../photo/cc_img/temp/like02.jpg"></dt>
                        <dd>【最家】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a><a href="proDetail.html">
                    <dl>
                        <dt><img src="../photo/cc_img/temp/like03.jpg"></dt>
                        <dd>【最家】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a><a href="proDetail.html">
                    <dl>
                        <dt><img src="../photo/cc_img/temp/like04.jpg"></dt>
                        <dd>【最家】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a><a href="proDetail.html" class="last">
                    <dl>
                        <dt><img src="../photo/cc_img/temp/like05.jpg"></dt>
                        <dd>【最家】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a></div>
                <div><a href="proDetail.html">
                    <dl>
                        <dt><img src="../photo/cc_img/temp/like01.jpg"></dt>
                        <dd>【最家】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a><a href="proDetail.html">
                    <dl>
                        <dt><img src="../photo/cc_img/temp/like02.jpg"></dt>
                        <dd>【最家】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a><a href="proDetail.html">
                    <dl>
                        <dt><img src="../photo/cc_img/temp/like03.jpg"></dt>
                        <dd>【最家】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a><a href="proDetail.html">
                    <dl>
                        <dt><img src="../photo/cc_img/temp/like04.jpg"></dt>
                        <dd>【最家】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a><a href="proDetail.html" class="last">
                    <dl>
                        <dt><img src="../photo/cc_img/temp/like05.jpg"></dt>
                        <dd>【最家】复古文艺风玻璃花瓶</dd>
                        <dd>￥193.20</dd>
                    </dl>
                </a></div>
            </div>
        </div>
    </div>
</div><!--返回顶部-->
<div class="gotop"><a href="showcart">
    <dl class="goCart">
        <dt><img src="../photo/cc_img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
        <span>3</span></dl>
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
<script src="../js/cc_js/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/cc_js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/cc_js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/cc_js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/cc_js/cart.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">jQuery(".bottom").slide({
    titCell: ".hd ul",
    mainCell: ".bd .likeList",
    autoPage: true,
    autoPlay: false,
    effect: "leftLoop",
    autoPlay: true,
    vis: 1
});</script>
</body>
</html>
