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
    <link rel="stylesheet" type="text/css" href="css/myorderInfo.css"/>
    <script src="./js/jquery2_14.js"></script>
</head>
<body>
    <div class="pageBody">
        <form action="MerOrder/listOrder" method="post">
            <tr>
                <td>
                    请输入你的用户名：
                    <input type="text" name="txtName" maxlength="10">
                    (10个字符以内)
                </td>
            </tr>
            <tr>
                <td>
                    请输入你的密码：
                    <input type="password" name="txtPW" maxlength="15">
                    (15个字符以内)
                </td>
            </tr>
            <tr>
                <td>
                    请选择你的性别：
                    <input type="radio" name="gender" value="男">
                    男 &nbsp;
                    <input type="radio" name="gender" value="女">
                    女
                </td>
            </tr>
            <tr>
                <td>
                    年龄：
                    <select name="selH">
                        <option value="00后">00后</option>
                        <option value="90后">90后</option>
                        <option value="70后">70后</option>
                        <option value="60后">60后</option>
                        <option value="其他">其他</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    请输入你的爱好：
                    <input type="checkbox" name="txtLOVE" value="阅读">
                    阅读&nbsp;
                    <input type="checkbox" name="txtLOVE" value="音乐">
                    音乐&nbsp;
                    <input type="checkbox" name="txtLOVE" value="运动">
                    运动&nbsp;
                    <input type="checkbox" name="txtLOVE" value="其他">
                    其他&nbsp;
                </td>
            </tr>
            <tr>
                <td>
                    上传头像:<input type="file" name="uPhoto"><br/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="提交"></a>
                    <input type="reset" value="重置" ></a>
                </td>
            </tr>
        </form>
    </div>
</body>
</html>
