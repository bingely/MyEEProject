package com.bingley.ee.project.crm.service;

import com.bingley.ee.factory.BasicFactory;
import com.bingley.ee.project.crm.dao.CustDao;
import com.bingley.ee.project.crm.domain.Cust;
import com.bingley.ee.util.DaoUtils;

import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.util.List;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des $des$
 * @since 2017/6/3.
 */


public class CustServiceImpl implements CustService {
    CustDao dao = BasicFactory.getFactory().getInstance(CustDao.class);

    @Override
    public void addCust(Cust cust) {
        //1.检查用户名是否已经存在
        if (dao.findUserByName(cust.getName()) != null) {
            throw new RuntimeException("用户名已经存在");
        }
        //2.调用dao中的方法增加用户
        dao.addCust(cust);
    }

    @Override
    public List<Cust> getAllCust() {
        return dao.getAllCust();
    }

    @Override
    public Cust findCustById(String id) {
        return dao.findUserById(id);
    }

    @Override
    public void updateCust(Cust cust) {
        dao.updateCust(cust);
    }

    @Override
    public void delCustByID(String id) {
        dao.delCustByID(id);
    }

    @Override
    public void batchDel(String[] ids) {
        Connection conn = DaoUtils.getConn();
        try {
            conn.setAutoCommit(false);
            for (String id : ids) {
                dao.delCustByIDWithTrans(conn, id);
            }
            DbUtils.commitAndCloseQuietly(conn);
        } catch (Exception e) {
            DbUtils.rollbackAndCloseQuietly(conn);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
