package com.bingley.ee.topic.sql.pool;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

/**
 * 通过动态代理的方式，手写连接池:（是为学习开源连接池原理）
 */
public class MyPool implements DataSource {
    private static List<Connection> pool = new LinkedList<Connection>();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            for (int i = 0; i < 5; i++) {
                Connection conn = DriverManager.getConnection("jdbc:mysql:///jdbc", "root", "root");
                pool.add(conn);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() throws SQLException {
        if (pool.size() == 0) {
            for (int i = 0; i < 3; i++) {
                Connection conn = DriverManager.getConnection("jdbc:mysql:///jdbc", "root", "root");
                pool.add(conn);
            }
        }
        final Connection conn = pool.remove(0);

        //--利用动态代理改造close方法
        Connection proxy = (Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(), conn.getClass().getInterfaces()
                , new InvocationHandler() {

                    public Object invoke(Object proxy, Method method,
                                         Object[] args) throws Throwable {
                        if ("close".equals(method.getName())) {
                            //对于想要改造的close方法,我们自己写
                            retConn(conn);
                            return null;
                        } else {
                            //对于不想改造的方法调用被代理者身上相同的方法
                            return method.invoke(conn, args);
                        }
                    }

                });
        System.out.println("获取了一个连接,池里还剩余" + pool.size() + "个连接");
        return proxy;
    }


    private void retConn(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                pool.add(conn);
                System.out.println("还回了一个连接,池里还剩余" + pool.size() + "个连接");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Connection getConnection(String username, String password)
            throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    public PrintWriter getLogWriter() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    public int getLoginTimeout() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    public void setLogWriter(PrintWriter out) throws SQLException {
        // TODO Auto-generated method stub

    }

    public void setLoginTimeout(int seconds) throws SQLException {
        // TODO Auto-generated method stub

    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
