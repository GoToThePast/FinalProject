package dao;

import model.Goods;
import java.sql.SQLException;
import java.util.List;

public interface GoodsDao {
    public void addGoods(Goods goods) throws SQLException;
    public int getGoodsCount() throws SQLException;
    public List<Goods> getGoodsList(int goodsstart,int goodsnum) throws SQLException;
    public int deleteGoods(int goodsId) throws SQLException;
    public Goods queryGoods(int goodsid) throws SQLException;
    public int updateGoods(Goods goods) throws SQLException;
    public Goods getGoods(String goodsname) throws SQLException;
    public List<Goods> getGoodsListType(String goodstype) throws SQLException;//查看分类
    public  int goodsMerchantID(int goodID) throws SQLException;//通过商品ID得到商家ID
    public double getGoodsPriceByID(int goodID) throws SQLException;//通过商品ID得到价格

}
