package com.bingley.ee.response;

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
 * @des 定时刷新页面
 * @since 2017/5/19.
 */
@WebServlet(name = "RefreshServlet", value = "/helloRefresh")
public class RefreshServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*response.getWriter().print(new Date().toLocaleString());
        response.setHeader("Refresh", "1");*/

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("恭喜你注册成功，3s后跳转主页");
        response.setHeader("Refresh","3;url = index.jsp");

        // 实际应用中更多是从一个html,重定向到另外一个页面
    }
}
