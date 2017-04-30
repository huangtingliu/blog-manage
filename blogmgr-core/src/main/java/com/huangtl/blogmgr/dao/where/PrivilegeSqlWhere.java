package com.huangtl.blogmgr.dao.where;

import com.huangtl.blogmgr.core.dao.Operator;
import com.huangtl.blogmgr.model.blog.dictionary.AuthPriority;
import com.huangtl.blogmgr.model.blog.dictionary.FunctionType;
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
		this.put(Operator.eq.eval("fId"), privilegeId);
		return this;
	}
	
	/**
	 * 类型等于
	 * @param fType
	 * @return
	 */
	public PrivilegeSqlWhere fTypeEqual(PrivilegeType fType){
		this.put(Operator.eq.eval("fType"), fType);
		return this;
	}
	
	/**
	 * 功能id等于
	 * @param fFunId
	 * @return
	 */
	public PrivilegeSqlWhere fFunIdEqual(String fFunId){
		this.put(Operator.eq.eval("fFunId"), fFunId);
		return this;
	}
	
	/**
	 * 角色id等于
	 * @param fRoleId
	 * @return
	 */
	public PrivilegeSqlWhere fRoleIdEqual(String fRoleId){
		this.put(Operator.eq.eval("fRoleId"), fRoleId);
		return this;
	}
	
	/**
	 * 角色id存在于
	 * @param fRoleIds
	 * @return
	 */
	public PrivilegeSqlWhere fRoleIdIn(String... fRoleIds){
		if(fRoleIds.length==0){return this;}
		this.put(Operator.in.eval("fRoleId"), fRoleIds);
		return this;
	}
	
	/**
	 * 权限级别等于
	 * @param fPriority
	 * @return
	 */
	public PrivilegeSqlWhere fPriorityEqual(AuthPriority fPriority){
		this.put(Operator.eq.eval("fPriority"), fPriority);
		return this;
	}
	
	/**
	 * 权限级别 在
	 * @param fPrioritys
	 * @return
	 */
	public PrivilegeSqlWhere fPriorityIn(AuthPriority... fPrioritys){
		this.put(Operator.in.eval("fPriority"), fPrioritys);
		return this;
	}
	
	public PrivilegeSqlWhere fPriorityNotEqual(AuthPriority fPriority){
		this.put(Operator.ne.eval("fPriority"), fPriority);
		return this;
	}
	
	/**
	 * 功能类型等于
	 * @param funType
	 * @return
	 */
	public PrivilegeSqlWhere funTypeEqual(FunctionType funType){
		this.put(Operator.eq.eval("funType"), funType);
		return this;
	}
	
	/**
	 * 功能父id等于
	 * @param funParentId
	 * @return
	 */
	public PrivilegeSqlWhere funParentIdEqual(String funParentId){
		this.put(Operator.eq.eval("funParentId"), funParentId);
		return this;
	}
}
