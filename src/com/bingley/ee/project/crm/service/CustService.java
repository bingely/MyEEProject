package com.bingley.ee.project.crm.service;

import com.bingley.ee.project.crm.domain.Cust;

import java.util.List;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des $des$
 * @since 2017/6/3.
 */

// 定义接口的意思就是要把操作模板化
public interface CustService {
    /**
     * 添加客户
     * @param cust 封装了用户信息的bean
     */
    void addCust(Cust cust);

    /**
     * 查询所有客户信息
     * @return
     */
    List<Cust> getAllCust();

    /**
     * 根据id查找客户信息
     * @param id 客户id
     * @return 查找到的客户信息,如果找不到返回null
     */
    Cust findCustById(String id);

    /**
     * 修改客户信息的方法
     * @param cust 封装了最新客户信息的bean
     */
    void updateCust(Cust cust);

    /**
     * 根据id删除客户
     * @param id
     */
    void delCustByID(String id);

    /**
     * 批量伤处客户 其中会进行事务管理
     * @param ids 所有要删除的id组成的数组
     */
    void batchDel(String[] ids);

}
