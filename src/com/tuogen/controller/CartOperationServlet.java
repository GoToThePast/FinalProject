package com.tuogen.controller;

import com.tuogen.model.Goods;
import com.tuogen.service.GoodsService;
import com.tuogen.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Made By 王炜
 * 购物车
 * 功能：添加商品、删除商品
 * 两个参数 type goodsID
 * type为 add 则添加商品
 * type为 remove 则删除商品
 * 将购物车中的信息封装成 ArrayList<Googs> cart 保存至session
 * 查看购物车只需使用session中的cart即可
 */
@WebServlet("/addToCart")
public class CartOperationServlet extends HttpServlet {
    private GoodsService goodsService=new GoodsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //商品编号
        String goodsID="goodsID";
        //类型
        String type="type";
        HttpSession session = request.getSession();
        ArrayList<Goods> cart = (ArrayList<Goods>) session.getAttribute("cart");
        if(cart==null){
            cart=new ArrayList<Goods>();
            session.setAttribute("cart",cart);
        }
        String action = request.getParameter(type);
        Goods googs=null;
        // TODO: 2021/1/7 根据商品ID获取商品
        googs=goodsService.getGoods(Integer.parseInt(request.getParameter(goodsID)));
        if ("add".equals(action)){
            //添加商品至购物车
            cart.add(googs);
            //设置session存活时长
            session.setMaxInactiveInterval(60*60*2);
            //设置cookie存活时间
            Cookie cookie=new Cookie("JSESSIONID",session.getId());
            cookie.setMaxAge(60*60*2);
            response.addCookie(cookie);
        }else if ("remove".equals(action)){
            //移除购物车中商品
            cart.remove(googs);
        }
    }
}
