<%--
  Created by IntelliJ IDEA.
  User: 周睿锋
  Date: 2021/1/6
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <title>后台管理系统</title>
</head>
<style>
    .rt_wrap{
        height:100%;
        position:relative;
    }
    .rt_content{
        margin-bottom:80px;
        margin-right:8px;
        overflow:hidden;
    }
    .page_title{
        height:40px;
        line-height:40px;
        border-bottom:1px #b6b6b6 solid;
        margin:10px 0;
    }
    .page_title h2{
        font-size:15px;
        font-weight:bold;
    }
    .page_title .top_rt_btn{
        display:inline-block;
        height:30px;
        line-height:30px;
        padding:0 15px;
        border:1px #d2d2d2 solid;
        background:#f8f8f8;
        color:#19a97b;
        vertical-align:middle;
        cursor:pointer;
    }
    .fl{
        float:left;
    }
    .fr{
        float:right;
    }
    .top_rt_btn{
        display:inline-block;
        height:30px;
        line-height:30px;
        padding:0 15px;
        border:1px #d2d2d2 solid;
        background:#f8f8f8;
        color:#19a97b;
        vertical-align:middle;
        cursor:pointer;
    }
    .add_icon:before{
        content:"+";
        margin:0 5px;
    }
    table
    {border-collapse:collapse;
        border-spacing:0
    }
    .table{width:100%;
        table-layout:fixed;
        margin:5px 0;
    }
    .table th{
        border:1px #d2d2d2 solid;
        height:40px;
        line-height:40px;
    }
    .table td
    {border:1px #d2d2d2 solid;
        padding:10px 8px;
        position:relative;
    }
    .table tr:hover
    {background:#f9f9f9;
    }
    .table td a{
        color:#19a97b;
        margin:0 5px;
        cursor:pointer;
    }
    .center{
        text-align:center
    }
    .rmb_icon{
        color:#19a97b;
    }
    .rmb_icon:before{
        content:"￥";
        margin-right:2px;
    }
    .paging{margin:8px 0;
        overflow:hidden;
        text-align:right;
    }
    .paging a{background:#19a97b;
        border:1px #139667 solid;
        color:white;padding:5px 8px;
        display:inline-block;
        cursor:pointer;
    }
    .paging a:hover{
        background:#11a274;
        border:1px #0e8f61 solid;
    }
    .paging a:active{
        background:#17a578;
        border:1px #0e8f61 solid;
    }
</style>
<body>
<section class="rt_wrap content mCustomScrollbar">
    <div class="rt_content">
        <div class="page_title">
            <h2 class="fl">商品列表</h2>
            <a href="add_goods.jsp" class="fr top_rt_btn add_icon">添加商品</a>
        </div>
        <table class="table">
            <tr>
                <th>缩略图</th>
                <th>商品编号</th>
                <th>商品名称</th>
                <th>商品类型</th>
                <th>商品价格</th>
                <th>商品库存</th>
                <th>卖家编号</th>
                <th>商品介绍</th>
                <th>操作</th>
            </tr>
            <c:forEach var="goods" items="${goodsList}">
            <tr>
                <td class="center"><img src="/${goods.goodsPicUrl}" width="50" height="50"/></td>
                <td class="center" id="gid">${goods.goodsID}</td>
                <td id="gname">${goods.goodsName}</td>
                <td class="center" id="gtype">${goods.goodsType}</td>
                <td class="center" id="gprice"><strong class="rmb_icon">${goods.goodsPrice}</strong></td>
                <td class="center" id="gstock">${goods.goodsStock}</td>
                <td class="center" id="gsellid">${goods.goodsSellID}</td>
                <td class="center" id="gintroduce">${goods.goodsIntroduce}</td>
                <td class="center">
                    <a href="/web/gmodPer?goodsId=${goods.goodsID}" title="编辑" ><img src="/web/photo/page/编辑.png" width="30" height="30"/></a>
                    <a href="/web/delGoods?goodsId=${goods.goodsID}" title="删除" ><img src="/web/photo/page/删除.png" width="30" height="30"/></a>
                </td>
            </tr>
            </c:forEach>
        </table>
        <aside class="paging">
            <a href="/web/goodsList?pageIndex=${(pageIndex-1)<1?1:(pageIndex-1)}">上一页</a>
            <a> 第${pageIndex}页</a>
            <a href="/web/goodsList?pageIndex=${(pageIndex+1)>pageCount?pageCount:(pageIndex+1)}">下一页</a>
        </aside>
    </div>
</section>
</body>
</html>

