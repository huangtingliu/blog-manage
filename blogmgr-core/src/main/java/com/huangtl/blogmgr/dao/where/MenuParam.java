package com.huangtl.blogmgr.dao.where;


/**
 * 菜单查询参数集
 * @date 2016年6月30日
 * @author PraiseLord
 */
@SuppressWarnings("serial")
public class MenuParam extends SqlWhere {
	
	public MenuParam idEqual(String menuId){
		this.put("menuId", menuId);
		return this;
	}
	
	public MenuParam parentIdEqual(String parentId){
		this.put("parentId", parentId);
		return this;
	}
	
	
	
}
