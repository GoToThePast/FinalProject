package service;

import model.Goods;
import java.util.List;

public interface GoodsService{
    public void addGoods(Goods goods) ;
    public int getGoodsCount() ;
    public List<Goods> getGoodsList(int goodsstart, int goodsnum) ;
    public List<Goods>  GoodsListType(String goodstype) ;//查看分类
    public int deleteGoods(int goodsId) ;
    public Goods queryGoods(int goodsid) ;
    public int updateGoods(Goods goods) ;
    public Goods getGoods(String goodsname) ;

}
