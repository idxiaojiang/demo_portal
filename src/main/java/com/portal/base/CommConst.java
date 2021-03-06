package com.portal.base;

/**
 * 系统公共常量类
 * 
 * @author Administrator
 *
 */
public interface CommConst {
	
	/**
	 * 系统全局设置
	 * @author Administrator
	 *
	 */
	interface AppConf{
		/**
		 * 文档标题长度
		 */
		public static final int NOTE_TITLE_LENGTH = 50;
		
		/**
		 * 获取当前用户session信息的key
		 */
		public static final String CURRENT_SESSION = "currentSession";
		
		/**
		 * 达到登录失败次数，需要验证码
		 */
		public static final int LOGIN_FAILURE_VERIFYCODE = 3;
	}
	
	
	/**
	 * Http响应码信息
	 * @author Administrator
	 *
	 */
	interface HttpRespCode{
		/**
		 * 正常
		 */
		public static final int SESSION = 200;
		
		/**
		 * 响应码，输入异常
		 */
		public static final int INPUT_EXCEPTION = 400;
		
		/**
		 * 响应码,服务处理异常
		 */
		public static final int SERVER_EXCEPTION = 500;
	}


	/**
	 * 系统配置参数的Key
	 * @author Administrator
	 *
	 */
	interface SysParamKey{
		
		/**
		 * 表明配置系统环境类型的 key(根据该值查询或读取系统环境类型)
		 */
		public static final String SERVER_ENV_KEY = "server_env";
		
		/**
		 * 服务根目录
		 */
		public static final String WEB_ROOT = "web_root";
		
		/**
		 * 资源上传的临时目录(全局)
		 */
		public static final String UPLOAD_PATH_TEMP = "upload_path_temp";
		
		/**
		 * 资源上传的正式目录(全局)
		 */
		public static final String UPLOAD_PATH = "upload_path";
		
		/**
		 * 笔记类资源的图片路径
		 */
		public static final String NOTE_IMAGE_PATH = "note_image_path";
		
		/**
		 * 首页配置的 最火资源条数
		 */
		public static final String INDEX_HOT_NUM = "index_hot_num";
		
		/**
		 * 首页配置的 最新资源条数
		 */
		public static final String INDEX_NEW_NUM = "index_new_num";
		
		/**
		 * 验证码图片路径（属于临时资源）
		 */
		public static final String VERIFYCODE_PATH = "verifyCode_path";
	}
}

