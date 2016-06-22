package com.huangtl.blogmgr.model.common;

import java.util.Collection;

/**
 * jquery dataTable Page
 * @date 2016年4月20日
 * @author PraiseLord
 */
public class DataTablePage<T> {
	private int draw = 1;
	private long recordsTotal;
	private long recordsFiltered;
	private Collection<T> data;
	private String error;
	
	public DataTablePage() {
		super();
	}
	public DataTablePage(int draw, long recordsTotal, Collection<T> data) {
		super();
		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.data = data;
	}
	
	public DataTablePage(int draw, long recordsTotal, long recordsFiltered, Collection<T> data) {
		super();
		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.data = data;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public long getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public long getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public   Collection<T> getData() {
		return data;
	}
	public void setData(  Collection<T> data) {
		this.data = data;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
}
