package com.bingley.ee.topic.sql.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des 分别用1 古老方法实现增删改功能  2 DBUtils方式实现增删改  3 MyDBUtils（模仿DBUtils)方式实现增删改
 * @since 2017/6/3.
 */
public class DbUtilsUpdate {
    /**
     * 古老方法实现增删改功能
     * 	--在进行增删改操作时,每次都不一样的只有sql语句和sql语句中的参数
     */
    @Test
    public void update1(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ComboPooledDataSource source = new ComboPooledDataSource();
        try{
            conn = source.getConnection();
            ps = conn.prepareStatement("update account set money=? where name=?");
            ps.setDouble(1, 999);
            ps.setString(2, "a");
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            DbUtils.closeQuietly(conn, ps, rs);
        }

    }

    /**
     * DBUtils方式实现增删改
     * @throws SQLException
     */
    @Test
    public void add2() throws SQLException{
        QueryRunner runner = new QueryRunner(new ComboPooledDataSource());
        runner.update("update account set money=? where name=?", 888,"a");
    }

    /**
     * MyDBUtils方式实现增删改
     * @throws SQLException
     */
    @Test
    public void add3() throws SQLException{
        MyQueryRunner runner = new MyQueryRunner(new ComboPooledDataSource());
        runner.update("update account set money=? where name=?", 777,"a");
    }
}
