package com.huangtl.blogmgr.model.blog;

import java.util.Date;

import com.huangtl.blogmgr.model.common.ObjectValue;

public class User extends ObjectValue {
	private static final long serialVersionUID = -7960114915317326699L;
	private String fId;				//
	private String fName;			//名称
	private String fAccount;		//登录账号
	private String fPassword;		//密码
	private String fStatus;			//状态
	private String fPinYin;			//拼音
	private String fDescr;			//备注
	private String fCreater;		//创建人
	private Date fCreateDate;		//创建日期
	private String fEditor;			//修改人
	private Date fEditDate;			//修改日期
	
	
	
	public String getfId() {
		return fId;
	}
	public void setfId(String fId) {
		this.fId = fId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfAccount() {
		return fAccount;
	}
	public void setfAccount(String fAccount) {
		this.fAccount = fAccount;
	}
	public String getfPassword() {
		return fPassword;
	}
	public void setfPassword(String fPassword) {
		this.fPassword = fPassword;
	}
	public String getfStatus() {
		return fStatus;
	}
	public void setfStatus(String fStatus) {
		this.fStatus = fStatus;
	}
	public String getStatusName(){
		//TODO
		return "";
	}
	public String getfPinYin() {
		return fPinYin;
	}
	public void setfPinYin(String fPinYin) {
		this.fPinYin = fPinYin;
	}
	public String getfDescr() {
		return fDescr;
	}
	public void setfDescr(String fDescr) {
		this.fDescr = fDescr;
	}
	public String getfCreater() {
		return fCreater;
	}
	public String getCreaterName(){
		//TODO
		return "";
	}
	public void setfCreater(String fCreater) {
		this.fCreater = fCreater;
	}
	public Date getfCreateDate() {
		return fCreateDate;
	}
	public void setfCreateDate(Date fCreateDate) {
		this.fCreateDate = fCreateDate;
	}
	public String getCreateDate(){
		//TODO
		return "";
	}
	public String getfEditor() {
		return fEditor;
	}
	public void setfEditor(String fEditor) {
		this.fEditor = fEditor;
	}
	public Date getfEditDate() {
		return fEditDate;
	}
	public void setfEditDate(Date fEditDate) {
		this.fEditDate = fEditDate;
	}
}
