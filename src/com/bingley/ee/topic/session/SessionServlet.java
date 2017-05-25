package com.bingley.ee.topic.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des
 *  当程序第一次调用到request.getSession()方法时说明客户端明确的需要用到session此时创建出对应客户端的Session对象.
    当session超过30分钟(这个时间是可以在web.xml文件中进行修改的)没有人使用则认为session超时销毁这个session.
    程序中明确的调用session.invalidate()方法可以立即杀死session.
    当服务器被非正常关闭时,随着虚拟机的死亡而死亡.
 *  如果服务器是正常关闭,还未超时的session会被以文件的形式保存在服务器的work目录下,这个过程叫做session的钝化.下次再正常启动服务器时,钝化着的session会被恢复到内存中,这个过程叫做session的活化.
 * @since 2017/5/20.
 */

// 只不过在chrome以及在tomacat中貌似找不到  TODO
@WebServlet(name = "SessionServlet", value = "/hellosession")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("name", "bingley");
    }
}
