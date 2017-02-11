package com.huangtl.blogmgr.model.blog;

import java.util.Date;

import com.huangtl.blogmgr.model.common.ObjectValue;

/**
 * 系统sql执行日志
 * @author PraiseLord
 * @date 2017年2月10日
 *
 */
public class JdbcLog extends ObjectValue {
	private static final long serialVersionUID = 2486805383470770666L;
	private String fId;
	private String fText;
	private Date   fCreateDate;
	private Long   fTimeConsuming;
	private Integer fResult;
	
	public String getfId() {
		return fId;
	}
	public void setfId(String fId) {
		this.fId = fId;
	}
	public String getfText() {
		return fText;
	}
	public void setfText(String fText) {
		this.fText = fText;
	}
	public Date getfCreateDate() {
		return fCreateDate;
	}
	public void setfCreateDate(Date fCreateDate) {
		this.fCreateDate = fCreateDate;
	}
	public Long getfTimeConsuming() {
		return fTimeConsuming;
	}
	public void setfTimeConsuming(Long fTimeConsuming) {
		this.fTimeConsuming = fTimeConsuming;
	}
	public Integer getfResult() {
		return fResult;
	}
	public void setfResult(Integer fResult) {
		this.fResult = fResult;
	}
}
