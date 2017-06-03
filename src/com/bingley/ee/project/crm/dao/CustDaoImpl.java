package com.bingley.ee.project.crm.dao;

import com.bingley.ee.project.crm.domain.Cust;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des $des$
 * @since 2017/6/3.
 */
public class CustDaoImpl implements CustDao{
    @Override
    public Cust findUserByName(String name) {
        return null;
    }

    @Override
    public void addCust(Cust cust) {
        String sql = "";
    }

    @Override
    public List<Cust> getAllCust() {
        return null;
    }

    @Override
    public Cust findUserById(String id) {
        return null;
    }

    @Override
    public void updateCust(Cust cust) {

    }

    @Override
    public void delCustByID(String id) {

    }

    @Override
    public void delCustByIDWithTrans(Connection conn, String id) throws SQLException {

    }
}
