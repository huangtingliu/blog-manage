package com.huangtl.blogmgr.model.blog;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;

import com.huangtl.blogmgr.model.blog.dictionary.CommonDictionary.Usability;
import com.huangtl.blogmgr.model.common.ObjectValue;

/**
 * 系统角色域 
 * @author PraiseLord
 * @date 2017年1月6日
 *
 */
public class Role extends ObjectValue implements GrantedAuthority {
	private static final long serialVersionUID = 6238056902579982661L;

	private String fId;				//键  必须
	private String fName;			//角色名称 必须
	private String fDescr;			//角色描述	
	private Integer fCode;			//角色编码  必须
	private Usability fStatus;		//角色状态，可用/不可用
	
	@NotBlank(message = "主键为空")
	public String getfId() {
		return fId;
	}
	public void setfId(String fId) {
		this.fId = fId;
	}
	@NotBlank(message = "角色名称为空")
	@Length(message = "角色名称长度在6-20个字",max=20,min=6)
	@Pattern(regexp = "^ROLE_[a-zA-Z_]{1,15}$", message = "角色名称以ROLE_开头,由字母或下划线组成")
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	@Length(message="角色描述小于200字",max=200)
	public String getfDescr() {
		return fDescr;
	}
	public void setfDescr(String fDescr) {
		this.fDescr = fDescr;
	}
	public Integer getfCode() {
		return fCode;
	}
	public void setfCode(Integer fCode) {
		this.fCode = fCode;
	}
	@NotNull(message="角色状态为空")
	public Usability getfStatus() {
		return fStatus;
	}
	public void setfStatus(Usability fStatus) {
		this.fStatus = fStatus;
	}
	@Override
	public String getAuthority() {
		return getfName();
	}
}