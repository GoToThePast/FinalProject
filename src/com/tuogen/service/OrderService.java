package com.tuogen.service;

import com.tuogen.model.Order;

import java.util.List;

public interface OrderService {
    /**
     * 生成订单
     * @param userID 用户ID
     * @param goodsID 商品编号
     * @return 生成的订单
     */
    Order createOrder(int userID, List<Integer> goodsID);

    /**
     * 支付订单
     * @param orderID 订单编号
     * @return 支付是否成功
     */
    boolean payOrder(int orderID);
}
