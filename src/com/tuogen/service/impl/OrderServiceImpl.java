package com.tuogen.service.impl;

import com.tuogen.model.Order;
import com.tuogen.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public List<Order> createOrder(int userID, List<Integer> goodsID) {
        return null;
    }

    @Override
    public boolean payOrder(List<Integer> ordersID) {
        return false;
    }
}
