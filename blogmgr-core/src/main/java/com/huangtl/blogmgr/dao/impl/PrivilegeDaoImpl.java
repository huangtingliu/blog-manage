package com.huangtl.blogmgr.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.huangtl.blogmgr.core.dao.MybatisDaoAdaptor;
import com.huangtl.blogmgr.dao.PrivilegeDao;
import com.huangtl.blogmgr.dao.where.PrivilegeSqlWhere;
import com.huangtl.blogmgr.model.blog.Privilege;

/**
 * 权限持久化对象默认实现 
 * @author PraiseLord
 * @date 2017年1月10日
 *
 */
public class PrivilegeDaoImpl extends  MybatisDaoAdaptor<Privilege> implements PrivilegeDao {

	@Override
	public JSONObject selectPrivilegeTree(PrivilegeSqlWhere where,Integer treeDeep) {
		if(treeDeep==null){treeDeep=1;}
		if(treeDeep<0){treeDeep=-1;}
		
		JSONObject root = new JSONObject();
		root.put("text", ".");
		root.put("expanded", treeDeep!=0);
		List<JSONObject> children = privilegeTreeChildren(where, treeDeep);
		root.put("children", children);
		return root;
	}
	
	private List<JSONObject> privilegeTreeChildren(PrivilegeSqlWhere where,Integer treeDeep){
		List<JSONObject> childrens = new ArrayList<>();
		
		List<Privilege> privileges = this.selectList(where);
		
		if(privileges.isEmpty()){return childrens;}
		
		if(treeDeep==0){
			childrens.add(new JSONObject());
			return childrens;
		}
		
		for (Privilege privilege : privileges) {
			JSONObject node = new JSONObject();
			node.put("fId", privilege.getfId());
			node.put("funName", privilege.getFunName());
			node.put("fPriority", privilege.getfPriority());
			node.put("fType", privilege.getfType());
			node.put("funDescr", privilege.getFunDescr());
			node.put("funParentId", privilege.getFunParentId());
			node.put("fFunId", privilege.getfFunId());
			where.funParentIdEqual(privilege.getfFunId());
			List<JSONObject> nextChildrens =privilegeTreeChildren(where,treeDeep-1);
			
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
