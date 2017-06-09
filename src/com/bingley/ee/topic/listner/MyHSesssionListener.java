package com.bingley.ee.topic.listner;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * ����Session����Ĵ���������
 * @author park
 *
 */
public class MyHSesssionListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session���󱻴���������..."+se.getSession());
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session����������..."+se.getSession());
	}

}
