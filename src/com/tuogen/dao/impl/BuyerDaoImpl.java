package com.tuogen.dao.impl;

import com.tuogen.dao.BuyerDao;
import com.tuogen.model.Buyer;
import com.tuogen.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuyerDaoImpl implements BuyerDao{

    @Override
    public Buyer loginUseName(String name, String pwd) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from `buyer` where `name`=?");
        statement.setString(1,name);
        ResultSet resultSet = statement.executeQuery();
        Buyer buyer=new Buyer();
        while (resultSet.next()){
            getBuyerInfo(resultSet, buyer);
        }
        JDBCUtils.close(connection,statement,resultSet);
        if(pwd.equals(buyer.getPwd())) {
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
            getBuyerInfo(resultSet, buyer);
        }
        JDBCUtils.close(connection,statement,resultSet);
        if(pwd.equals(buyer.getPwd())) {
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
            getBuyerInfo(resultSet, buyer);
        }
        JDBCUtils.close(connection,statement,resultSet);
        System.out.println(buyer.toString());
        System.out.println(buyer.getPwd());
        if(pwd.equals(buyer.getPwd())){
            return buyer;
        }
        else{
            return null;
        }
    }

    @Override
    public int addUser(Buyer buyer) {
        return 0;
    }

    private void getBuyerInfo(ResultSet resultSet, Buyer buyer) throws SQLException{
        buyer.setId(resultSet.getLong(1));
        buyer.setName(resultSet.getString(2));
        buyer.setPicUrl(resultSet.getString(3));
        buyer.setPwd(resultSet.getString(4));
        buyer.setEmail(resultSet.getString(5));
        buyer.setHomeAddress(resultSet.getString(6));
        buyer.setPhoneNum(resultSet.getString(7));
    }
}
