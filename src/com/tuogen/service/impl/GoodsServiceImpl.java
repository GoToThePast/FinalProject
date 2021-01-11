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
    public List<Goods> getGoodsList(int goodsstart, int goodsnum,int sellid) {
        List<Goods> goodsList=null;
        try {
            goodsList= goodsDao.getGoodsList(goodsstart,goodsnum,sellid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return goodsList;
    }

    @Override
    public List<Goods> getGoodsListUser(int goodsstart, int goodsnum) {
        List<Goods> goodsList=null;
        try {
            goodsList= goodsDao.getGoodsListUser(goodsstart,goodsnum);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return goodsList;
    }

    @Override
    public List<Goods> GoodsListType(String goodstype) {
        List<Goods> goodsListType=null;
        try {
            goodsListType= goodsDao.getGoodsListType(goodstype);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return goodsListType;
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
    public int goodsMerchantID(int goodID) {
        int goodsSellID=0;
        try {
            goodsSellID= goodsDao.goodsMerchantID(goodID);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return goodsSellID;
    }

    @Override
    public double getGoodsPriceByID(int goodID) {
        double price=0;
        try {
            price= goodsDao.getGoodsPriceByID(goodID);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return price;
    }

    @Override
    public void getGoodsListType(String type) {
        // 待实现

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
