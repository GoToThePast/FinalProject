package com.tuogen.dao;

import com.tuogen.model.Seller;

import java.sql.SQLException;

public interface SellerDao {
    int addUser(Seller seller) throws SQLException;
    void init() throws SQLException;
}
