package com.tuogen.dao.impl;


import com.tuogen.dao.OrderDao;
import com.tuogen.model.Goods;
import com.tuogen.model.Order;
import com.tuogen.model.OrderQuery;
import com.tuogen.service.GoodsService;
import com.tuogen.service.impl.GoodsServiceImpl;
import com.tuogen.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class OrderDaoImpl implements OrderDao {
    GoodsService goodsService=new GoodsServiceImpl();

    @Override
    public void addOrder(Order order) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement =JDBCUtils.getConnection().prepareStatement("insert into `order` values(?,?,?,?,?,?,?)");
        setOrderInfo(order, statement);
        statement.executeUpdate();
        JDBCUtils.close(connection,statement);
    }

    @Override
    public List<Order> getOrderList(int start, int num) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from `order` limit ?,?");
        statement.setInt(1,start);
        statement.setInt(2,num);
        ResultSet resultSet = statement.executeQuery();
        List<Order> list=new ArrayList<>();
        while (resultSet.next()){
            Order order=new Order();
            getOrderInfo(resultSet, order);
            list.add(order);
        }
        JDBCUtils.close(connection,statement,resultSet);
        return list;
    }

    @Override
    public List<Order> getOrderListByBuyerID(int buyerID) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from `order` where orderUserNum=?");
        statement.setInt(1,buyerID);
        ResultSet resultSet = statement.executeQuery();
        List<Order> list=new ArrayList<>();
        while (resultSet.next()){
            Order order=new Order();
            getOrderInfo(resultSet, order);
            list.add(order);
        }
        JDBCUtils.close(connection,statement,resultSet);
        return list;
    }

    @Override
    public List<Order> getOrderListByMerchantID(int merchantID) throws SQLException {
        List<Order> orders=new ArrayList<>();
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from `order` where merchantID=?");
        statement.setInt(1,merchantID);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            Order order=new Order();
            getOrderInfo(resultSet, order);
            orders.add(order);
        }
        JDBCUtils.close(connection,statement,resultSet);
        return orders;
    }

    @Override
    public List<OrderQuery> getOrderQueryListMer(int merchantID) throws SQLException {
        List<OrderQuery> orderList=new ArrayList<>();
        List<Order> orders=this.getOrderListByMerchantID(merchantID);
        for(Order order:orders){
            OrderQuery orderQuery = new OrderQuery();
            Vector<Integer> goodIDs=this.getGoodList(order.getGoodsListId());
            Vector<Goods> goods=new Vector<>();
            for(Integer i:goodIDs){
                Goods good=goodsService.queryGoods(i);
                goods.add(good);
            }
            orderQuery.setOrder(order);
            orderQuery.setGoodsId(goodIDs);
            orderQuery.setGoods(goods);
            orderList.add(orderQuery);
        }
        return orderList;
    }

    @Override
    public Order creatOder(int userID, List<Integer> goodsID) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        Order order=new Order();
        long orderNum=System.currentTimeMillis();

        //orderID
        order.setOrderNum(orderNum);

        //BuyerID
        order.setOrderUserNum(userID);

        //orderStatus
        order.setOrderStatus("未付款");

        //goodListId

        HashMap<Integer, List<Integer>> merchantMap = getMerMap(goodsID);

//        order.setGoodsListId((int)orderNum);
//        //添加GoodsList
//
//        //

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        simpleDateFormat.setLenient(false);
//        Date timeDate = null;//util类型
//        try {
//            timeDate = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        java.sql.Timestamp dateTime = new java.sql.Timestamp(timeDate.getTime());//Timestamp类型,timeDate.getTime()返回一个long型
//        order.setCreaterTime(dateTime);
//        order.setMerchantId();
//        PreparedStatement statement = connection.prepareStatement("select prodectNum from `goodsList` where goodsListID=?");
//        JDBCUtils.close(connection,statement,resultSet);
        return order;
    }

    private HashMap<Integer, List<Integer>> getMerMap(List<Integer> goodsID) {
        HashMap<Integer, List<Integer>> merchantMap=new HashMap<>();
        int[] goodIDs=new int[goodsID.size()];       //goodIDs
        for(int i=0;i<goodsID.size();i++){

            int merID=goodsService.goodsMerchantID(goodIDs[i]);

            if(merchantMap.containsKey(merID)){
                merchantMap.get(merID).add(goodIDs[i]);
            }else{
                List<Integer> ls=new ArrayList<>();
                ls.add(goodIDs[i]);
                merchantMap.put(merID,ls);
            }
        }
        return merchantMap;
    }


    public Vector<Integer> getGoodList(int goodListId) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select prodectNum from `goodsList` where goodsListID=?");
        statement.setInt(1,goodListId);
        ResultSet resultSet = statement.executeQuery();
        Vector<Integer> goodIDs=new Vector<>();
        while(resultSet.next()){
            goodIDs.add(resultSet.getInt(1));
        }
        JDBCUtils.close(connection,statement,resultSet);
        return goodIDs;
    }

    @Override
    public List<Order> getOrderList() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from `order`");
        ResultSet resultSet = statement.executeQuery();
        List<Order> list=new ArrayList<>();
        while (resultSet.next()){
            Order order=new Order();
            getOrderInfo(resultSet, order);
            list.add(order);
        }
        JDBCUtils.close(connection,statement,resultSet);
        return list;
    }

    @Override
    public boolean deleteOrder(long orderNum) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("delete from `order` where orderNum=?");
        statement.setLong(1,orderNum);
        int i = statement.executeUpdate();
        JDBCUtils.close(connection,statement);
        return i==1?true:false;
    }

    @Override
    public Order queryUser(Long orderNum) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from `order` where userID=?");
        statement.setLong(1,orderNum);
        ResultSet resultSet = statement.executeQuery();
        Order order=new Order();
        while (resultSet.next()){
            getOrderInfo(resultSet, order);
        }
        JDBCUtils.close(connection,statement,resultSet);
        return order;
    }

    @Override
    public boolean updateUser(Order order) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "update `order` set orderNum=?,orderUserNum=?,goodsListID=?,orderStatus=?,createrTime=?,merchantID=?, totalPrice=?" +
                        "  where orderNum=?");
        setOrderInfo(order, statement);
        statement.setLong(7,order.getOrderNum());
        int i= statement.executeUpdate();
        JDBCUtils.close(connection,statement);
        return i==1?true:false;
    }

    private void getOrderInfo(ResultSet resultSet, Order order) throws SQLException{
        order.setOrderNum(resultSet.getLong(1));
        order.setOrderUserNum(resultSet.getInt(2));
        order.setGoodsListId(resultSet.getInt(3));
        order.setOrderStatus(resultSet.getString(4));
        order.setCreaterTime(resultSet.getTimestamp(5));
        order.setMerchantId(resultSet.getInt(6));
        order.setTotalPrice(resultSet.getDouble(7));
    }

    private void setOrderInfo(Order order, PreparedStatement statement) throws SQLException{
        statement.setLong(1,order.getOrderNum());
        statement.setInt(2,order.getOrderUserNum());
        statement.setInt(3,order.getGoodsListId());
        statement.setString(4,order.getOrderStatus());
        statement.setTimestamp(5,order.getCreaterTime());
        statement.setInt(6,order.getMerchantId());
        statement.setDouble(7,order.getTotalPrice());
    }
}
