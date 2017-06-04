package com.bingley.ee.project.crm.dao;

import com.bingley.ee.factory.BasicFactory;
import com.bingley.ee.project.crm.domain.Cust;
import com.bingley.ee.util.DaoUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des $des$
 * @since 2017/6/3.
 */
public class CustDaoImpl implements CustDao {
    public void addCust(Cust cust) {
        String sql = "insert into customer values (null,?,?,?,?,?,?,?,?)";
        try {
            QueryRunner runner = new QueryRunner(DaoUtils.getSource());
            runner.update(sql, cust.getName(), cust.getGender(), cust.getBirthday(), cust.getCellphone(), cust.getEmail(), cust.getPreference(), cust.getType(), cust.getDescription());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public Cust findUserByName(String name) {
        String sql = "select * from customer where name = ?";
        try {
            QueryRunner runner = new QueryRunner(DaoUtils.getSource());
            return runner.query(sql, new BeanHandler<Cust>(Cust.class), name);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public List<Cust> getAllCust() {
        String sql = "select * from customer";
        try {
            QueryRunner runner = new QueryRunner(DaoUtils.getSource());
            return runner.query(sql, new BeanListHandler<Cust>(Cust.class));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public Cust findUserById(String id) {
        String sql = "select * from customer where id = ?";
        try {
            QueryRunner runner = new QueryRunner(DaoUtils.getSource());
            return runner.query(sql, new BeanHandler<Cust>(Cust.class), id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void updateCust(Cust cust) {
        String sql = "update customer set name=? ,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=? where id=?";
        try {
            QueryRunner runner = new QueryRunner(DaoUtils.getSource());
            runner.update(sql, cust.getName(), cust.getGender(), cust.getBirthday(), cust.getCellphone(), cust.getEmail(), cust.getPreference(), cust.getType(), cust.getDescription(), cust.getId());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void delCustByID(String id) {
        String sql = "delete from customer where id = ?";
        try {
            QueryRunner runner = new QueryRunner(DaoUtils.getSource());
            runner.update(sql, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void delCustByIDWithTrans(Connection conn, String id) throws SQLException {
        String sql = "delete from customer where id = ?";
        QueryRunner runner = new QueryRunner();
        runner.update(conn, sql, id);
    }
}
