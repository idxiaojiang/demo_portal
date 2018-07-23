package com.portal.base;

/**
 * 系统公共常量类
 * 
 * @author Administrator
 *
 */
public interface CommonConstant {
	/**
	 * 表明配置系统环境类型的 key(根据该值查询或读取系统环境类型)
	 */
	public static final String SERVER_ENV_KEY = "server_env";
	
	/**
	 * 文档标题长度
	 */
	public static final int NOTE_TITLE_LENGTH = 50;

	/**
	 * 响应码，输入异常
	 */
	public static final int INPUT_EXCEPTION = 400;
	
	/**
	 * 响应码,服务处理异常
	 */
	public static final int SERVER_EXCEPTION = 500;
}
