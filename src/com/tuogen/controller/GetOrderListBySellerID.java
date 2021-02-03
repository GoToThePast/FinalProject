package com.tuogen.controller;

import com.tuogen.model.OrderQuery;
import com.tuogen.model.Seller;
import com.tuogen.service.OrderService;
import com.tuogen.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @User:Breeze
 * @ClassName: GetOrderList
 * @Description: TODO
 * @Author: HLX
 * @date: 2021/1/18 16:44
 * @Version: V1.0
 */
@WebServlet("/listOrder")
public class GetOrderListBySellerID extends HttpServlet {
    private int pageNum=4;
    OrderService orderService=new OrderServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("获取商品");
        Seller seller=(Seller) req.getSession().getAttribute("seller");
        HttpSession session = req.getSession();
        int pageIndex=Integer.parseInt(req.getParameter("orderPageIndex"));
        int allCount=orderService.getOrderCount(seller.getId());
        req.setAttribute("orderPageCount",allCount);
        System.out.println("页数"+pageIndex+"总页数"+allCount);
        if(pageIndex<0){
            req.setAttribute("orderPageIndex",0);
            pageIndex=0;
        }else if(pageIndex>allCount/pageNum){
            req.setAttribute("orderPageIndex",allCount/pageNum);
            pageIndex=allCount/pageNum;
        }else{
            req.setAttribute("orderPageIndex",pageIndex);
        }
        List<OrderQuery> orderQueryList = orderService.getOrderQueryList(seller.getId(),pageIndex*pageNum,pageNum);
        session.setAttribute("orderList",orderQueryList);
        req.getRequestDispatcher("manage/orderMang.jsp").forward(req,resp);
//        resp.sendRedirect("/web/manage/orderMang.jsp");
    }
}
