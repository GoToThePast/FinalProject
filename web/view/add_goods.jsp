<%--
  Created by IntelliJ IDEA.
  User: 周睿锋
  Date: 2021/1/6
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    .center{
        text-align:center
    }
    .ulColumn2{
        overflow:hidden;
    }
    .ulColumn2 li
    {margin:15px 0;
    }
    .ulColumn2 li .item_name{
        text-align:right;
        display:inline-block;
    }
    .textbox{
        border:1px #139667 solid;
        height:26px;
        line-height:26px;
        padding:5px;
        font-size:12px;
        vertical-align:middle;
    }
    .textbox_295{
        width:295px;
    }
    .textbox_225{
        width:225px;
    }
    .uploadImg{
        display:inline-block;
        padding:15px;
        background:#f8f8f8;
        position:relative;
        border:1px #139667 solid;
    }
    .uploadImg input{
        display:none;
    }
    .uploadImg span{
        display:block;
        font-size:12px;
        text-align:center;
        color:#139667;
    }
    .uploadImg span:hover
    {color:#209f71;
    }
    .link_btn{
        border:1px #139667 solid;
        border-radius:2px;background:#19a97b;
        color:white;padding:8px 15px;
        display:inline-block;cursor:pointer;
    }
    .link_btn:hover
    {background:#11a274;
        border:1px #0e8f61 solid;
    }
    .link_btn:active{
        background:#0c9c6e;
        border:1px #0e8f61 solid;
    }

    ul li{
        list-style-type:none;
    }

</style>
<body>
<form  class="rt_wrap content mCustomScrollbar"  action="/web/AddGoods" method="post" enctype="multipart/form-data">
    <div class="rt_content">
        <div class="page_title">
            <h2 class="fl">添加商品</h2>
            <a  href="#" onClick="javascript :history.back(-1);" class="fr top_rt_btn">返回商品列表</a>
        </div>
        <section>
            <ul class="ulColumn2">
                <li>
                    <span class="item_name" style="width:120px;">商品名称：</span>
                    <input name="gname" type="text" class="textbox" placeholder="商品名称..."/>
                </li>
                <li>
                    <span class="item_name" style="width:120px;">商品类型：</span>
                    <select name="gtype" class="select">
                        <option>装饰摆件</option>
                        <option>布艺软饰</option>
                        <option>墙式壁挂</option>
                        <option>蜡艺香熏</option>
                        <option>创意家居</option>
                    </select>
                </li>
                <li>
                    <span class="item_name" style="width:120px;">商品价格：</span>
                    <input name="gprice" type="text" class="textbox" placeholder="商品价格..."/>
                </li>
                <li>
                    <span class="item_name" style="width:120px;">商品库存：</span>
                    <input name="gstock" type="text" class="textbox" placeholder="商品库存..."/>
                </li>
                <li>
                    <span class="item_name" style="width:120px;">上传图片：</span>
                    <label class="uploadImg">
                        <input name="gpic" type="file" onchange="previewFile()"><br>
                        <img src="../photo/page/图片.png" height="60" width="60" alt="Image preview..."  />
                    </label>
                </li>
                <script>
                    function previewFile() {
                        var preview = document.querySelector('img');
                        var file    = document.querySelector('input[type=file]').files[0];
                        var reader  = new FileReader();

                        reader.onloadend = function () {
                            preview.src = reader.result;
                        }

                        if (file) {
                            reader.readAsDataURL(file);
                        } else {
                            preview.src = "";
                        }
                    }
                </script>
                <li >
                    <span class="item_name" style="width:120px;">卖家编号：</span>
                    <input name="gsellid" type="text" class="textbox textbox_295" placeholder="卖家编号..."/>
                </li>
                <li>
                    <span class="item_name" style="width:120px;">商品介绍：</span>
                    <textarea name="gintroduce" cols="20" rows="5">商品介绍</textarea>
                </li>
                <li>
                    <span class="item_name" style="width:120px;"></span>
                    <input type="submit" class="link_btn"/>
                </li>
            </ul>
        </section>
    </div>
</form>
</body>
</html>

