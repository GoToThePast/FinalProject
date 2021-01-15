package com.tuogen.service;

import com.tuogen.model.Goods;

import java.util.List;

public interface GoodsService{
    public void addGoods(Goods goods) ;
    public int getGoodsCount() ;
    public List<Goods> getGoodsList(int goodsstart, int goodsnum,int sellid) ;
    public List<Goods> getGoodsListUser(int goodsstart,int goodsnum);
    public List<Goods>  GoodsListType(String goodstype) ;//查看分类
    public int deleteGoods(int goodsId) ;
    public Goods queryGoods(int goodsid) ;
    public int updateGoods(Goods goods) ;
    public Goods getGoods(String goodsname);
    public  int goodsMerchantID(int goodID) ;//通过商品ID得到商家ID
    public double getGoodsPriceByID(int goodID);//通过商品ID得到价格

    //getGoodsByTypeServlet  中调用待实现
    public List<Goods> getGoodsListType(String type);
}
