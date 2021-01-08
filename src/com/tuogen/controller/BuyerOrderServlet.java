package com.tuogen.controller;

import com.tuogen.model.Order;
import com.tuogen.service.OrderService;
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

@WebServlet(urlPatterns = "/BuyOrder/*")
public class BuyerOrderServlet extends BaseServlet {
    OrderService orderService=new OrderServiceImpl();
    public void addOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order=getOrder(req,resp);
        boolean tag=orderService.addOrder(order);
        if(tag){
            req.setAttribute("isAdd",true);
        }else{
            req.setAttribute("isAdd",false);
        }
        req.getRequestDispatcher("#").forward(req,resp);
    }
    public void queryOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order=null;
        Long orderNum=null;
        order =orderService.queryUser(orderNum);
        req.setAttribute("order",order);
        req.getRequestDispatcher("#").forward(req,resp);
    }

    private Order getOrder(HttpServletRequest req, HttpServletResponse resp) {
        Order order=null;
        order.setOrderNum(Long.parseLong(req.getParameter("#")));
        order.setOrderUserNum(Integer.parseInt(req.getParameter("#")));
        order.setGoodsListId(Integer.parseInt(req.getParameter("#")));
        order.setOrderStatus(req.getParameter("#"));
        order.setCreaterTime(Timestamp.valueOf(req.getParameter("#")));
        order.setMerchantId(Integer.parseInt(req.getParameter("#")));
        order.setTotalPrice(Double.parseDouble(req.getParameter("#")));
        return order;
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
        List<Order> orderList = orderService.getOrderList();
        HttpSession session = req.getSession();
        session.setAttribute("orderList",orderList);
//        req.getRequestDispatcher("/manage/index.jsp").forward(req,resp);
        resp.sendRedirect("/web/manage/index.jsp");
    }
}
