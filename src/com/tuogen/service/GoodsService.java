package com.tuogen.service;

import com.tuogen.model.Goods;

import java.util.List;

public interface GoodsService {
    /**
     * 根据商品id获取商品
     * @param goodsID
     * @return
     */
    Goods getGoods(int goodsID);
    /**
     * 根据商品类型获取所有该类型的商品
     * @param type
     * @return 商品List
     */
    List<Goods> getGoodsListType(String type);
}
