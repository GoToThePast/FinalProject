package com.tuogen.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //获取方法
            Method method=this.getMethod(req.getRequestURI());
            if(method==null){
                //获取方法失败
            }else{
                //执行方法
                method.invoke(this, req, resp);
            }
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * getMethod for servlet
     * @param uri
     * @return
     */
    public Method getMethod(String uri){
        String methodName=uri.substring(uri.lastIndexOf('/')+1);
        try {
            return this.getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Method getMethod(){
        //other
        return null;
    }
}
