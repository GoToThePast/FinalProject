package com.tuogen.dao.impl;

import com.tuogen.dao.BuyerDao;
import com.tuogen.model.Buyer;
import com.tuogen.utils.JDBCUtils;

import java.sql.*;

public class BuyerDaoImpl implements BuyerDao{

    @Override
    public Buyer loginUseID(String name, String pwd) throws SQLException {
        System.out.println(name+"密码"+pwd);
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from `buyer` where `id`=?");
        statement.setString(1,name);
        ResultSet resultSet = statement.executeQuery();
        Buyer buyer=new Buyer();
        while (resultSet.next()){
            buyer=getBuyerInfo(resultSet, buyer);
        }
        JDBCUtils.close(connection,statement,resultSet);
        System.out.println(buyer.getId()+"密码"+buyer.getPassword());
        if(pwd.equals(buyer.getPassword())) {
            return buyer;
        }
        else{
            return null;
        }
    }

    @Override
    public Buyer loginUseEmail(String email, String pwd) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from `buyer` where `email`=?");
        statement.setString(1,email);
        ResultSet resultSet = statement.executeQuery();
        Buyer buyer=new Buyer();
        while (resultSet.next()){
            buyer=getBuyerInfo(resultSet, buyer);
        }
        JDBCUtils.close(connection,statement,resultSet);
        System.out.println(buyer.getId()+"密码"+buyer.getPassword());
        if(pwd.equals(buyer.getPassword())) {
            return buyer;
        }
        else{
            return null;
        }
    }

    @Override
    public Buyer loginUsePhonNum(String phoneNum, String pwd) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from `buyer` where `phoneNumber`=?");
        statement.setString(1,phoneNum);
        ResultSet resultSet = statement.executeQuery();
        Buyer buyer=new Buyer();
        while (resultSet.next()){
            buyer=getBuyerInfo(resultSet, buyer);
        }
        JDBCUtils.close(connection,statement,resultSet);
        System.out.println(buyer.getId()+"密码"+buyer.getPassword());
        if(pwd.equals(buyer.getPassword())){
            return buyer;
        }
        else{
            return null;
        }
    }

    @Override
    public int addUser(Buyer buyer) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert `buyer` values(null,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,buyer.getName());
        statement.setString(2,buyer.getPassword());
        statement.setString(3,buyer.getEmail());
        statement.setString(4,buyer.getPhoneNumber());
        statement.setString(5,buyer.getHomeAddress());
        statement.setString(6,buyer.getPicUrl());
        statement.executeUpdate();
        ResultSet generatedKeys = statement.getGeneratedKeys();
        generatedKeys.next();
        int ID = generatedKeys.getInt(1);
        JDBCUtils.close(connection,statement,generatedKeys);
        return ID;
    }

    private Buyer getBuyerInfo(ResultSet resultSet, Buyer buyer) throws SQLException{
        buyer.setId(resultSet.getLong(1));
        buyer.setName(resultSet.getString(2));
        buyer.setPassword(resultSet.getString(3));
        buyer.setEmail(resultSet.getString(4));
        buyer.setPhoneNumber(resultSet.getString(5));
        buyer.setHomeAddress(resultSet.getString(6));
        buyer.setPicUrl(resultSet.getString(7));
        return buyer;
    }
}
