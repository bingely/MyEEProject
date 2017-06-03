package com.bingley.ee.topic.sql.translation;
import com.bingley.ee.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des 事务
 * @since 2017/6/2.
 */
public class JDBCTranDemo {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Savepoint sp = null;
        try{
            conn = JDBCUtils.getConn();
            conn.setAutoCommit(false);

            ps = conn.prepareStatement("update account set money=money-100 where name = ?");
            ps.setString(1, "a");  // 提交参数
            ps.executeUpdate();

            ps = conn.prepareStatement("update account set money=money+100 where name=?");
            ps.setString(1, "b");
            ps.executeUpdate();

            //设置回滚点
            sp = conn.setSavepoint();

            ps = conn.prepareStatement("update account set money=money-100 where name = ?");
            ps.setString(1, "a");
            ps.executeUpdate();

            // 这个是模拟崩溃的意外（空指针等异常）
            String str = null;
            str.toUpperCase();

            ps = conn.prepareStatement("update account set money=money+100 where name=?");
            ps.setString(1, "b");
            ps.executeUpdate();

            conn.commit();
        }catch (Exception e) {
            try {
                if(sp == null){//如果回滚点为null说明没有执行到设置回滚点代码时就抛了异常,应该所有语句进行回滚
                    conn.rollback();
                }else{//说明sp不为null,可以会滚到回滚点,接着执行其他操作,但是要注意,如果希望之前的语句起作用,仍然需要做提交操作
                    conn.rollback(sp);
                    conn.commit();
                }

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally{
            JDBCUtils.close(rs, ps, conn);
        }
    }
}
