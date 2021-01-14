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
}
