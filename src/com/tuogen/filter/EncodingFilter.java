package com.tuogen.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class EncodingFilter implements Filter {
    private String encoding;
    private static final String DEFAULT_CHARSET = "utf-8";
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        //根据请求方式不同设置编码
        if ("GET".equals(request.getMethod())){
            EncodingWrapper wrapper = new EncodingWrapper(request, encoding);
            request.setCharacterEncoding(encoding);
            chain.doFilter(wrapper,resp);
        }else{
            //设置post方式编码
            request.setCharacterEncoding(encoding);
            resp.setContentType("text/html;charset="+encoding);
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
        //获取配置中的编码
        encoding = config.getInitParameter("encoding");
        if(encoding==null||"".equals(encoding))
            encoding=DEFAULT_CHARSET;
    }

}
