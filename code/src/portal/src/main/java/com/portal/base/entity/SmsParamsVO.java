package com.portal.base.entity;

/**
 * 短信参数类
 * @author Administrator
 *
 */
public class SmsParamsVO {
	//电话号码（多个电话号码 逗号,分隔）
	private String phoneNumbers;
	//短信签名
	private String signName;
	//短信模板Code
	private String templateCode;
	//短信模板参数
	private String templateParam;
	//短信平台认证key
	private String accessKeyId;
	//短信平台认证secret
	private String accessKeySecret;

	public String getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(String phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public String getSignName() {
		return signName;
	}

	public void setSignName(String signName) {
		this.signName = signName;
	}

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	public String getTemplateParam() {
		return templateParam;
	}

	public void setTemplateParam(String templateParam) {
		this.templateParam = templateParam;
	}

	public String getAccessKeyId() {
		return accessKeyId;
	}

	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	public String getAccessKeySecret() {
		return accessKeySecret;
	}

	public void setAccessKeySecret(String accessKeySecret) {
		this.accessKeySecret = accessKeySecret;
	}

}
