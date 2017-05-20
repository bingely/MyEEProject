package com.bingley.ee.cookie.example;

import com.bingley.ee.domain.Book;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des 图书列表
 * @since 2017/5/20.
 */
@WebServlet(name = "BookListServlet", value = "/hellobooklist")
public class BookListServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        // 1.查询数据库中所有的书展示
        Map<String, Book> books = BookDao.getBooks();
        for (Map.Entry<String, Book> bookEntry : books.entrySet()) {
            Book book = bookEntry.getValue();
            response.getWriter().write("<a href='" + request.getContextPath() + "/hellobookinfo?id=" + book.getId() + "'>" + book.getName() + "</a><br>");
        }
        response.getWriter().write("<hr>");

        //2.显示之前看过的书
        Cookie [] cs = request.getCookies();
        Cookie findC = null;
        if(cs!=null){
            for(Cookie c : cs){
                if("last".equals(c.getName())){
                    findC = c;
                }
            }
        }
        if(findC == null){
            response.getWriter().write("没有看过任何书!");
        }else{
            response.getWriter().write("您曾经浏览过的书:<br>");
            String[] ids = findC.getValue().split(",");
            for(String id : ids){
                Book book = BookDao.getBook(id);
                response.getWriter().write(book.getName()+"<br>");
            }
        }
    }
}
