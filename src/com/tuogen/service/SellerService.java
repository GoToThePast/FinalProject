package com.tuogen.service;

import com.tuogen.model.Seller;

public interface SellerService {
    public int addUser(Seller seller);
    public Seller loginUseID(int ID, String pwd) ;

}
