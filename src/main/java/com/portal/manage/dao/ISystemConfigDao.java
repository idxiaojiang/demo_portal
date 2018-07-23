package com.portal.manage.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.portal.base.entity.SystemParamsVO;

public interface ISystemConfigDao {
	public List<SystemParamsVO> getSystemConfAll(SystemParamsVO configVO);
	
}
