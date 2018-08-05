package com.portal.base.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.portal.base.utility.SmsClient;
import com.portal.manage.service.ISystemConfigService;


/**
 * 系统启动时，需要执行的初始化步骤
 * 
 * @author Administrator
 *
 */
public class InitSystemListener implements ServletContextListener {
	private final Logger LOGGER_ = Logger.getLogger(InitSystemListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent context) {

	}

	@Override
	public void contextInitialized(ServletContextEvent context) {
		ApplicationContext applicationContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(context.getServletContext());
		ISystemConfigService iSystemConfigService = (ISystemConfigService) applicationContext
				.getBean("systemConfigService");
		LOGGER_.info("============系统初始化设置 begin");
		LOGGER_.info("============系统初始化设置---> 1 读取系统初始化配置项 begin");
		try {
			iSystemConfigService.initSystemConfig();
		} catch (Exception e) {
			LOGGER_.error("读取系统初始化配置失败",e);
		}
		LOGGER_.info("============系统初始化设置---> 1 读取系统初始化配置项 end");
		LOGGER_.info("============系统初始化设置 end");
		
		//短信工具类初始化
		SmsClient.getInstance();
	}

}
