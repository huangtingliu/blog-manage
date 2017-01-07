package com.huangtl.blogmgr.dao.where;

import com.huangtl.blogmgr.model.blog.dictionary.CommonDictionary.Usability;

@SuppressWarnings("serial")
public class RoleSqlWhere extends SqlWhere {
	/**
	 * 指定角色id为
	 * @param roleId
	 */
	public RoleSqlWhere fIdEqual(String roleId){
		this.put("fId_eq", roleId);
		return this;
	}
	/**
	 * 指定角色id存在于
	 * @param roleIds
	 * @return
	 */
	public RoleSqlWhere fIdIn(String... roleIds){
		if(roleIds.length==0){return this;}
		this.put("fId_in", roleIds);
		return this;
	}
	/**
	 * 角色状态为
	 * @param fStatus
	 * @return
	 */
	public RoleSqlWhere fStatusEqual(Usability fStatus){
		this.put("fStatus_eq", fStatus);
		return this;
	}
	
	/**
	 * 角色状态不为
	 * @param fStatus
	 * @return
	 */
	public RoleSqlWhere fStatusNotEqual(Usability fStatus){
		this.put("fStatus_ne", fStatus);
		return this;
	}
	
	/**
	 * 角色名称前部匹配
	 * @param fName
	 * @return
	 */
	public RoleSqlWhere fNameLike(String fName){
		this.like("fName_like", fName);
		return this;
	}
	/**
	 * 角色编码为
	 * @param fCode
	 * @return
	 */
	public RoleSqlWhere fCodeEqual(Integer fCode){
		this.put("fCode_eq", fCode);
		return this;
	}
	
}
