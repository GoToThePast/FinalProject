package com.tuogen.service;

import com.tuogen.model.Goods;

import java.util.List;

public interface GoodsService {
    public void addGoods(Goods goods) ;
    public int getGoodsCount() ;
    public List<Goods> getGoodsList(int goodsstart, int goodsnum) ;
    public int deleteGoods(int goodsId) ;
    public Goods queryGoods(int goodsid) ;
    public Goods queryGoodsList(String goodstype) ;//查看分类
    public int updateGoods(Goods goods) ;
    public Goods getGoods(String goodsname) ;


    void getGoodsList(String type);

    int goodsMerchantID(int goodID);
}
