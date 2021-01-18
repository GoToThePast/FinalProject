package com.tuogen.controller;

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
 * 支付servlet
 * 在订单页面供支付使用
 * 参数：订单编号 ordersID
 */
@WebServlet("/pay")
public class PayServlet extends HttpServlet {
    OrderService orderService=new OrderServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取订单编号
        List<Long> ordersID = Arrays.stream(request.getParameterValues("ordersID")).
                map(id -> Long.parseLong(id)).
                collect(Collectors.toList());
        boolean isOk=false;
//        boolean isOk = orderService.payOrder(ordersID);
        if (isOk){
            //支付成功 跳转至订单管理页面
            // TODO: 2021/1/8 跳转至订单管理页面
            response.sendRedirect("./view/");
        }else {
            //支付失败 跳转至支付页面
            // TODO: 2021/1/8 跳转至支付页面
            response.sendRedirect("./view/");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
