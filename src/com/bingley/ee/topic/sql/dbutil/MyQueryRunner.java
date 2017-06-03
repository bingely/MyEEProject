package com.bingley.ee.topic.sql.dbutil;

import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des MyDBUtils（模仿DBUtils)方式实现增删改---底层用的就是元数据
 * @since 2017/6/3.
 */
public class MyQueryRunner {
    private DataSource mSource = null;

    public MyQueryRunner() {
    }

    public MyQueryRunner(DataSource source) {
        mSource = source;
    }

    public int update(String sql, Object... params) throws SQLException {
        Connection conn = mSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        //--获取参数元数据,获取参数的个数
        ParameterMetaData metaData = ps.getParameterMetaData();
        int count = metaData.getParameterCount();
        //--循环设置参数的值
        for (int i = 1; i <= count; i++) {
            ps.setObject(i, params[i - 1]);
        }
        //--执行update操作
        int num = ps.executeUpdate();
        DbUtils.closeQuietly(conn, ps, null);
        return num;
    }

    // 厉害（通过
    public <T> T query(String sql, MyResultSetHandler<T> rsh, Object... params)throws SQLException{
        Connection conn = mSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        //--获取参数元数据,获知参数个数
        ParameterMetaData metaData = ps.getParameterMetaData();
        int count = metaData.getParameterCount();
        //--循环设置参数
        for(int i=1;i<=count;i++){
            ps.setObject(i, params[i-1]);
        }

        //--执行查询获取结果集
        ResultSet rs = ps.executeQuery();

        //--回调处理结果集的逻辑
        T t = rsh.handle(rs);
        DbUtils.closeQuietly(conn, ps, rs);
        return t;
    }
}
