package com.bingley.ee.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des 要理解从零建servlet过程
 * @since 2017/5/18.
 */

@WebServlet(name = "MyFirstServlet")
public class MyFirstServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 这是一种多态思想调用
        response.getWriter().write("now time"+new Date().toLocaleString());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 因为两者的处理逻辑基本相同，所以直接在dopost中调用doget
        doGet(request, response);
    }


}
