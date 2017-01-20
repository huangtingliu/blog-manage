package com.huangtl.blogmgr.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
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

	@Override
	public JSONObject selectTreePrivilegeMenu(String[] roleIds, AuthPriority[] authPrioritys, String parentId,
			Integer treeDeep) {
		
		if(treeDeep==null){treeDeep=1;}
		if(treeDeep<0){treeDeep=-1;}
		
		if(roleIds==null || roleIds.length==0){
			throw new IllegalArgumentException("roleIds 必须指定");
		}
		if(authPrioritys==null || authPrioritys.length==0){
			throw new IllegalArgumentException("privilegeTypes 必须指定");
		}
		
		JSONObject root = new JSONObject();
		root.put("fId", "root");
		root.put("fName", "root");
		root.put("expanded", treeDeep!=0);
		if(treeDeep==0){return root;}
		
		List<JSONObject> children = treePrivilegeMenuChildren(roleIds, authPrioritys, parentId, treeDeep);
		root.put("children", children);
		
		return root;
	}
	
	private List<JSONObject> treePrivilegeMenuChildren(String[] roleIds, AuthPriority[] authPrioritys, String parentId,
			Integer treeDeep){
		
			List<JSONObject> childrens = new ArrayList<>();
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("roleIds", Arrays.asList(roleIds));
			param.put("authPrioritys", Arrays.asList(authPrioritys));
			param.put("parentId", parentId);
			List<Menu> menus = this.sqlSession.selectList(this.nameSpace+".selectPrivilegeMenu", param);
			
			if(menus.isEmpty()){return childrens;}
			
			if(treeDeep==0){
				childrens.add(new JSONObject());
				return childrens;
			}
			
			for (Menu menu : menus) {
				JSONObject node = new JSONObject();
				node.put("fId", menu.getfId());
				node.put("fName", menu.getfName());
				node.put("authPriority", menu.getAuthPriority());
				List<JSONObject> nextChildrens = treePrivilegeMenuChildren(roleIds, authPrioritys, menu.getfId(), treeDeep-1);
				
				node.put("expanded", (treeDeep-1)!=0);
				if(treeDeep-1 == 0){
					node.put("leaf", nextChildrens.isEmpty());
				}else{
					node.put("leaf", nextChildrens.isEmpty());
					node.put("children", nextChildrens);
				}
				childrens.add(node);
			}
			
			return childrens;
		}
	}
