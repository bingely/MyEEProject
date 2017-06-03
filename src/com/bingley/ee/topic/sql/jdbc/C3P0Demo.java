package com.bingley.ee.topic.sql.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 之所以要写成c3po因为有池的保护
 */
public class C3P0Demo {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			// 这句话等同与下面的四句话。 它通过类加载器去寻找一个名叫c3p0-config.xml的文件
			// 默认如果无参数，选用的是default-config
			// 如果传入参数 就指定某个具体的config
			ComboPooledDataSource source = new ComboPooledDataSource();
//			source.setDriverClass("com.mysql.jdbc.Driver");
//			source.setJdbcUrl("jdbc:mysql:///day11");
//			source.setUser("root");
//			source.setPassword("root");
			
			conn = source.getConnection();
			ps = conn.prepareStatement("select * from account");
			rs = ps.executeQuery();
			while(rs.next()){
				String name = rs.getString("name");
				System.out.println(name);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					rs = null;
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					ps = null;
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
