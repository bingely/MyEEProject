package com.bingley.ee.topic.session.shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des $des$
 * @since 2017/5/20.
 */

/**
 * 首先写一个prodList.jsp,在那里面链接到指定的servlet
 */
@WebServlet(name = "BuyServlet", value = "/hellobuy")
public class BuyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String prod = request.getParameter("prod");
        prod = new String(prod.getBytes("iso8859-1"),"utf-8");

        HttpSession session = request.getSession();
        Cookie jc = new Cookie("JSESSIONID",session.getId());
        jc.setPath(request.getContextPath());
        jc.setMaxAge(1800);
        response.addCookie(jc);

        session.setAttribute("prod", prod);
    }
}
