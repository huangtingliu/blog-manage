package com.huangtl.blogmgr.dao.where;

import com.huangtl.blogmgr.model.blog.type.MenuType;

/**
 * 菜单sql查询参数
 * @date 2016年6月30日
 * @author PraiseLord
 */
@SuppressWarnings("serial")
public class MenuSqlWhere extends SqlWhere {
	
	/**
	 * fId 等于
	 * @param menuId
	 * @return
	 */
	public MenuSqlWhere idEqual(String menuId){
		this.put("fId_eq", menuId);
		return this;
	}
	
	/**
	 * fParentId 等于
	 * @param parentId
	 * @return
	 */
	public MenuSqlWhere parentIdEqual(String parentId){
		this.put("fParentId_eq", parentId);
		return this;
	}
	
	/**
	 * fType 等于
	 * @param type
	 * @return
	 */
	public MenuSqlWhere typeEqual(MenuType type){
		this.put("fType_eq", type);
		return this;
	}
	
	
}
