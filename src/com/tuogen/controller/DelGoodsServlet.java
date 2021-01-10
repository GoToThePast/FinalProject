package com.tuogen.controller;

import com.tuogen.service.GoodsService;
import com.tuogen.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DelUserServletServlet",urlPatterns = "/delGoods")
public class DelGoodsServlet extends HttpServlet {
    GoodsService goodsService=new GoodsServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int goodsId = Integer.parseInt(request.getParameter("goodsId"));
        if (goodsId<0)return;
        int isOK = goodsService.deleteGoods(goodsId);
        if (isOK>0){
            request.getSession().setAttribute("deleteStatus","true");
        }else{
            request.getSession().setAttribute("deleteStatus","false");
        }
        response.sendRedirect("/web_war_exploded/goodsList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
