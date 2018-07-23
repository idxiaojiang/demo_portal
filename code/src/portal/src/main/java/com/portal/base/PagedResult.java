package com.portal.base;

import java.util.List;

import com.portal.base.entity.BaseResourceVO;

public class PagedResult<T> extends BaseResourceVO {

	private static final long serialVersionUID = 1L;

	private List<T> dataList;// 数据

	private long currPage;// 当前页

	private long pageSize;// 条数

	private long total;// 总条数

	private long pages;// 总页面数目
	
	private int startRow;
	private int endRow;

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
	public long getCurrPage() {
		return currPage;
	}

	public void setCurrPage(long currPage) {
		this.currPage = currPage;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getPages() {
		return pages;
	}

	public void setPages(long pages) {
		this.pages = pages;
	}

}
