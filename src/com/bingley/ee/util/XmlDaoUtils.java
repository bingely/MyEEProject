package com.bingley.ee.util;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * xml 操作工具包
 */
public class XmlDaoUtils {
	private static Document dom = null;
	// xml 路径(通过类加载器加载的方式得到） TODO
	private static String path = XmlDaoUtils.class.getClassLoader().getResource("users.xml").getPath();

	private XmlDaoUtils() {
	}

	/**
	 * 放在静态块中，防止多次实例化而消耗资源
	 */
	static{
		try{
			SAXReader reader = new SAXReader();
			dom = reader.read(path);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static Document getDom(){
		return dom;
	}

	/**
	 * 回写xml
	 */
	public static void refXml(){
		try {
			XMLWriter writer = new XMLWriter(new FileOutputStream(path),OutputFormat.createPrettyPrint());
			writer.write(dom);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
