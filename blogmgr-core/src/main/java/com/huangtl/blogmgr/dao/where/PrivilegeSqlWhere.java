package com.huangtl.blogmgr.dao.where;

import com.huangtl.blogmgr.model.blog.dictionary.AuthPriority;
import com.huangtl.blogmgr.model.blog.dictionary.PrivilegeType;

/**
 * 权限sql查询条件
 * @author PraiseLord
 * @date 2017年1月10日
 *
 */
@SuppressWarnings("serial")
public class PrivilegeSqlWhere extends SqlWhere {
	/**
	 * fId 等于
	 * @param privilegeId
	 * @return
	 */
	public PrivilegeSqlWhere fIdEqual(String privilegeId){
		this.put("fId_eq", privilegeId);
		return this;
	}
	
	/**
	 * 类型等于
	 * @param fType
	 * @return
	 */
	public PrivilegeSqlWhere fTypeEqual(PrivilegeType fType){
		this.put("fType_eq", fType);
		return this;
	}
	
	/**
	 * 功能id等于
	 * @param fFunId
	 * @return
	 */
	public PrivilegeSqlWhere fFunIdEqual(String fFunId){
		this.put("fFunId_eq", fFunId);
		return this;
	}
	
	/**
	 * 角色id等于
	 * @param fRoleId
	 * @return
	 */
	public PrivilegeSqlWhere fRoleIdEqual(String fRoleId){
		this.put("fRoleId_eq", fRoleId);
		return this;
	}
	
	/**
	 * 权限级别等于
	 * @param fPriority
	 * @return
	 */
	public PrivilegeSqlWhere fPriorityEqual(AuthPriority fPriority){
		this.put("fPriority_eq", fPriority);
		return this;
	}
}
