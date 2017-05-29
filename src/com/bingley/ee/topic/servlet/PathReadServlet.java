package com.bingley.ee.topic.servlet;

import com.bingley.ee.service.ServiceReadPath;

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

/**
 * 相比myeclips
 * 1比较好奇的一件事，它部署的项目没有直接显示到tomcat目录下
 * 2新建一个web项目需要设置那么多的位置
 */
@WebServlet(name = "PathReadServlet", value = "/helloProperties")
public class PathReadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 如果我把配置放在src目录下，如何读取

        //
        Properties prop = new Properties();

        // 一 通过 getServletContext().getRealPath("/xx")
      /*  prop.load(new FileReader(this.getServletContext().getRealPath("/config.properties")));
        response.getWriter().write(prop.getProperty("username") + "<br/>" + prop.getProperty("password"));
        System.out.println(prop.getProperty("username"));
        System.out.println(prop.getProperty("password"));
*/
        // 2 类加载器
        ServiceReadPath service = new ServiceReadPath();
        service.methdo1();



    }
}
