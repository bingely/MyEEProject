package com.bingley.ee.topic.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des cookie快速入门
 * @since 2017/5/20.
 */
// http 相关信息可以在fiddler中去查询

@WebServlet(name = "CookieServlet", value = "/helloCookie")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 一句解决乱码问题
        response.setContentType("text/html;charset=utf-8");

        // request 里面可以获取服务器给他的cookie
        Cookie[] cs = request.getCookies();
        Cookie findC = null;
        if (cs != null) {     // 也要判断是否非空，不然会有空针异常
            for (Cookie c : cs) {
                if ("lastTime".equals(c.getName())) {
                    findC = c;
                }
            }
        }
        if (findC == null) {
            response.getWriter().write("您是第一次访问本网站!");
        } else {
            Long lastTime = Long.parseLong(findC.getValue());
            response.getWriter().write("您上次访问时间是:" + new Date(lastTime).toLocaleString());
        }


        Date date = new Date();
        Cookie cookie = new Cookie("lastTimeShow", date.getTime() + "");
        // 会将这个Cookie信息以文件的形式保存在浏览器的临时文件夹中,保存到指定的时间到来位置
        cookie.setMaxAge(3600*24*30);
        // 用来通知浏览器在访问服务器中的哪个路径及其子路径时带着当前cookie信息过来;如果不明确设置,则默认的路径是发送Cookie的Servlet所在的路径
        cookie.setPath(request.getContextPath());
        // 现代的浏览器一旦发现cookie设置过domain信息则会拒绝接受这个Cookie.
        //c.setDomain(".baidu.com");
        response.addCookie(cookie);
    }
}
