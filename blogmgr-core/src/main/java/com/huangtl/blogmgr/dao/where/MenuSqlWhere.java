package com.huangtl.blogmgr.dao.where;


/**
 * 菜单查询参数集
 * @date 2016年6月30日
 * @author PraiseLord
 */
@SuppressWarnings("serial")
public class MenuSqlWhere extends SqlWhere {
	
	public MenuSqlWhere idEqual(String menuId){
		this.put("fId_eq", menuId);
		return this;
	}
	
	public MenuSqlWhere parentIdEqual(String parentId){
		this.put("fParentId_eq", parentId);
		return this;
	}
	
	
	
}
