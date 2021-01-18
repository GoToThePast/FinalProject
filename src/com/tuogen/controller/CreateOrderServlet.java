package com.tuogen.controller;

import com.tuogen.model.Goods;
import com.tuogen.model.Order;
import com.tuogen.model.OrderQuery;
import com.tuogen.service.GoodsService;
import com.tuogen.service.OrderService;
import com.tuogen.service.impl.GoodsServiceImpl;
import com.tuogen.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * Made By 王炜
 * 点击 购买 按钮
 * 根据用户ID和商品生成订单
 * 作用：携带生成订单 跳转至支付页面
 */
@WebServlet("/createOrder")
public class CreateOrderServlet extends HttpServlet {
    OrderService orderService=new OrderServiceImpl();
    GoodsService goodsService= new GoodsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户ID
        String userID = request.getParameter("userID");
        String goodsIDLists = request.getParameter("goodsIDList");
        System.out.println("用户ID"+userID+"商品ID集合"+goodsIDLists);
        //获得所有商品编号
        List<Integer> goodsID = Arrays.stream(request.getParameterValues("goodsIDList")).
                map(id -> Integer.parseInt(id)).
                collect(Collectors.toList());
        // TODO: 2021/1/8 创建订单

        //创建订单并获取订单

        List<Order> orderList = orderService.createOrder(Integer.parseInt(userID), goodsID);

        //创建订单集
        List<OrderQuery> qOrders=creatOrderQuerys(orderList);


        //将订单信息加入属性供支付使用
        request.getSession().setAttribute("qOrders",qOrders);
        request.setAttribute("orderList",orderList);
        // TODO: 2021/1/8 跳转支付页面
//        request.getRequestDispatcher("./view/cart.jsp").forward(request,response);
    }

    private List<OrderQuery> creatOrderQuerys(List<Order> orderList) {
        //创建订单集
        System.out.println("开始创建");
        List<OrderQuery> queryList=new ArrayList<>();
        for(Order order:orderList){
            // 创建订单信息原子
            OrderQuery orderQuery=new OrderQuery();
            //
            orderQuery.setOrder(order);

            orderQuery.setGoodsId(orderService.getGoodsByGoodListID(order.getGoodsListId()));

            Vector<Goods> goods=new Vector<>();
            for(int i:orderQuery.getGoodsId()){
                goods.add(goodsService.queryGoods(i));
            }
            orderQuery.setGoods(goods);
            queryList.add(orderQuery);
        }
        System.out.println(queryList.get(0).toString());
        return  queryList;
    }
}
