package com.portal.note.entity;

import com.portal.base.entity.BaseResourceVO;

/**
 * 笔记封面VO
 * @author Administrator
 *
 */
public class NoteCoverVO extends BaseResourceVO{
	private String rowId;
	private String imgURL;
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	
}
