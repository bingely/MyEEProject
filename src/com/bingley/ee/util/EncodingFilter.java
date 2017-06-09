package com.bingley.ee.util;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des 应用一：统一全站字符编码过滤器(装饰设计模式）
 * @since 2017/6/6.
 */
@WebFilter(filterName = "mEncodingFilter")
public class EncodingFilter implements Filter {
    private String encode = null;
    private FilterConfig mConfig;



    public void init(FilterConfig config) throws ServletException {
        mConfig = config;
        encode = config.getInitParameter("encode") == null ? "utf-8"
                : config.getInitParameter("encode");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        response.setContentType("text/html;charset="+encode); //--解决响应乱码
        chain.doFilter(new MyHttpServletRequest((HttpServletRequest) request), response);//--包装改造request中和获取请求参数相关的方法解决请求参数乱码
    }

    public void destroy() {
    }

    /**
     * 思路很重要！！！
     */
    private class MyHttpServletRequest extends ServletRequestWrapper {
        private HttpServletRequest request;
        private boolean isNotEncode = true;

        public MyHttpServletRequest(HttpServletRequest request) {
            super(request);
            this.request = request;
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            try{
                if(request.getMethod().equalsIgnoreCase("POST")){//--如果是post提交,一行代码解决post提交请求参数乱码
                    request.setCharacterEncoding(encode);
                    return request.getParameterMap();
                }else if(request.getMethod().equalsIgnoreCase("GET")){//--如果是get提交,则应该手动编解码解决乱码
                    Map<String,String[]> map = request.getParameterMap();//获取有乱码的map
                    if(isNotEncode){//只能在第一次解决乱码
                        for(Map.Entry<String, String[]> entry : map.entrySet()){//遍历map,解决所有值的乱码
                            String [] vs = entry.getValue();
                            for(int i=0;i<vs.length;i++){
                                vs[i] = new String(vs[i].getBytes("iso8859-1"),encode);
                            }
                        }
                        isNotEncode = false;//设置为false,第二次就不会再进这个代码块了
                    }
                    return map;
                }else{
                    return request.getParameterMap();
                }
            }catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        @Override
        public String[] getParameterValues(String name) {
            return (String[]) getParameterMap().get(name);
        }

        @Override
        public String getParameter(String name) {
            return getParameterValues(name) == null ? null : getParameterValues(name)[0];
        }

    }
}
