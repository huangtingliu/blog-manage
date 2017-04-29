package com.huangtl.blogmgr.model.blog;

import com.huangtl.blogmgr.model.common.ObjectValue;

/**
 * 系统备忘录
 * @author Canaan
 * @date 2017年4月29日
 *
 */
public class SystemMemo extends ObjectValue {
	private static final long serialVersionUID = 1036876574138706523L;
	private String fId;
	private String fParentId;	//父id
	private String fHierarchy;	//层级关系
	private Integer fOrder;		//排序
	private String fTitle;		//标题
	private String fDescr;		//描述
	private String fUrl;		//连接
	public String getfId() {
		return fId;
	}
	public void setfId(String fId) {
		this.fId = fId;
	}
	public String getfTitle() {
		return fTitle;
	}
	public void setfTitle(String fTitle) {
		this.fTitle = fTitle;
	}
	public String getfDescr() {
		return fDescr;
	}
	public void setfDescr(String fDescr) {
		this.fDescr = fDescr;
	}
	public String getfUrl() {
		return fUrl;
	}
	public void setfUrl(String fUrl) {
		this.fUrl = fUrl;
	}
	public String getfParentId() {
		return fParentId;
	}
	public void setfParentId(String fParentId) {
		this.fParentId = fParentId;
	}
	public String getfHierarchy() {
		return fHierarchy;
	}
	public void setfHierarchy(String fHierarchy) {
		this.fHierarchy = fHierarchy;
	}
	public Integer getfOrder() {
		return fOrder;
	}
	public void setfOrder(Integer fOrder) {
		this.fOrder = fOrder;
	}
	
}
