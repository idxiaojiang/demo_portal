package com.portal.base.entity;

import java.util.Date;

/**
 * 基础实体
 * @author Administrator
 *
 */
public class BaseResourceVO {
	/**
	 * 创建时间
	 */
	private Date createdDate;
	
	/**
	 * 最后修改时间
	 */
	private Date lastUpdateDate;


	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		if (lastUpdateDate == null) {
			this.lastUpdateDate = new Date();
		}else{
			this.lastUpdateDate = lastUpdateDate;
		}
	}
	
	
	
}
