package com.bingley.ee.topic.filter;

import java.io.IOException;
import java.util.Map;

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
 * @des $des$
 * @since 2017/6/6.
 */
@WebFilter(filterName = "mEncodingFilter")
public class EncodingFilter implements javax.servlet.Filter {
    private String encode = null;
    private FilterConfig mConfig;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setContentType("text/html;charset=" + encode); //--解决响应乱码
        chain.doFilter(new MyHttpServletRequest((HttpServletRequest) req), resp);
    }

    public void init(FilterConfig config) throws ServletException {
        mConfig = config;
        encode = config.getInitParameter("encode");
    }

    private class MyHttpServletRequest extends ServletRequestWrapper {

        private HttpServletRequest mRequest;

        public MyHttpServletRequest(HttpServletRequest request) {
            super(request);
            mRequest = request;
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            if (mRequest.getMethod().equalsIgnoreCase(""))
            return super.getParameterMap();
            return null;
        }

    }
}
