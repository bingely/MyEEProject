package com.bingley.ee.dao;

import com.bingley.ee.domain.User;
import com.bingley.ee.util.XmlDaoUtils;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des 对应着user的增删改查（模拟数据库）
 * @since 2017/5/25.
 */
public class XmlUserDao {
    /**
     * 根据用户名查找用户
     * @param username 用户名
     * @return 根据用户名找到的用户信息bean,如果没找到返回null
     */
    public User findUserByUserName(String username){
        Document dom = XmlDaoUtils.getDom();
        Element root = dom.getRootElement();
        //在xml中查找具有username属性值等于传入的用户名的元素 （这个是xpath知识点）
        List<Element> list = root.selectNodes("//user[@username='"+username+"']");
        if(list.size()>0){//大于0说明找到了这个用户
            Element userEle = list.get(0);
            //将找到的用户信息封装到bean后返回
            User user = new User();
            user.setUsername(userEle.attributeValue("username"));
            user.setPassword(userEle.attributeValue("password"));
            user.setNickname(userEle.attributeValue("nickname"));
            user.setEmail(userEle.attributeValue("email"));
            return user;
        }else{//说明没有找到这个用户
            return null;
        }
    }

    /**
     * 添加用户
     * @param user 要添加的用户信息bean
     */
    public void addUser(User user){
        Document dom = XmlDaoUtils.getDom();
        Element root = dom.getRootElement();
        //凭空创建出一个<user>元素,根据传入的user信息,设置此元素的属性
        Element userEle = DocumentHelper.createElement("user");
        userEle.setAttributeValue("username", user.getUsername());
        userEle.setAttributeValue("password", user.getPassword());
        userEle.setAttributeValue("nickname", user.getNickname());
        userEle.setAttributeValue("email", user.getEmail());
        //挂载到<users>元素上
        root.add(userEle);
        //回写到xml文件中
        XmlDaoUtils.refXml();
    }

    /**
     * 根据用户名密码查找对应的用户
     * @param username 用户名
     * @param password 密码
     * @return 找到的用户,如果找不到则返回null
     */
    public User findUserByUNandPSW(String username,String password){
        Document dom = XmlDaoUtils.getDom();
        Element root = dom.getRootElement();
        //在xml中查找具有username属性值等于传入的用户名 并且 password 等于传入密码的元素
        List<Element> list = root.selectNodes("//user[@username='"+username+"' and @password='"+password+"']");
        if(list.size()>0){//大于0说明找到了这个用户
            Element userEle = list.get(0);
            //将找到的用户信息封装到bean后返回
            User user = new User();
            user.setUsername(userEle.attributeValue("username"));
            user.setPassword(userEle.attributeValue("password"));
            user.setNickname(userEle.attributeValue("nickname"));
            user.setEmail(userEle.attributeValue("email"));
            return user;
        }else{//说明没有找到这个用户
            return null;
        }
    }
}
