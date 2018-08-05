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
	
	/**
	 * 服务根目录
	 */
	public static final String WEB_ROOT = "web_root";
	
	/**
	 * 资源上传的临时目录(全局)
	 */
	public static final String upload_path_temp = "upload_path_temp";
	
	/**
	 * 资源上传的正式目录(全局)
	 */
	public static final String upload_path = "upload_path";
	
	/**
	 * 笔记类资源的图片路径
	 */
	public static final String note_image_path = "note_image_path";
	
	/**
	 * 首页配置的 最火资源条数
	 */
	public static final String index_hot_num = "index_hot_num";
	
	/**
	 * 首页配置的 最新资源条数
	 */
	public static final String index_new_num = "index_new_num";
	
	/**
	 * 验证码图片路径（属于临时资源）
	 */
	public static final String verifyCode_path = "verifyCode_path";
}

