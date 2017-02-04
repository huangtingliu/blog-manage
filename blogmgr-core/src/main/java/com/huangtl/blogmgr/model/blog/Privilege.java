package com.huangtl.blogmgr.model.blog;

import com.huangtl.blogmgr.model.blog.dictionary.AuthPriority;
import com.huangtl.blogmgr.model.blog.dictionary.PrivilegeType;
import com.huangtl.blogmgr.model.common.ObjectValue;

/**
 * 权限对象
 * @author PraiseLord
 * @date 2017年1月10日
 *
 */
public class Privilege extends ObjectValue {
	private static final long serialVersionUID = 6490470031136198617L;

	private String fId;					//健
	private AuthPriority fPriority;		//权限级别
	private String fFunId;				//功能id
	private String fRoleId;				//角色id
	private PrivilegeType fType;		//权限类型
	
	private String funName;			//功能名称
	private String funParentId;		//功能父id
	private String funDescr;		//功能描述
	
	public String getfId() {
		return fId;
	}
	public void setfId(String fId) {
		this.fId = fId;
	}
	public AuthPriority getfPriority() {
		return fPriority;
	}
	public void setfPriority(AuthPriority fPriority) {
		this.fPriority = fPriority;
	}
	public String getfFunId() {
		return fFunId;
	}
	public void setfFunId(String fFunId) {
		this.fFunId = fFunId;
	}
	public String getfRoleId() {
		return fRoleId;
	}
	public void setfRoleId(String fRoleId) {
		this.fRoleId = fRoleId;
	}
	public PrivilegeType getfType() {
		return fType;
	}
	public void setfType(PrivilegeType fType) {
		this.fType = fType;
	}
	public String getFunName() {
		return funName;
	}
	public void setFunName(String funName) {
		this.funName = funName;
	}
	public String getFunParentId() {
		return funParentId;
	}
	public void setFunParentId(String funParentId) {
		this.funParentId = funParentId;
	}
	public String getFunDescr() {
		return funDescr;
	}
	public void setFunDescr(String funDescr) {
		this.funDescr = funDescr;
	}
	
}
