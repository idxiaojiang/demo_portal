package com.portal.manage.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.base.CommonConstant;
import com.portal.base.SystemParams;
import com.portal.base.entity.SystemParamsVO;
import com.portal.manage.dao.ISystemConfigDao;
import com.portal.manage.service.ISystemConfigService;

@Service
public class SystemConfigService implements ISystemConfigService {
	private Logger LOGGER_ = Logger.getLogger(ISystemConfigService.class);
	@Autowired
	private ISystemConfigDao iSystemConfigDao;

	public List<SystemParamsVO> getSystemAllConfigList() {
		return SystemParams.getSystemConifg().getSystemAllConfigList();
	}

	public List<SystemParamsVO> getSystemAllConfigByDB() {
		SystemParamsVO systemConfigVO = new SystemParamsVO();
		return iSystemConfigDao.getSystemConfAll(systemConfigVO);
	}

	public void initSystemConfig() throws Exception {
		LOGGER_.info("=====initSystemConfig begin");

		SystemParamsVO systemConfigVO = new SystemParamsVO();
		systemConfigVO.setAttributeEnable("true");
		systemConfigVO.setAttributeKey(CommonConstant.SERVER_ENV_KEY);
		String server_env = null;

		// 1.先读取系统当前的环境配置类型
		List<SystemParamsVO> configVOs = iSystemConfigDao.getSystemConfAll(systemConfigVO);
		if (configVOs != null && configVOs.size() > 0) {
			SystemParamsVO currentSysConf = configVOs.get(0);
			server_env = currentSysConf.getAttributeValue();
		} else {
			throw new Exception("未设置系统环境信息 server_env is null");
		}
		
		// 2.根据当前系统的环境类型，读取该类型的系统配置
		systemConfigVO.setAttributeKey(null);
		systemConfigVO.setEnvironment(server_env);
		List<SystemParamsVO> systemConfigList = iSystemConfigDao.getSystemConfAll(systemConfigVO);

		// 3 遍历设置当前系统配置key和value
		for (SystemParamsVO sysConfVO : systemConfigList) {
			SystemParams.getSystemConifg().setSystemItemConfig(sysConfVO.getAttributeKey(), sysConfVO);
		}
		
		// 4 设置当前系统的配置列表
		SystemParams.getSystemConifg().setSystemAllConfigList(systemConfigList);

		LOGGER_.info("=====initSystemConfig end");
	}

}
