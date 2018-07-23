package com.portal.base.entity;

/**
 * 系统配置VO
 * @author Administrator
 *
 */
public class SystemParamsVO extends BaseResourceVO{
	private long id;
	
	//属性 key
	private String attributeKey;
	//属性值
	private String attributeValue;
	//属性所属模块
	private String attributeModule;
	//属性是否启用 true/false
	private String attributeEnable;
	//所属系统环境类型
	private String environment;
	
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAttributeKey() {
		return attributeKey;
	}
	public void setAttributeKey(String attributeKey) {
		this.attributeKey = attributeKey;
	}
	public String getAttributeValue() {
		return attributeValue;
	}
	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}
	public String getAttributeModule() {
		return attributeModule;
	}
	public void setAttributeModule(String attributeModule) {
		this.attributeModule = attributeModule;
	}
	public String getAttributeEnable() {
		return attributeEnable;
	}
	public void setAttributeEnable(String attributeEnable) {
		this.attributeEnable = attributeEnable;
	}
	
	
}
