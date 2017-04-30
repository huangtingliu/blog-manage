package com.huangtl.blogmgr.dao.where;

import com.huangtl.blogmgr.core.dao.Operator;

/**
 * 系统备忘录操作条件
 * @author Canaan
 * @date 2017年4月29日
 *
 */
public class SystemMemoWhere extends SqlWhere {
	private static final long serialVersionUID = -526507384266807329L;
	
	public SystemMemoWhere fIdEqual(String fId){
		this.put(Operator.eq.eval("fId"), fId);
		return this;
	}
	
	public SystemMemoWhere fIdIn(String... fIds){
		this.put(Operator.in.eval("fId"), fIds);
		return this;
	}
	
}
