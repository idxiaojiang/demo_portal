package com.portal.manage.service;

import java.util.List;

import com.portal.base.entity.SystemParamsVO;

public interface ISystemConfigService {
	/**
	 * 从内存中读取已设置的系统配置信息
	 * @return
	 */
	public List<SystemParamsVO> getSystemAllConfigList();
	
	/**
	 * 从数据库中读取系统配置项
	 * @return
	 */
	public List<SystemParamsVO> getSystemAllConfigByDB();

	/**
	 * 根据数据库信息设置系统配置项
	 */
	public void initSystemConfig() throws Exception;
}
