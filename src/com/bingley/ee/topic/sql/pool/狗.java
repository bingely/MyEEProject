package com.bingley.ee.topic.sql.pool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface 动物{
	public void 吃();
	public void 叫();
}
public class 狗 implements 动物 {

	public void 吃(){
		System.out.println("狗在么么么么么的吃......");
	}
	public void 叫(){
		System.out.println("狗在旺旺旺旺的叫......");
	}

	public static void main(String[] args) {
		//狗 dog = new 继承狗();
		//狗 dog = new 狗();
		//动物 ani = new 装饰狗(dog);
		//ani.吃();
		//ani.叫();

		final 狗 dog = new 狗();
		动物 proxy = (动物) Proxy.newProxyInstance(狗.class.getClassLoader(), 狗.class.getInterfaces()
				, new InvocationHandler(){
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						if("叫".equals(method.getName())){
							System.out.println("代理狗在哈哈哈哈的叫.....");
							return null;
						}else{
							return method.invoke(dog, args);
						}
					}
				});

		proxy.吃();
		proxy.叫();
	}
}
//装饰
class 装饰狗 implements 动物{
	private 动物 ani = null;
	public 装饰狗(动物 ani) {
		this.ani = ani;
	}

	public void 叫() {
		System.out.println("狗在咩咩咩咩的叫.....");
	}

	public void 吃() {
		ani.吃();
	}

}
//继承
class 继承狗 extends 狗{
	@Override
	public void 叫() {
		System.out.println("狗在喵喵喵喵的叫......");
	}
}

