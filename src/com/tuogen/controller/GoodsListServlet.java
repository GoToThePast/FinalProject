package com.tuogen.controller;

import com.tuogen.model.Goods;
import com.tuogen.service.GoodsService;
import com.tuogen.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GoodsListServlet",urlPatterns = "/goodsList")
public class GoodsListServlet extends HttpServlet {
    GoodsService goodsService=new GoodsServiceImpl();
    private static final int count = 4;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageIndexStr = request.getParameter("pageIndex");
        if (pageIndexStr==null||pageIndexStr=="")
            pageIndexStr="1";
        int pageIndex = Integer.parseInt(pageIndexStr);
        pageIndex=pageIndex<=0?1:pageIndex;
        int goodsCount = goodsService.getGoodsCount();
        int pageNum=goodsCount/count+(goodsCount%count==0?0:1);
        request.setAttribute("pageCount",pageNum);
        if(pageIndex>pageNum){
            pageIndex=pageNum;
        }else if(pageIndex<=0){
            pageIndex=1;
        }
        List<Goods> goodsList = goodsService.getGoodsList((pageIndex - 1) * count, count);
        request.setAttribute("pageIndex",pageIndex);
        request.setAttribute("goodsList",goodsList);
        request.getRequestDispatcher("view/goodslist.jsp").forward(request,response);
    }
    private void checkSessionStatus(HttpServletRequest request,String statusName) {
        HttpSession session = request.getSession();
        String status = (String)session.getAttribute(statusName);
        if (status!=null){
            session.removeAttribute(statusName);
            if ("true".equals(status)){
                request.setAttribute(statusName.substring(0,statusName.lastIndexOf("Status"))+"Success",1);
            }else{
                request.setAttribute(statusName.substring(0,statusName.lastIndexOf("Status"))+"Failed",1);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
