package com.tuogen.controller;

import com.tuogen.model.Goods;
import com.tuogen.service.GoodsService;
import com.tuogen.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Made By 王炜
 * 根据类型获取商品类型
 * 参数：商品类型 type
 */
@WebServlet("/getGoodsByType")
public class GetGoodsByTypeServlet extends HttpServlet {
    private GoodsService goodsService=new GoodsServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        // TODO: 2021/1/9 goodsService.getGoodsListType
        List<Goods> goodsList= goodsService.getGoodsListType(type);
        request.setAttribute("goodsList",goodsList);
        // TODO: 2021/1/15 商品列表地址
        request.getRequestDispatcher("").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
