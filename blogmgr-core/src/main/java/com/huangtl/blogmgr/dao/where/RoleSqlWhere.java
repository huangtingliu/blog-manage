package com.huangtl.blogmgr.dao.where;

import com.huangtl.blogmgr.core.dao.Operator;
import com.huangtl.blogmgr.model.blog.dictionary.CommonDictionary.Usability;

@SuppressWarnings("serial")
public class RoleSqlWhere extends SqlWhere {
	/**
	 * 指定角色id为
	 * @param roleId
	 */
	public RoleSqlWhere fIdEqual(String roleId){
		this.put(Operator.eq.eval("fId"), roleId);
		return this;
	}
	
	/**
	 * 查询的角色为用户所持有的权限
	 * @return
	 */
	public RoleSqlWhere fromUser(String userId){
		this.put(Operator.eq.eval("userId"), userId);
		return this;
	}
	
	/**
	 * 查询的角色不为用户所持有的权限
	 * @param userId
	 * @return
	 */
	public RoleSqlWhere notFromUser(String userId){
		this.put(Operator.ne.eval("userId"), userId);
		return this;
	}
	
	
	/**
	 * 指定角色id存在于
	 * @param roleIds
	 * @return
	 */
	public RoleSqlWhere fIdIn(String... roleIds){
		this.put(Operator.in.eval("fId"), roleIds);
		return this;
	}
	/**
	 * 角色状态为
	 * @param fStatus
	 * @return
	 */
	public RoleSqlWhere fStatusEqual(Usability fStatus){
		this.put(Operator.eq.eval("fStatus"), fStatus);
		return this;
	}
	
	/**
	 * 角色状态不为
	 * @param fStatus
	 * @return
	 */
	public RoleSqlWhere fStatusNotEqual(Usability fStatus){
		this.put(Operator.ne.eval("fStatus"), fStatus);
		return this;
	}
	
	/**
	 * 角色名称前部匹配
	 * @param fName
	 * @return
	 */
	public RoleSqlWhere fNameLike(String fName){
		this.like(Operator.like.eval("fName"), fName);
		return this;
	}
	/**
	 * 角色编码为
	 * @param fCode
	 * @return
	 */
	public RoleSqlWhere fCodeEqual(Integer fCode){
		this.put(Operator.eq.eval("fCode"), fCode);
		return this;
	}
	
}
