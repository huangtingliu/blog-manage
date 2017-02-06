package com.huangtl.blogmgr.dao.where;

import com.huangtl.blogmgr.core.dao.Operator;
import com.huangtl.blogmgr.model.blog.dictionary.CommonDictionary.Usability;
import com.huangtl.blogmgr.model.blog.dictionary.FunctionType;

/**
 * 系统功能sql查询参数
 * @date 2016年6月30日
 * @author PraiseLord
 */
@SuppressWarnings("serial")
public class FunctionSqlWhere extends SqlWhere {
	
	/**
	 * fId 等于
	 * @param functionId
	 * @return
	 */
	public FunctionSqlWhere fIdEqual(String functionId){
		this.put(Operator.eq.eval("fId"), functionId);
		return this;
	}
	
	/**
	 * fId 存在于
	 */
	public FunctionSqlWhere fIdIn(String... functionIds){
		if(functionIds.length==0){return this;}
		
		this.put(Operator.in.eval("fId"), functionIds);
		return this;
	}
	
	/**
	 * fParentId 等于
	 * @param parentId
	 * @return
	 */
	public FunctionSqlWhere fParentIdEqual(String parentId){
		this.put(Operator.eq.eval("fParentId"), parentId);
		return this;
	}
	
	/**
	 * fType 等于
	 * @param type
	 * @return
	 */
	public FunctionSqlWhere fTypeEqual(FunctionType type){
		this.put(Operator.eq.eval("fType"), type);
		return this;
	}
	
	/**
	 * 可用性等于
	 * @param usability
	 * @return
	 */
	public FunctionSqlWhere fUsabilityEqual(Usability usability){
		this.put(Operator.eq.eval("fUsability"), usability);
		return this;
	}
}
