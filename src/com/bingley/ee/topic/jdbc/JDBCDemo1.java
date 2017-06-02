package com.bingley.ee.topic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des jdbc 快速入门
 * @since 2017/6/1.
 */

// 注意导入包是sql里面的
public class JDBCDemo1 {
    public static void main(String[] args){
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try{
            //1.注册数据库驱动
            //--由于mysql在Driver类的实现中自己注册了一次,而我们又注册了一次,于是会导致MySql驱动被注册两次
            //--创建MySql的Driver对象时,导致了程序和具体的Mysql驱动绑死在了一起,在切换数据库时需要改动java代码
            //DriverManager.registerDriver(new Driver());
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库连接 (jdbc:mysql://localhost:3306/jdbc 因為是默認值，所以可以省略）
            conn = DriverManager.getConnection("jdbc:mysql:///jdbc?user=root&password=root");
            //3.获取传输器对象
            stat = conn.createStatement();
            //4.利用传输器传输sql语句到数据库中执行,获取结果集对象
            rs = stat.executeQuery("select * from user");
            //5.遍历结果集获取查询结果
            while(rs.next()){
                String name = rs.getString("name");
                System.out.println(name);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            //6.关闭资源 （最晚的先关闭）
            // 比如rs.close()会有异常，必须要处理资源问题
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    rs = null;
                }
            }
            if(stat!=null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    stat = null;
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally{
                    conn = null;
                }
            }
        }
    }
}
