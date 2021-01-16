package com.tuogen.controller;

import com.tuogen.model.Goods;
import com.tuogen.service.GoodsService;
import com.tuogen.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Made By 王炜
 * 根据类型获取商品类型
 * 参数：商品类型 type
 */
@WebServlet("/getGoodsByType")
public class GetGoodsByTypeServlet extends HttpServlet {
    private GoodsService goodsService=new GoodsServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: 2021/1/8 编码待删除
        request.setCharacterEncoding("utf-8");
        String type = request.getParameter("type");
        System.out.println("请求商品类型"+ type);
        // TODO: 2021/1/9 goodsService.getGoodsListType
        List<Goods> goodsList= goodsService.getGoodsListType(type);
        request.setAttribute("goodsList",goodsList);
        // TODO: 2021/1/15 商品列表地址
        // 完成商品列表跳转
//        request.getRequestDispatcher("/view/index.jsp").forward(request,response);
        respGoodsList(request,response,type);

    }

    private void respGoodsList(HttpServletRequest request, HttpServletResponse response, String type) throws IOException {
        switch (type){
            case "装饰摆件":
                response.sendRedirect("view/decoration.jsp");
                break;
            case "布艺软饰":
                response.sendRedirect("view/flowerDer.jsp");
                break;
            case "墙式壁挂":
                response.sendRedirect("view/idea.jsp");
                break;
            case "蜡艺香薰":
                response.sendRedirect("view/paint.jsp");
                break;
            case "创意家居":
                response.sendRedirect("view/perfume.jsp");
                break;
            default:
                response.sendRedirect("view/index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
