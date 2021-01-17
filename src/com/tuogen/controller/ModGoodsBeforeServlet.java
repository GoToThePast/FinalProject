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

@WebServlet(name = "ModGoodsBeforeServlet",urlPatterns = "/gmodPer")
public class ModGoodsBeforeServlet extends HttpServlet {
    GoodsService goodsService=new GoodsServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int goodsId = Integer.parseInt(request.getParameter("goodsId"));
        if (goodsId < 0) return;
        HttpSession session = request.getSession();
        if (session.getAttribute("updateStatus") != null) {
            session.removeAttribute("updateStatus");
            request.setAttribute("updateStatus", 1);
        }
        Goods goods = goodsService.queryGoods(goodsId);
        request.setAttribute("goods", goods);
        request.getRequestDispatcher("../view/mod_goods.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
