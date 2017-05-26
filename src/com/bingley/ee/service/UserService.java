package com.bingley.ee.service;


import com.bingley.ee.dao.XmlUserDao;
import com.bingley.ee.domain.User;
import com.bingley.ee.exception.MsgException;

/**
   * 逻辑操作
   * Author:  Mr.bingley
   * Version:
   * Date:  2017/5/26
   */
public class UserService {
	// 通过组装的形式拿到xmluserDao 的引用
	private XmlUserDao dao = new XmlUserDao();

	/**
	 * 添加用户
	 * @param user
	 * @throws MsgException
	 */
	public void registUser(User user) throws MsgException {
		//1.检查用户名是否已经存在,如果已经存在则提示
		if (dao.findUserByUserName(user.getUsername()) != null) {
			throw new MsgException("用户名已经存在!");  // 把信息通过异常的方式抛出，后面通过servlet统一的处理该异常
		}

		//2.如果不存在则调用dao中的方法添加用户
		dao.addUser(user);
	}

	/**
	 * 检查用户名密码是否正确
	 * @param username
	 * @param password
	 */
	public User isUser(String username,String password){
		return dao.findUserByUNandPSW(username, password);
	}
}
