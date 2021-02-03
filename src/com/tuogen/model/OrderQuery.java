package com.tuogen.model;

import java.util.Vector;

/**
 * @ClassName: OrderQuery
 * @Description: TODO
 * @Author: HLX
 * @date: 2021/1/10 12:14
 * @Version: V1.0
 */
public class OrderQuery {
    Order order=null;
    // 订单 商品id

    Vector<Integer> goodsId=null;
    Vector<Goods> goods=null;

    public Order getOrder() {
        return order;
    }
    OrderQuery(Order order,Vector<Integer> goodsId,Vector<Goods> goods){
        this.order=order;
        this.goodsId=goodsId;
        this.goods=goods;
    }
    public OrderQuery(){

    }

    @Override
    public String toString() {
        return order.toString()+" 商品ID:"+goodsId.toString()+" 商品详情:"+goods.toString();
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Vector<Integer> getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Vector<Integer> goodsId) {
        this.goodsId = goodsId;
    }

    public Vector<Goods> getGoods() {
        return goods;
    }

    public void setGoods(Vector<Goods> goods) {
        this.goods = goods;
    }
}
