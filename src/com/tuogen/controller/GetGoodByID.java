package com.tuogen.controller;

import com.tuogen.model.Goods;
import com.tuogen.service.GoodsService;
import com.tuogen.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @User:Breeze
 * @ClassName: com.tuogen.controller.GetGoodByID
 * @Description: TODO
 * @Author: HLX
 * @date: 2021/1/15 16:52
 * @Version: V1.0
 */
@WebServlet(name = "goodiD",urlPatterns = "/getGoodUseID")
public class GetGoodByID extends HttpServlet {
    GoodsService goodsService=new GoodsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String goodID=req.getParameter("goodID");
        Goods good = goodsService.queryGoods(Integer.parseInt(goodID));
        HttpSession session = req.getSession();
        session.setAttribute("good",good);
//        req.getRequestDispatcher("view/proDetail.jsp").forward(req,resp);
        resp.sendRedirect("view/proDetail.jsp");
    }

}
