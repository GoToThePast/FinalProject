package com.tuogen.service.impl;

import com.tuogen.dao.impl.GoodsDaoImpl;
import com.tuogen.model.Goods;
import com.tuogen.service.GoodsService;

import java.sql.SQLException;
import java.util.List;


public class GoodsServiceImpl implements GoodsService{
    GoodsDaoImpl goodsDao= new GoodsDaoImpl();

    @Override
    public void addGoods(Goods goods) {
        try {
            goodsDao.addGoods(goods);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public int getGoodsCount() {
        try {
            return goodsDao.getGoodsCount();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<Goods> getGoodsList(int goodsstart, int goodsnum) {
        List<Goods> goodsList=null;
        try {
            goodsList= goodsDao.getGoodsList(goodsstart,goodsnum);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return goodsList;
    }

    @Override
    public int deleteGoods(int goodsId) {
        int i=0;
        try {
            i=goodsDao.deleteGoods(goodsId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    @Override
    public Goods queryGoods(int goodsid) {
        Goods goods=null;
        try {
            goods= goodsDao.queryGoods(goodsid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return goods;
    }

    @Override
    public Goods queryGoodsList(String goodstype) {
        Goods goods=null;
        try {
            goods= goodsDao.queryGoodsList(goodstype);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return goods;
    }

    @Override
    public int updateGoods(Goods goods) {
        int i =-1;
        try {
            i=goodsDao.updateGoods(goods);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    @Override
    public Goods getGoods(String goodsname) {
        Goods goods=null;
        try {
            goods= goodsDao.getGoods(goodsname);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return goods;
    }
}
