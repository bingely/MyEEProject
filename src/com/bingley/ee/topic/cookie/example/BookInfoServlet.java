package com.bingley.ee.topic.cookie.example;

import com.bingley.ee.domain.Book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des 点击图书的具体信息
 * @since 2017/5/20.
 */
@WebServlet(name = "BookInfoServlet", value = "/hellobookinfo")
public class BookInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //1.获取要看的书的id,查询数据库找出书,输出书的详细信息
        String id = request.getParameter("id");
        Book book = BookDao.getBook(id);
        if(book==null){
            response.getWriter().write("找不到这本书!");
            return;
        }else{
            response.getWriter().write("<h1>书名:"+book.getName()+"</h1>");
            response.getWriter().write("<h3>作者:"+book.getAuth()+"</h3>");
            response.getWriter().write("<h3>售价:"+book.getPrice()+"</h3>");
            response.getWriter().write("<h3>出版社:"+book.getPublish()+"</h3>");
            response.getWriter().write("<h3>描述信息:"+book.getDescription()+"</h3>");
        }

        //2.发送cookie保存最后看过的书

        // (拼接字符形式）
        // --- 1 --> 1
        // 1 --2,1 --> 2,1
        // 2,1--3,2,1 --> 3,2,1
        // 3,2,1 -- 4,3,2 --> 4,3,2
        // 4,3,2 --3,4,2 --> 3,4,2
        String ids = "";

        Cookie[] cs = request.getCookies();
        Cookie findC = null;
        if(cs!=null){
            for(Cookie c : cs){
                if("last".equals(c.getName())){
                    findC = c;
                }
            }
        }

        if(findC == null){
            //说明之前没有看过书的记录
            ids += book.getId();
        }else{
            //说明之前有历史看过的书的记录,需要根据历史记录算一个新的记录出来
            String [] olds = findC.getValue().split(",");
            StringBuffer buffer = new StringBuffer();
            buffer.append(book.getId()+",");
            for(int i = 0;i<olds.length && buffer.toString().split(",").length<3 ;i++){
                String old = olds[i];
                if(!old.equals(book.getId())){
                    buffer.append(old+",");
                }
            }
            ids = buffer.substring(0, buffer.length()-1);
        }

        Cookie lastC = new Cookie("last",ids);
        lastC.setMaxAge(3600*24*30);
        lastC.setPath(request.getContextPath());
        response.addCookie(lastC);

    }
}
