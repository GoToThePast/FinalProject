package dao.impl;


import model.Goods;
import dao.GoodsDao;
import util.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class GoodsDaoImpl implements  GoodsDao {
    public Goods getGoods(String goodsname) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from goods where goodsName=?");
        statement.setString(1,goodsname);//给第一个问号赋值
        ResultSet resultSet = statement.executeQuery();//返回结果
        Goods goods=new Goods();
        while (resultSet.next()){
            getGoodsInfo(resultSet, goods);
        }
        JDBCUtils.close(connection,statement,resultSet);
        return goods;
    }

    @Override
    public void addGoods(Goods goods) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement =JDBCUtils.getConnection().prepareStatement("insert into goods values(?,?,?,?,?,?,?,?)");
        System.out.println(goods.getGoodsType()+" "+goods.getGoodsPrice());
        setGoodsInfo(goods, statement);
        statement.executeUpdate();
        JDBCUtils.close(connection,statement);
    }

    @Override
    public int getGoodsCount() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select count(1) from goods");
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        int count = resultSet.getInt(1);
        System.out.println(count);
        JDBCUtils.close(connection,statement,resultSet);
        return count;
    }

    @Override
    public List<Goods> getGoodsList(int goodsstart, int goodsnum) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from goods limit ?,?");
        statement.setInt(1,goodsstart);
        statement.setInt(2,goodsnum);
        ResultSet resultSet = statement.executeQuery();
        List<Goods> list=new ArrayList<>();
        while (resultSet.next()){
            Goods goods=new Goods();
            getGoodsInfo(resultSet, goods);
            list.add(goods);
        }

        JDBCUtils.close(connection,statement,resultSet);
        return list;
    }

    @Override
    public List<Goods> getGoodsListType(String goodstype) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from goods where goodsType=?");
        statement.setString(1,goodstype);
        ResultSet resultSet = statement.executeQuery();
        List<Goods> listty=new ArrayList<>();
        while (resultSet.next()){
            Goods goods=new Goods();
            getGoodsInfo(resultSet, goods);
            listty.add(goods);
        }
        JDBCUtils.close(connection,statement,resultSet);
        return listty;
    }


    @Override
    public int deleteGoods(int goodsId) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("delete from goods where goodsID=?");
        statement.setInt(1,goodsId);
        int i = statement.executeUpdate();
        JDBCUtils.close(connection,statement);
        return i;
    }


    @Override
    public Goods queryGoods(int goodsid) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from goods where goodsID=?");
        statement.setInt(1,goodsid);
        ResultSet resultSet = statement.executeQuery();
        Goods goods=new Goods();
        while (resultSet.next()){
            getGoodsInfo(resultSet, goods);
        }
        JDBCUtils.close(connection,statement,resultSet);
        return goods;
    }

    @Override
    public int goodsMerchantID(int goodID) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select goodsSellID from goods where goodsID=?");
        statement.setInt(1,goodID);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        int sellid = resultSet.getInt(1);
        //System.out.println(sellid);
        JDBCUtils.close(connection,statement,resultSet);
        return sellid;
    }

    @Override
    public double getGoodsPriceByID(int goodID) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select goodsPrice from goods where goodsID=?");
        statement.setInt(1,goodID);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        double price = resultSet.getDouble(1);
        //System.out.println(price);
        JDBCUtils.close(connection,statement,resultSet);
        return price;
    }

    @Override
    public int updateGoods(Goods goods) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement
                ("update goods set goodsName=?,goodsType=?,goodsPrice=?,goodsStock=?,goodsSellID=?,goodsIntroduce=?,goodsPicurl=? where goodsID=?");
        setGoodsInfo(goods, statement,0);
        statement.setInt(8,goods.getGoodsID());
        int i= statement.executeUpdate();
        JDBCUtils.close(connection,statement);
        return i;
    }

    private void getGoodsInfo(ResultSet resultSet, Goods goods) throws SQLException {
        goods.setGoodsID(resultSet.getInt(1));
        goods.setGoodsName(resultSet.getString(2));
        goods.setGoodsType(resultSet.getString(3));
        goods.setGoodsPrice(resultSet.getDouble(4));
        goods.setGoodsStock(resultSet.getInt(5));
        goods.setGoodsSellID(resultSet.getInt(6));
        goods.setGoodsIntroduce(resultSet.getString(7));
        goods.setGoodsPicUrl(resultSet.getString(8));
    }

    private void setGoodsInfo(Goods goods, PreparedStatement statement) throws SQLException {
        statement.setInt(1,goods.getGoodsID());
        statement.setString(2,goods.getGoodsName());
        statement.setString(3,goods.getGoodsType());
        statement.setDouble(4,goods.getGoodsPrice());
        statement.setInt(5,goods.getGoodsStock());
        statement.setInt(6,goods.getGoodsSellID());
        statement.setString(7,goods.getGoodsIntroduce());
        statement.setString(8,goods.getGoodsPicUrl());
    }
    private void setGoodsInfo(Goods goods, PreparedStatement statement,int not) throws SQLException {
        statement.setString(1,goods.getGoodsName());
        statement.setString(2,goods.getGoodsType());
        statement.setDouble(3,goods.getGoodsPrice());
        statement.setInt(4,goods.getGoodsStock());
        statement.setInt(5,goods.getGoodsSellID());
        statement.setString(6,goods.getGoodsIntroduce());
        statement.setString(7,goods.getGoodsPicUrl());
    }



}
