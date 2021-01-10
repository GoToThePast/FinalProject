package com.tuogen.service.impl;

import com.tuogen.dao.BuyerDao;
import com.tuogen.dao.impl.BuyerDaoImpl;
import com.tuogen.model.Buyer;
import com.tuogen.service.BuyerService;

import java.sql.SQLException;

public class BuyerServiceImpl implements BuyerService {
    BuyerDao buyerDao=new BuyerDaoImpl();

    @Override
    public Buyer loginUseName(String name, String pwd) {
        Buyer buyer=new Buyer();
        try {
            buyer= buyerDao.loginUseName(name,pwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return buyer;
    }

    @Override
    public Buyer loginUseEmail(String email, String pwd) {
        Buyer buyer=new Buyer();
        try {
            buyer= buyerDao.loginUseEmail(email,pwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return buyer;
    }

    @Override
    public Buyer loginUsePhonNum(String phoneNum, String pwd) {
        Buyer buyer=new Buyer();
        try {
            buyer= buyerDao.loginUsePhonNum(phoneNum,pwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return buyer;
    }

    @Override
    public int addUser(Buyer buyer) {
        return -1;
    }
}
