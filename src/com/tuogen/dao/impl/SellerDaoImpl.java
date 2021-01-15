package com.tuogen.dao.impl;

import com.tuogen.dao.SellerDao;
import com.tuogen.model.Seller;
import com.tuogen.utils.JDBCUtils;

import java.sql.*;

public class SellerDaoImpl implements SellerDao {
    /**
     * 新增用户
     * @param seller
     * @return 返回生成的ID
     * @throws SQLException
     */
    @Override
    public int addUser(Seller seller) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert seller values(null,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,seller.getName());
        statement.setString(2,seller.getPassword());
        statement.setString(3,seller.getType());
        statement.setString(4,seller.getEmail());
        statement.setString(5,seller.getBankCard());
        statement.setString(6,seller.getDeliveryAddr());
        statement.setString(7,seller.getIcon());
        statement.executeUpdate();
        ResultSet generatedKeys = statement.getGeneratedKeys();
        generatedKeys.next();
        int ID = generatedKeys.getInt(1);
        JDBCUtils.close(connection,statement,generatedKeys);
        return ID;
    }

    /**
     * 增加商家登陆逻辑
     * @param id
     * @param pwd
     * @return
     * @throws SQLException
     */
    @Override
    public Seller sellerLoginUseID(int id, String pwd) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from `seller` where `id`=?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        Seller seller=new Seller();
        while (resultSet.next()){
            seller=setSellerInfo(resultSet, seller);
        }
        JDBCUtils.close(connection,statement,resultSet);
        if(pwd.equals(seller.getPassword())){
            return seller;
        }
        else{
            return null;
        }
    }

    /**
     * 生成商家实体类
     * @param resultSet
     * @param seller
     * @throws SQLException
     */
    private Seller setSellerInfo(ResultSet resultSet, Seller seller) throws SQLException {
        seller.setId(resultSet.getInt(1));
        seller.setName(resultSet.getString(2));
        seller.setPassword(resultSet.getString(3));
        seller.setType(resultSet.getString(4));
        seller.setEmail(resultSet.getString(5));
        seller.setBankCard(resultSet.getString(6));
        seller.setDeliveryAddr(resultSet.getString(7));
        seller.setIcon(resultSet.getString(8));
        return seller;
    }
}
