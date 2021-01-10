package com.tuogen.controller;

import com.tuogen.model.Buyer;
import com.tuogen.service.BuyerService;
import com.tuogen.service.impl.BuyerServiceImpl;
import com.tuogen.utils.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "BuyerServlet",urlPatterns = "/Buyer/*")
public class BuyerServlet extends BaseServlet {
    BuyerService buyerService=new BuyerServiceImpl();

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String userAccout=req.getParameter("userName");
        String userPwd=req.getParameter("passWord");
        System.out.println(userAccout+" "+userPwd);
        Buyer buyer=checkIdentity(userAccout,userPwd);
        if(buyer==null){
            System.out.println("登陆失败");
        }else{
            System.out.println(buyer.toString() );
            System.out.println("登陆成功");
        }
    }

    private Buyer checkIdentity(String userAccout, String userPwd) {
        Buyer buyer=new Buyer();
        buyer=buyerService.loginUseName(userAccout,userPwd);
        if(buyer!=null) return buyer;
        buyer=buyerService.loginUseEmail(userAccout,userPwd);
        if(buyer!=null) return buyer;
        buyer=buyerService.loginUsePhonNum(userAccout,userPwd);
        return buyer;
    }
}
