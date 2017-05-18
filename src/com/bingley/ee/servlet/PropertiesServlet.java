package com.bingley.ee.servlet;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des ServletContext读取资源文件
 * @since 2017/5/18.
 */
@WebServlet(name = "PropertiesServlet",value = "/helloProperties")
public class PropertiesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 如果我把配置放在src目录下，如何读取


        //
        Properties prop = new Properties();
        prop.load(new FileReader(this.getServletContext().getRealPath("WEB-INF/config.properties")));

        System.out.println(prop.getProperty("username"));
        System.out.println(prop.getProperty("password"));

    }
}
