package com.bingley.ee.topic.sql.metabase;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbutils.DbUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des 参数元数据
 * @since 2017/6/3.
 */
public class PMMetaDataDemo {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ComboPooledDataSource source = new ComboPooledDataSource();
        try {
            conn = source.getConnection();
            ps = conn.prepareStatement("select * from account where name=? and money=?");
            //--获取参数元数据
            ParameterMetaData metaData = ps.getParameterMetaData();
            //----参数的个数
            int count = metaData.getParameterCount();
            System.out.println(count);
            //----获取参数的类型 （mysql 不支持获取参数，除非在URL后跟上?generateSimpleParameterMetadata=true
            String type = metaData.getParameterTypeName(1);
            System.out.println(type);
            String type2 = metaData.getParameterTypeName(2);
            System.out.println(type2);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn, ps, rs);
        }
    }

}
