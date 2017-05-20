package com.bingley.ee.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des $des$
 * @since 2017/5/20.
 */

/**
 * 第一就是servlet（写html代码不方便） 如何与jsp(可以嵌套Java代码）进行关联呢？----通过代码指定具体的jsp页面
 * jsp 又如何拿到servlet里面的数据
 */
@WebServlet(name = "JspServlet")
public class JspServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
