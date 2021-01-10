package com.tuogen.dao;

import com.tuogen.model.Buyer;

import java.sql.SQLException;

public interface BuyerDao {
    public Buyer loginUseName(String name, String pwd) throws SQLException;
    public Buyer loginUseEmail(String email,String pwd) throws SQLException;
    public Buyer loginUsePhonNum(String phoneNum,String pwd) throws SQLException;
    public int addUser(Buyer buyer);
}
