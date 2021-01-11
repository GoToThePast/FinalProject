package com.tuogen.service.impl;

import com.tuogen.dao.SellerDao;
import com.tuogen.dao.impl.SellerDaoImpl;
import com.tuogen.model.Seller;
import com.tuogen.service.SellerService;

import java.sql.SQLException;

public class SellerServiceImpl implements SellerService {
    private SellerDao sellerDao=  new SellerDaoImpl();
    @Override
    public int addUser(Seller seller) {
        int id;
        try {
            id = sellerDao.addUser(seller);
        } catch (SQLException throwables) {
            System.out.println("添加商家用户出错");
            return -1;
        }
        return id;
    }

    @Override
    public Seller loginUseID(int ID, String pwd) {
        Seller seller=null;
        try {
            seller = sellerDao.sellerLoginUseID(ID,pwd);
        } catch (SQLException throwables) {
            System.out.println("添加商家用户出错");
        }
        return seller;
    }
}
