package com.tuogen.service;

import com.tuogen.model.Seller;

public interface SellerService {
    int addUser(Seller seller);
    public Seller loginUseID(int ID, String pwd) ;
    void init();
}
