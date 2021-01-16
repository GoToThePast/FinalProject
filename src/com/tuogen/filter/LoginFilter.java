package com.tuogen.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        chain.doFilter(req,resp);
//        String requestURI = request.getRequestURI();
//        //放行资源文件
//        if (requestURI.contains("/css/")||requestURI.contains("/js/")
//                ||requestURI.contains("/image/")||requestURI.contains("/photo/")
//                ||requestURI.contains("/validCode")){
//            chain.doFilter(req,resp);
//            return;
//        }
//        //判断相关资源请求
//        if (requestURI.contains("/register")||requestURI.contains("/login")) {
//            //登录或注册，放行
//            chain.doFilter(req,resp);
//        }else{
//            //验证用户是否登录
//            if (request.getSession().getAttribute("onlineUser")!=null){
//                //已经登录,放行
//                chain.doFilter(req,resp);
//            }else{
//                //请求转发至登录界面
//                // TODO: 2021/1/15 登陆界面路径
//                request.getRequestDispatcher("/view/login.jsp").forward(req, resp);
//            }
//        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
