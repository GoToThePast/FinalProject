package com.tuogen.controller;

import com.tuogen.model.*;
import com.tuogen.service.GoodsService;
import com.tuogen.service.OrderService;
import com.tuogen.service.SellerService;
import com.tuogen.service.impl.GoodsServiceImpl;
import com.tuogen.service.impl.OrderServiceImpl;
import com.tuogen.service.impl.SellerServiceImpl;
import com.tuogen.utils.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@WebServlet(name = "MerServlet", urlPatterns = "/Mer/*")
public class MerServlet extends BaseServlet {
    SellerService sellerService = new SellerServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    GoodsService goodsService = new GoodsServiceImpl();
    private static final int count = 4;

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String userAccout = req.getParameter("userName");
        String userPwd = req.getParameter("passWord");
        Seller seller = checkIdentity(userAccout, userPwd);
        HttpSession session = req.getSession();
        if (seller == null) {
            System.out.println("登陆失败");
        } else {
            System.out.println("登陆成功");
            login_init(seller.getId(), session, req, seller);
        }
        addOnlineUser(req,resp,seller);
        resp.sendRedirect("/web/manage/index.jsp");
    }

    public void login_init(int merID, HttpSession session, HttpServletRequest request ,Seller seller) {
        //查询用户相关订单
        List<OrderQuery> orderQueryList = orderService.getOrderQueryList(merID);
        session.setAttribute("orderList", orderQueryList);
        //查询用户相关商品
        String pageIndexStr = request.getParameter("pageIndex");
        if (pageIndexStr == null || pageIndexStr == "")
            pageIndexStr = "1";
        int pageIndex = Integer.parseInt(pageIndexStr);
        pageIndex = pageIndex <= 0 ? 1 : pageIndex;
        int goodsCount = goodsService.getGoodsCount();
        int pageNum = goodsCount / count + (goodsCount % count == 0 ? 0 : 1);
        request.setAttribute("pageCount", pageNum);
        if (pageIndex > pageNum) {
            pageIndex = pageNum;
        } else if (pageIndex <= 0) {
            pageIndex = 1;
        }
        List<Goods> goodsList = goodsService.getGoodsList((pageIndex - 1) * count, count, merID);

        session.setAttribute("pageIndex", pageIndex);
        session.setAttribute("goodsList", goodsList);
    }

    private void addOnlineUser(HttpServletRequest req, HttpServletResponse resp, Seller seller) {
        HttpSession session = req.getSession();
        //获取时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        OnlineUser onlineUser=new OnlineUser(Type.SELLER,seller,date);
        session.setAttribute("onlineUser",onlineUser);
    }

    private Seller checkIdentity(String userAccout, String userPwd) {
        Seller seller = new Seller();
        seller = sellerService.loginUseID(Integer.parseInt(userAccout), userPwd);
        return seller;
    }
}
