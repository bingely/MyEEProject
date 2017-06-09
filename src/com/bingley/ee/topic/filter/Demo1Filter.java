package com.bingley.ee.topic.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des Filter 的快速入门
 * @since 2017/6/6.
 */

/**
 * how to use?
 */
@WebFilter(filterName = "mDemo1Filter")
public class Demo1Filter implements javax.servlet.Filter {
    public void destroy() {
        System.out.println("demo1filter destory");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("demo1filter 前");
        chain.doFilter(req, resp);
        System.out.println("demo1filter 后");
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Demo1Filter初始化了.....");

        // 读取配置init-param信息
        //		String v = filterConfig.getInitParameter("name1");
//		System.out.println(v);

        Enumeration<String> enumeration = filterConfig.getInitParameterNames();
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = filterConfig.getInitParameter(name);
            System.out.println(name+":"+value);
        }
    }

}
