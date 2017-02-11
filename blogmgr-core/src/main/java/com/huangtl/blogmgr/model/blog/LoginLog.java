package com.huangtl.blogmgr.model.blog;

import java.util.Date;

import com.huangtl.blogmgr.model.common.ObjectValue;

/**
 * 登录日志
 * @author PraiseLord
 * @date 2017年2月10日
 */
public class LoginLog extends ObjectValue {
	private static final long serialVersionUID = 7063109396233795293L;
	private String fId;		
	private String fUid;		//登录用户id
	private String fIp;			//登录IP
	private String fBrowser;	//使用浏览器
	private Date fCreateDate;	//登录时间
	private String fOperatingSystem; //操作系统
	
	private String userName;	//登录用户名
	private String userAccount; //登录用户账号
	
	public String getfId() {
		return fId;
	}
	public void setfId(String fId) {
		this.fId = fId;
	}
	public String getfUid() {
		return fUid;
	}
	public void setfUid(String fUid) {
		this.fUid = fUid;
	}
	public String getfIp() {
		return fIp;
	}
	public void setfIp(String fIp) {
		this.fIp = fIp;
	}
	public String getfBrowser() {
		return fBrowser;
	}
	public void setfBrowser(String fBrowser) {
		this.fBrowser = fBrowser;
	}
	public Date getfCreateDate() {
		return fCreateDate;
	}
	public void setfCreateDate(Date fCreateDate) {
		this.fCreateDate = fCreateDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getfOperatingSystem() {
		return fOperatingSystem;
	}
	public void setfOperatingSystem(String fOperatingSystem) {
		this.fOperatingSystem = fOperatingSystem;
	}
}
