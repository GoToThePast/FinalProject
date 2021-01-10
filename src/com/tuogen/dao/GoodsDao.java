package com.tuogen.dao;

import com.tuogen.model.Goods;

import java.sql.SQLException;
import java.util.List;

public interface GoodsDao {
    public void addGoods(Goods goods) throws SQLException;
    public int getGoodsCount() throws SQLException;
    public List<Goods> getGoodsList(int goodsstart,int goodsnum) throws SQLException;
    public int deleteGoods(int goodsId) throws SQLException;
    public Goods queryGoods(int goodsid) throws SQLException;
    public Goods queryGoodsList(String goodstype) throws SQLException ;//查看分类
    public int updateGoods(Goods goods) throws SQLException;
    public Goods getGoods(String goodsname) throws SQLException;
}
