package com.bingley.ee.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des 获取在web.xml中的配置信息
 * @since 2017/5/18.
 */
/*
*
*        String getServletName()  -- 获取当前Servlet在web.xml中配置的名字
         String getInitParameter(String name) -- 获取当前Servlet指定名称的初始化参数的值
         Enumeration getInitParameterNames()  -- 获取当前Servlet所有初始化参数的名字组成的枚举
         ServletContext getServletContext()  -- 获取代表当前web应用的ServletContext对象
* */

// 这个是直接通过webservlet来创建的
@WebServlet(name = "WebXmlServlet", urlPatterns = "/testwebxml", initParams = {
        @WebInitParam(name = "default_market", value = "NASDAQ"),
        @WebInitParam(name = "user_market", value = "userNASDAQ")
})
public class WebXmlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String default_market= getInitParameter("default_market");
        String user_market=    getInitParameter("user_market");
        // 向网页输出文字
        response.getWriter().print("doPost:user_marketee:"+user_market+" or default_market:"+default_market);


        // 为什么得不到结果？？？？
        ServletContext context = this.getServletContext();
        Enumeration enumeration = context.getInitParameterNames();
        while(enumeration.hasMoreElements()){
            String name = (String) enumeration.nextElement();
            String value = context.getInitParameter(name);
            System.out.println(name+":"+value);
            response.getWriter().print("hhh"+name+":"+value);
        }

    }
}
