package com.bingley.ee.topic.sql.metabase;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des 为学习dbutils 框架铺垫学习的 基础知识----元数据
 * @since 2017/6/3.
 */
public class DataBaseMeataDataDemo {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ComboPooledDataSource source = new ComboPooledDataSource();
        try {
            conn = source.getConnection();
            //--获取当前数据库的元数据
            DatabaseMetaData metaData = conn.getMetaData();
            //----获取数据库连接时使用的URL
            String url = metaData.getURL();
            System.out.println(url);
            //----获取数据库的用户名
            String username = metaData.getUserName();
            System.out.println(username);
            //----获取驱动的名称
            String driverName = metaData.getDriverName();
            System.out.println(driverName);
            //----获取数据库中指定表的主键信息  （是给框架设计者用）
            rs = metaData.getPrimaryKeys(null, null, "account");
            while(rs.next()){
                short cseq = rs.getShort("KEY_SEQ");
                String cname = rs.getString("COLUMN_NAME");
                System.out.println(cseq+":"+cname);
            }
            //----获取表
            rs = metaData.getTables(null, null, "%", new String[]{"TABLE"});
            while(rs.next()){
                String tabName = rs.getString("TABLE_NAME");
                System.out.println(tabName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn, ps, rs);
        }
    }
}
