package com.tuogen.controller;

import com.tuogen.model.Order;
import com.tuogen.service.OrderService;
import com.tuogen.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Made By 王炜
 * 点击 购买 按钮
 * 根据用户ID和商品生成订单
 * 作用：携带生成订单 跳转至支付页面
 */
@WebServlet(urlPatterns = "/createOrder")
public class CreateOrderServlet extends HttpServlet {
    OrderService orderService=new OrderServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: 2021/1/8 编码待删除
        request.setCharacterEncoding("utf-8");
        //获取用户ID
        String userID = request.getParameter("userID");
        //获得所有商品编号
        List<Integer> goodsID = Arrays.stream(request.getParameterValues("goodsIDList")).
                map(id -> Integer.parseInt(id)).
                collect(Collectors.toList());
        // TODO: 2021/1/8 创建订单
        //创建订单并获取订单
        /**
         * Breeze
         * 更改方法接受类型为List
         * 2021.1.11 22：43
         */
        List<Order> order = orderService.createOrder(Integer.parseInt(userID), goodsID);
        //将订单信息加入属性供支付使用
        request.setAttribute("order",order);
        // TODO: 2021/1/8 跳转支付页面
        request.getRequestDispatcher("./view/").forward(request,response);
    }
}
