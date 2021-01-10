package com.tuogen.listener;

import com.tuogen.model.OnlineUser;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.ArrayList;

@WebListener()
public class OnlineUserListener implements HttpSessionAttributeListener {
    ArrayList<OnlineUser> onlineUserList;
    public OnlineUserListener() {
    }
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        if (onlineUserList==null){
            ServletContext servletContext = sbe.getSession().getServletContext();
            onlineUserList=new ArrayList<>();
            servletContext.setAttribute("onlineUserList",onlineUserList);
        }
        //监听到添加user属性 表明有用户登录
        if ("onlineUser".equals(sbe.getName())){
            //并添加至域对象
            onlineUserList.add((OnlineUser)sbe.getValue());
        }
    }
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        //监听到用户注销，删除该对象
        if ("onlineUser".equals(sbe.getName())){
            onlineUserList.remove(sbe.getValue());
        }
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attribute
         is replaced in a session.
      */
    }


}
