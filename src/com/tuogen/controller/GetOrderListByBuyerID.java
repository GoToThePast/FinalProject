package com.tuogen.controller;

import com.tuogen.model.Buyer;
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
@WebServlet("/listOrderBuyer")
public class GetOrderListByBuyerID extends HttpServlet {
    private int pageNum=4;
    OrderService orderService=new OrderServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("获取商品");
        //获取买家实体类
        Buyer buyer=(Buyer) req.getSession().getAttribute("buyer");
        HttpSession session = req.getSession();
        //获取页面Index
        int pageIndex=Integer.parseInt(req.getParameter("pageIndex"));
        // 获取订单总数
        int allCount=orderService.getOrderCount(buyer.getId());
        System.out.println("页数"+pageIndex+"总页数"+allCount);
        if(pageIndex<0){
            req.setAttribute("pageIndex",0);
            pageIndex=0;
        }else if(pageIndex>allCount/pageNum){
            req.setAttribute("pageIndex",allCount/pageNum);
            pageIndex=allCount/pageNum;
        }else{
            req.setAttribute("pageIndex",pageIndex);
        }
        //更具买家ID 以及页面查询数目确定查询订单
        List<OrderQuery> buyerOrderList = orderService.getOrderQueryListByBuyer(buyer.getId(),pageIndex*pageNum,pageNum);
        //写入session
        session.setAttribute("buyerOrderList",buyerOrderList);
        req.getRequestDispatcher("view/myorderq.jsp").forward(req,resp);
//        resp.sendRedirect("/web/manage/orderMang.jsp");
    }
}
