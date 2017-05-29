package com.bingley.ee.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Mr.bingley
 * @version 1.0.0
 * @des $des$
 * @since 2017/5/18.
 */

/**
 * 类加载器默认是在tomcat下的classes目录下，如果要返回上级的上级要用../../
 *
 * 那如果是在src   com  下该如何读取尝试下
 */
public class ServiceReadPath {
    public void methdo1() throws FileNotFoundException, IOException {
        //--在没有ServletContext的环境下,如果想要读取资源,可以使用类加载器以加载类的方式加载资源,
        //		这里要注意,类加载器从哪个目录加载类,就从哪个目录加载资源,
        //		所以此处的路径一定要给一个相对于类加载目录的路径
        Properties prop = new Properties();
        prop.load(new FileReader(ServiceReadPath.class.getClassLoader().getResource("../../config.properties").getPath()));
        System.out.println(prop.getProperty("username"));
        System.out.println(prop.getProperty("password"));
    }
}
