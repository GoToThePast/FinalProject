package com.tuogen.service;

import com.tuogen.model.Buyer;

public interface BuyerService {
    public Buyer loginUseID(String name, String pwd) ;
    public Buyer loginUseEmail(String email,String pwd) ;
    public Buyer loginUsePhonNum(String phoneNum,String pwd) ;
    public int addUser(Buyer buyer);
}
