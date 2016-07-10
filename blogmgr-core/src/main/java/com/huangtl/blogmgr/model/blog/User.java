package com.huangtl.blogmgr.model.blog;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.huangtl.blogmgr.model.common.ObjectValue;
import com.huangtl.blogmgr.model.type.Gender;
import com.huangtl.blogmgr.model.type.UserStatus;

/**
 * 后台用户
 * @date 2016年7月9日
 * @author PraiseLord
 */
public class User extends ObjectValue {
	private static final long serialVersionUID = -7960114915317326699L;
	private String fId;				//
	private String fName;			//名称
	private String fAccount;		//登录账号
	private String fPassword;		//密码
	private UserStatus fStatus;		//状态
	private String fPhone;			//电话
	private String fEmail;			//邮件
	private Gender fGender;			//性别
	private String fPinYin;			//拼音
	private String fDescr;			//备注
	private String fAvatar;			//头像
	private String fCreater;		//创建人
	private Date fCreateDate;		//创建日期
	private String fEditor;			//修改人
	private Date fEditDate;			//修改日期
	
	
	@NotBlank(message="主键为空")
	public String getfId() {
		return fId;
	}
	public void setfId(String fId) {
		this.fId = fId;
	}
	@NotBlank(message="名称为空")
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfPhone() {
		return fPhone;
	}
	public void setfPhone(String fPhone) {
		this.fPhone = fPhone;
	}
	public String getfEmail() {
		return fEmail;
	}
	public void setfEmail(String fEmail) {
		this.fEmail = fEmail;
	}
	@NotNull(message="性别为空")
	public Gender getfGender() {
		return fGender;
	}
	public void setfGender(Gender fGender) {
		this.fGender = fGender;
	}
	public String getfAvatar() {
		return fAvatar;
	}
	public void setfAvatar(String fAvatar) {
		this.fAvatar = fAvatar;
	}
	@NotBlank(message="账号为空")
	public String getfAccount() {
		return fAccount;
	}
	public void setfAccount(String fAccount) {
		this.fAccount = fAccount;
	}
	@NotBlank(message="密码为空")
	public String getfPassword() {
		return fPassword;
	}
	public void setfPassword(String fPassword) {
		this.fPassword = fPassword;
	}
	@NotNull(message="状态为空")
	public UserStatus getfStatus() {
		return fStatus;
	}
	public void setfStatus(UserStatus fStatus) {
		this.fStatus = fStatus;
	}
	@NotBlank(message="拼音为空")
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
	@NotBlank(message="创建人为空")
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
	@NotNull(message="创建日期为空")
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
