package com.bingley.ee.topic.sql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des tomcat内置的数据源(DBCP):
 * @since 2017/6/3.
 */
@WebServlet(name = "DataSourceInitServlet")
public class DataSourceInitServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void init() throws ServletException {
        try {
            Context initCtx = new InitialContext();
            Context jndi = (Context) initCtx.lookup("java:comp/env");
            DataSource source = (DataSource) jndi.lookup("mySource");

            Connection conn = source.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from account");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                System.out.println(name);
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
