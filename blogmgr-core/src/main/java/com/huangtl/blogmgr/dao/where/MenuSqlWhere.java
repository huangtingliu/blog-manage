package com.huangtl.blogmgr.dao.where;

import com.huangtl.blogmgr.model.blog.dictionary.CommonDictionary.Usability;
import com.huangtl.blogmgr.model.blog.dictionary.MenuType;

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
	public MenuSqlWhere fIdEqual(String menuId){
		this.put("fId_eq", menuId);
		return this;
	}
	
	/**
	 * fId 存在于
	 */
	public MenuSqlWhere fIdIn(String... menuIds){
		if(menuIds.length==0){return this;}
		
		this.put("fId_in", menuIds);
		return this;
	}
	
	/**
	 * fParentId 等于
	 * @param parentId
	 * @return
	 */
	public MenuSqlWhere fParentIdEqual(String parentId){
		this.put("fParentId_eq", parentId);
		return this;
	}
	
	/**
	 * fType 等于
	 * @param type
	 * @return
	 */
	public MenuSqlWhere fTypeEqual(MenuType type){
		this.put("fType_eq", type);
		return this;
	}
	
	/**
	 * 可用性等于
	 * @param usability
	 * @return
	 */
	public MenuSqlWhere fUsabilityEqual(Usability usability){
		this.put("fUsability_eq", usability);
		return this;
	}
}
