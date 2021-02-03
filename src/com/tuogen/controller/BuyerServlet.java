package com.tuogen.controller;

import com.tuogen.model.*;
import com.tuogen.service.BuyerService;
import com.tuogen.service.GoodsService;
import com.tuogen.service.OrderService;
import com.tuogen.service.impl.BuyerServiceImpl;
import com.tuogen.service.impl.GoodsServiceImpl;
import com.tuogen.service.impl.OrderServiceImpl;
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


@WebServlet(name = "BuyerServlet",urlPatterns = "/Buyer/*")
public class BuyerServlet extends BaseServlet {
    BuyerService buyerService=new BuyerServiceImpl();
    OrderService orderService=new OrderServiceImpl();
    private GoodsService goodsService=new GoodsServiceImpl();
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String userAccout=req.getParameter("userName");
        String userPwd=req.getParameter("passWord");
        Buyer buyer=checkIdentity(userAccout,userPwd);

        if(buyer==null){
            System.out.println("登陆失败");
            resp.sendRedirect("../view/login.jsp");
        }else{
            System.out.println("登陆成功");
            Buyer_logInit(req,resp,buyer);
        }
    }

    public void queryOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String buyerID=req.getParameter("buyerID");
        List<OrderQuery> buyerOrderQueryList = orderService.getOrderQueryListByBuyer(Integer.parseInt(buyerID));
        req.getSession().setAttribute("buyerOrderList", buyerOrderQueryList);
        resp.sendRedirect("../view/myorderq.jsp");
    }

    private void Buyer_logInit(HttpServletRequest req, HttpServletResponse resp, Buyer buyer) throws IOException, ServletException {
        HttpSession session = req.getSession();

        //设置session中islong=1
        session.setAttribute("isLogin",1);

        //设置session中的buyer
        session.setAttribute("buyer",buyer);

        //添加OnlineUser session属性
        addOnlineUser(req,resp,buyer);

        //获取用户订单数据
        List<OrderQuery> buyerOrderQueryList = orderService.getOrderQueryListByBuyer((int)buyer.getId());
        session.setAttribute("buyerOrderList", buyerOrderQueryList);

        //获取所有商品
        List<Goods> goodsList1= goodsService.getGoodsListType("装饰摆件");
        session.setAttribute("goodsList1",goodsList1);
        List<Goods> goodsList2= goodsService.getGoodsListType("布艺软饰");
        session.setAttribute("goodsList2",goodsList2);
        List<Goods> goodsList3= goodsService.getGoodsListType("墙式壁挂");
        session.setAttribute("goodsList3",goodsList3);
        List<Goods> goodsList4= goodsService.getGoodsListType("蜡艺香薰");
        System.out.println(goodsList4.size());
        session.setAttribute("goodsList4",goodsList4);
        List<Goods> goodsList5= goodsService.getGoodsListType("创意家居");
        session.setAttribute("goodsList5",goodsList5);

        //返回
        resp.sendRedirect("../view/index.jsp");
//        req.getRequestDispatcher("goodsList").forward(req,resp);
    }

    private void getGoodUseID(HttpServletRequest req, HttpServletResponse resp, Buyer buyer) {
        String goodID=req.getParameter("goodID");
    }


    private void addOnlineUser(HttpServletRequest req, HttpServletResponse resp, Buyer buyer) {
        HttpSession session = req.getSession();
        //获取时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        OnlineUser onlineUser=new OnlineUser(Type.BUYER,buyer,date);
        session.setAttribute("onlineUser",onlineUser);
    }

    private Buyer checkIdentity(String userAccout, String userPwd) {
        Buyer buyer=new Buyer();
        buyer=buyerService.loginUseID(userAccout,userPwd);
        if(buyer!=null) return buyer;
        buyer=buyerService.loginUseEmail(userAccout,userPwd);
        if(buyer!=null) return buyer;
        buyer=buyerService.loginUsePhonNum(userAccout,userPwd);
        return buyer;
    }
}
