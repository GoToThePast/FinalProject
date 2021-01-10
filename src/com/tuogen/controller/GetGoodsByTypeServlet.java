package com.tuogen.controller;

import com.tuogen.service.GoodsService;
import com.tuogen.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Made By 王炜
 * 根据类型获取商品类型
 * 参数：商品类型 type
 */
@WebServlet("/getGoodsByType")
public class GetGoodsByTypeServlet extends HttpServlet {
    private GoodsService goodsService=new GoodsServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: 2021/1/8 编码待删除
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        goodsService.getGoodsList(type);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
