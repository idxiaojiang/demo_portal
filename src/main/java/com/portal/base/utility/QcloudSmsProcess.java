package com.portal.base.utility;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONException;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;

public class QcloudSmsProcess implements Runnable{
	private final static Logger LOGGER_ = Logger.getLogger(QcloudSmsProcess.class);
	
	private String phoneNumbers;

	public QcloudSmsProcess(String phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public void run() {
		int appid = 1400116873;
		String appkey = "b7e717f0fa43bd25baa243ebbfea5db3";
		try {
			SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
			SmsSingleSenderResult result = ssender.send(0, "86", phoneNumbers, "【苏小江】您的验证码是: 5678", "", "");
			LOGGER_.info("腾讯云短信回执：" + result);
		} catch (HTTPException e) {
			// HTTP响应码错误
			e.printStackTrace();
		} catch (JSONException e) {
			// json解析错误
			e.printStackTrace();
		} catch (IOException e) {
			// 网络IO错误
			e.printStackTrace();
		}
	}

}
