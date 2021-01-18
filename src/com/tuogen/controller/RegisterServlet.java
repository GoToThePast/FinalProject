package com.tuogen.controller;

import com.tuogen.model.*;
import com.tuogen.service.BuyerService;
import com.tuogen.service.SellerService;
import com.tuogen.service.impl.BuyerServiceImpl;
import com.tuogen.service.impl.SellerServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Made By 王炜
 * 供注册使用Servlet
 */
//@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    public static final String ANSI_RESET ="\u001B[0m";
    public static final String ANSI_RED ="\u001B[31m";
    private static final HashMap<String,Field> BuyerFieldMap=getFieldMap(Buyer.class);
    private static final HashMap<String,Field> SellerFieldMap=getFieldMap(Seller.class);
    private static Constructor BuyerConstructor;
    private static Constructor SellerConstructor;
    private BuyerService buyerService=new BuyerServiceImpl();
    private SellerService sellerService=new SellerServiceImpl();
    @Override
    public void init() throws ServletException {
        //获得买家和卖家model构造方法
        try {
            BuyerConstructor= Buyer.class.getConstructor();
            SellerConstructor=Seller.class.getConstructor();
            sellerService.init();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解析请求，判断注册类型
        String registerType = request.getParameter("registerType");
        int account=-1;
        try{
            if ("Buyer".equals(registerType)){
                //注册用户
                Buyer buyer = (Buyer)getUser(request, BuyerFieldMap, BuyerConstructor);
                // TODO: 2021/1/8 buyerService.addUser
                account = buyerService.addUser(buyer);
            }else if ("Seller".equals(registerType)){
                //注册商家
                Seller seller = (Seller)getUser(request, SellerFieldMap, SellerConstructor);
                account = sellerService.addUser(seller);

            }
        }catch (Exception e){
            System.out.println(ANSI_RED +e.getMessage() + ANSI_RESET);
            //注册失败
            response.sendRedirect("./view/registerFailed.jsp");
        }
        if (account>0){
            request.getSession().setAttribute("account",account);
            response.sendRedirect("./view/registerSuccess.jsp");
        }
    }

    /**
     * 封装属性至map
     * @param _class
     * @return map<key=属性名,value=Filed></>
     */
    public static HashMap<String,Field> getFieldMap(Class _class){
        HashMap<String, Field> map=new HashMap<>();
        try{
            Class sellerExtendClass = _class;
            Field[] fields = sellerExtendClass.getDeclaredFields();
            for (Field field : fields){
                field.setAccessible(true);
                map.put(field.getName(),field);
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return map;
    }

    /**
     * 将请求体封装为User
     * @param request
     * @param map
     * @param constructor
     * @return 返回User
     */
    public static User getUser(HttpServletRequest request, HashMap<String, Field> map, Constructor constructor ) throws ParametersMismatchException {
        Object user;
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try{
            List<FileItem> items = upload.parseRequest(request);
            if (items.isEmpty()){
                return null;
            }
            user= constructor.newInstance();
            Iterator<FileItem> iterator = items.iterator();
            while (iterator.hasNext()){
                FileItem item = iterator.next();
                if (item.isFormField()){
                    //表单字段
                    String value = new String(item.getString().getBytes("iso-8859-1"), "utf-8");
                    String fieldName = item.getFieldName();
                    //设置属性
                    map.get(fieldName).set(user,value);
                }
                else {
                    //媒体
                    if (!"".equals(item.getName())){
                        String photoPath=request.getServletContext().getRealPath("/image/");
                        //加上系统毫秒数，防止文件重名
                        String name = System.currentTimeMillis()+item.getName().substring(item.getName().lastIndexOf("."));
                        System.out.println("name="+name);
                        System.out.println(photoPath + name);
                        File file = new File(photoPath + name);
                        item.write(file);
                        map.get(item.getFieldName()).set(user,"image/"+name);
                    }
                }
            }
        } catch (Exception e) {
            throw new ParametersMismatchException("模型与表单参数不一致!");
        }
        return (User)user;
    }
}

class ParametersMismatchException extends Exception{
    public ParametersMismatchException(String msg) {
        super(msg);
    }
}
