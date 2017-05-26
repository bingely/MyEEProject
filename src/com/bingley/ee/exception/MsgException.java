package com.bingley.ee.exception;

/**
 * 自定义异常类
 */

/**
 * how to use?
 * 比如做表单校验（非空等等情况，在service 中处理逻辑，要想通知给servlet,它可以辅佐到异常，得到异常的信息，
 * 然后发给前端。
 */
public class MsgException extends Exception {
	public MsgException() {
	}
	public MsgException(String msg) {
		super(msg);
	}
}
