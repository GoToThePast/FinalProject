package com.tuogen.controller;

import com.tuogen.model.Goods;
import com.tuogen.model.Order;
import com.tuogen.model.OrderQuery;
import com.tuogen.model.Seller;
import com.tuogen.service.GoodsService;
import com.tuogen.service.OrderService;
import com.tuogen.service.impl.GoodsServiceImpl;
import com.tuogen.service.impl.OrderServiceImpl;
import com.tuogen.utils.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "merOrder",urlPatterns = "/MerOrder/*")
public class MerchantOrderServlet extends BaseServlet {
    OrderService orderService=new OrderServiceImpl();
    GoodsService goodsService=new GoodsServiceImpl();
    private int pageNum=4;
    public void queryOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order=null;
        Long orderNum=null;
        order =orderService.queryUser(orderNum);
        req.setAttribute("order",order);
        req.getRequestDispatcher("#").forward(req,resp);
    }
    public void delOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String delId=req.getParameter("delId");
        boolean tag=orderService.deleteOrder(Long.parseLong(delId));
        if(tag){
            req.setAttribute("isDel",true);
        }else{
            req.setAttribute("isDel",false);
        }
        req.getRequestDispatcher("#").forward(req,resp);
    }

    public void listOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
