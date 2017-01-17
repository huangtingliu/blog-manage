package com.huangtl.blogmgr.dao.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huangtl.blogmgr.core.dao.MybatisDaoAdaptor;
import com.huangtl.blogmgr.dao.MenuDao;
import com.huangtl.blogmgr.dao.where.MenuSqlWhere;
import com.huangtl.blogmgr.model.blog.Menu;
import com.huangtl.blogmgr.model.blog.dictionary.AuthPriority;
import com.huangtl.blogmgr.model.extjs.TreeNode;

/**
 * 菜单持久化接口 -  默认实现<br>
 * @date 2016年6月30日
 * @author PraiseLord
 */
public class MenuDaoImpl extends MybatisDaoAdaptor<Menu> implements MenuDao {
	private final static String  MENU_TREE_NAMESPACE = "com.huangtl.blogmgr.model.blog.tree.Menu";

	@Override
	public List<TreeNode> selectTreeNodes(MenuSqlWhere where) {
		return this.sqlSession.selectList(MENU_TREE_NAMESPACE+".selectTreeNodes", where);
	}

	@Override
	public List<Menu> selectPrivilegeMenu(String[] roleIds, AuthPriority[] authPrioritys, String parentId,
			String menuId) {
		
		Map<String, Object> param = new HashMap<String, Object>();
		if(roleIds==null || roleIds.length==0){
			throw new IllegalArgumentException("roleIds 必须指定");
		}
		if(authPrioritys==null || authPrioritys.length==0){
			throw new IllegalArgumentException("privilegeTypes 必须指定");
		}
		
		param.put("roleIds", Arrays.asList(roleIds));
		param.put("authPrioritys", Arrays.asList(authPrioritys));
		param.put("parentId", parentId);
		param.put("menuId", menuId);
		
		return this.sqlSession.selectList(this.nameSpace+".selectPrivilegeMenu", param);
	}

	
}
