package com.bingley.ee.topic.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des response解决乱码
 * @since 2017/5/18.
 */
@WebServlet(name = "ResponseServlet",value = "/helloResponse")
public class ResponseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       // ********第一种方式
        // 通过指定头部信息
   /*     response.setHeader("Content-Type","text/html;charset=utf-8");
        // 通过utf-8输出就乱码了
        response.getOutputStream().write("中国".getBytes("utf-8"));*/

        // **** 第二种方式
        //response.setCharacterEncoding("utf-8");
        //response.setHeader("Content-Type", "text/html;charset=utf-8");
        response.setContentType("text/html;charset=utf-8");  // --这一行代码可以解决，其余可以不写
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("中国人民");

        // 如何写入多行呢？？？？
        response.getOutputStream().write("中国".getBytes("utf-8"));

    }
}
