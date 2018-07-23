package com.portal.manage.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.portal.base.entity.ResultDataVO;
import com.portal.base.entity.SystemParamsVO;
import com.portal.manage.service.ISystemConfigService;

@Controller
@RequestMapping("/systemManage")
public class SystemManageController {
	private final Logger LOGGER_ = Logger.getLogger(SystemManageController.class);

	@Autowired
	private ISystemConfigService iSystemConfigService;

	@RequestMapping("/refreshSysConf")
	@ResponseBody
	public ResultDataVO<List<SystemParamsVO>> refreshSysConf() {
		ResultDataVO<List<SystemParamsVO>> resultDataVO = new ResultDataVO<List<SystemParamsVO>>();
		try {
			iSystemConfigService.initSystemConfig();
			resultDataVO.setResult(iSystemConfigService.getSystemAllConfigList());
		} catch (Exception e) {
			LOGGER_.error("刷系统配置配置异常", e);
			resultDataVO.setCode(500);
			resultDataVO.setMessage(e.getMessage());
		}
		return resultDataVO;
	}
}
