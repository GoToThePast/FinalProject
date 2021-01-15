package com.tuogen.filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
public class EncodingWrapper extends HttpServletRequestWrapper {
    private HttpServletRequest request;
    private String encoding;
    public EncodingWrapper(HttpServletRequest request,String encoding) {
        super(request);
        this.request=request;
        this.encoding=encoding;
    }

    @Override
    public String getParameter(String name) {
        String value = request.getParameter(name);
        if (value!=null){
            try {
                value = new String(value.getBytes("iso8859-1"), encoding);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return value;
    }
}
