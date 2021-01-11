package com.tuogen.controller;

import com.tuogen.model.OrderQuery;
import com.tuogen.model.Seller;
import com.tuogen.service.OrderService;
import com.tuogen.service.SellerService;
import com.tuogen.service.impl.OrderServiceImpl;
import com.tuogen.service.impl.SellerServiceImpl;
import com.tuogen.utils.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "MerServlet",urlPatterns = "/Mer/*")
public class MerServlet extends BaseServlet {
    SellerService sellerService=new SellerServiceImpl();
    OrderService orderService=new OrderServiceImpl();
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String userAccout=req.getParameter("userName");
        String userPwd=req.getParameter("passWord");
        Seller seller=checkIdentity(userAccout,userPwd);
        if(seller==null){
            System.out.println("登陆失败");
        }else{
            System.out.println("登陆成功");
            List<OrderQuery> orderQueryList = orderService.getOrderQueryList(seller.getId());
            System.out.println(orderQueryList.toString());
            HttpSession session = req.getSession();
            session.setAttribute("orderList",orderQueryList);
        }
        resp.sendRedirect("/web/manage/index.jsp");
    }

    private Seller checkIdentity(String userAccout, String userPwd) {
        Seller seller=new Seller();
        seller= sellerService.loginUseID(Integer.parseInt(userAccout),userPwd);
        return seller;
    }
}
