package com.portal.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.portal.base.entity.SystemParamsVO;
import com.portal.base.listener.InitSystemListener;

/**
 * 系统启动时初始化系统配置项对象,数据来自t_system_config表
 * 
 * @author Administrator
 *
 */
public class SystemParams {
	private static final Logger LOGGER_ = Logger.getLogger(InitSystemListener.class);
	private static SystemParams systemConfig = new SystemParams();
	private static Map<String, SystemParamsVO> sysConfMap = new HashMap<String, SystemParamsVO>();
	private static List<SystemParamsVO> systemConfigList = new ArrayList<SystemParamsVO>();

	private SystemParams() {
		LOGGER_.info("初始化系统配置信息存储对象");
	}

	/**
	 * 获取系统配置项对象
	 * 
	 * @return
	 */
	public static SystemParams getSystemConifg() {
		return systemConfig;
	}

	/**
	 * 获取单个系统配置项的VO对象
	 * 
	 * @param itemKey
	 * @return
	 */
	public SystemParamsVO getSystemItem(String itemKey) {
		return SystemParams.sysConfMap.get(itemKey);
	}

	/**
	 * 获取单个系统配置项的值
	 * 
	 * @param itemKey
	 * @return
	 */
	public static String getItemVal(String itemKey) {
		SystemParamsVO configVO = SystemParams.sysConfMap.get(itemKey);
		if (configVO == null) {
			LOGGER_.error("从系统配置项中未找到 "+itemKey+" 的配置对象");
			throw new NullPointerException("从系统配置项中未找到 "+itemKey+" 的配置对象");
		}
		return configVO.getAttributeValue();
	}

	/**
	 * 获取所有系统配置项的值
	 * 
	 * @param itemKey
	 * @return
	 */
	public Map<String, SystemParamsVO> getSystemAllItem() {
		return SystemParams.sysConfMap;
	}

	/**
	 * 设置单个系统配置项
	 * 
	 * @param item
	 * @param value
	 */
	public void setSystemItemConfig(String item, SystemParamsVO value) {
		SystemParams.sysConfMap.put(item, value);
	}

	/**
	 * 设置所有系统配置项
	 * 
	 * @param sysConfMap
	 */
	public void setSystemAllConfig(Map<String, SystemParamsVO> sysConfMap) {
		SystemParams.sysConfMap = sysConfMap;
	}

	/**
	 * 设置系统配置列表
	 */
	public void setSystemAllConfigList(List<SystemParamsVO> systemConfigList) {
		SystemParams.systemConfigList = systemConfigList;
	}

	/**
	 * 读取系统配置列表
	 * 
	 * @return
	 */
	public List<SystemParamsVO> getSystemAllConfigList() {
		return SystemParams.systemConfigList;
	}
}
