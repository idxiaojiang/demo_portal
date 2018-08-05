package com.portal.base.utility;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.log4j.Logger;

import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.portal.base.SystemParams;
import com.portal.base.entity.SmsParamsVO;

/**
 * 短信发送工具类
 * @author Administrator
 *
 */
public class SmsClient {
	private final static Logger LOGGER_ = Logger.getLogger(SmsClient.class);
	private static SmsClient smsClient;
	
	//线程池
	private static ThreadPoolExecutor smsThreadPool = (ThreadPoolExecutor)Executors
			.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	private SmsClient() {
	}

	/**
	 * 初始化短信发送配置
	 */
	public static SmsClient getInstance() {
		if (null == smsClient) {
			LOGGER_.info("初始化发送短信程序");
			smsClient = new SmsClient();
		}
		return smsClient;
	}

	public void sendMessage(SmsParamsVO smsParamsVO) throws ServerException, ClientException {
		getInstance();

		checkSmsParams(smsParamsVO);

		LOGGER_.info("当前线程池有" + smsThreadPool.getQueue().size() + "线程");
		smsThreadPool.execute(new AliyunSmsProcess(smsParamsVO));
	}

	private void checkSmsParams(SmsParamsVO smsParamsVO) {
		if (null == smsParamsVO.getAccessKeyId()) {
			smsParamsVO.setAccessKeyId(SystemParams.getItemVal("accessKeyId"));
		}
		if (null == smsParamsVO.getAccessKeySecret()) {
			smsParamsVO.setAccessKeySecret(SystemParams.getItemVal("accessKeySecret"));
		}
		if (null == smsParamsVO.getSignName()) {
			smsParamsVO.setSignName(SystemParams.getItemVal("signName"));
		}
		if (null == smsParamsVO.getTemplateCode()) {
			smsParamsVO.setTemplateCode(SystemParams.getItemVal("templateCode"));
		}
	}

}
