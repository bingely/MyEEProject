package com.bingley.ee.factory;

import java.io.FileReader;
import java.util.Properties;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des 工厂类实现解耦 （接口及其实现类，配置文件，工厂类）
 * ---通过读取配置文件来实例化**
 * @since 2017/6/3.
 */
public class BasicFactory {
    private static BasicFactory factory = new BasicFactory();
    private static Properties prop = null;

    public static String CONFIGNAME = "crm-config.properties";  // 下次运行某个项目的时候改下这里的配置文件名字。

    public BasicFactory() {
    }

    public static BasicFactory getFactory() {
        return factory;
    }


    static {
        try {
            prop = new Properties();
            prop.load(new FileReader(BasicFactory.class.getClassLoader().getResource(CONFIGNAME).getPath()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过配置文件中信息    接口名字找到实现类
     * @param clazz 接口的名字
     * @param <T>  实现类
     * @return
     */
    public <T> T getInstance(Class<T> clazz) {   // 接口的名字比如现在是CustDao.class
        try {
            String cName = clazz.getSimpleName();
            String cImplName = prop.getProperty(cName);  //com.bingley.ee.project.crm.dao.CustDaoImpl
            return (T) Class.forName(cImplName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
