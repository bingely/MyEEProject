package com.bingley.ee.test;

import com.bingley.ee.dao.XmlUserDao;
import com.bingley.ee.domain.User;

import org.junit.Test;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des 所谓的测试就是引入一些具体的参数验证方法是否正确
 * @since 2017/5/25.
 */
public class XmlUserDaoTest {
    @Test
    public void testFindUserByUserName(){
        XmlUserDao dao = new XmlUserDao();
        User user = dao.findUserByUserName("admin");
        System.out.println(user);
    }

    @Test
    public void testFindUserByNMandPSW(){
        XmlUserDao dao = new XmlUserDao();
        User user = dao.findUserByUNandPSW("admin", "adminxx");
        System.out.println(user);
    }

    @Test
    public void testAddUser(){
        XmlUserDao dao = new XmlUserDao();
        User user = new User();
        user.setUsername("朴乾");
        user.setPassword("123");
        user.setNickname("小朴朴");
        user.setEmail("piaoqian@itcast.cn");
        dao.addUser(user);
    }
}
