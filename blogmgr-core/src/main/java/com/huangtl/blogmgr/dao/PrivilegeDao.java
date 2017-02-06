package com.huangtl.blogmgr.dao;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.huangtl.blogmgr.core.dao.MybatisDao;
import com.huangtl.blogmgr.dao.where.PrivilegeSqlWhere;
import com.huangtl.blogmgr.model.blog.Privilege;

/**
 * 权限持久化接口,查询对象请使用{@code com.huangtl.blogmgr.dao.where.PrivilegeSqlWhere}
 * 固定字段：【fId,fPriority,fFunId,fRoleId,funParentId,funName,funHandler,funGlyph,funUsability】<br>
 * 可选字段：【fType,funType,funOrder,funIcon,funRelevance,funDescr】
 * @author PraiseLord
 * @date 2017年1月10日
 *
 */
public interface PrivilegeDao extends MybatisDao<Privilege> {
	
	/**
	 * 查询权限，返回供extjs树使用
	 * @param where
	 * @return
	 */
	JSONObject selectPrivilegeTree(PrivilegeSqlWhere where,Integer treeDeep);
	
	/**
	 * 根据提供的多个角色，将各个角色所持有的权限合并在一起，合并的Privilege.fPriority 的等级取以高的为准。即合并出来的权限将越来越开放。
	 * @param roleIds
	 * @param where
	 * @return 
	 */
	List<Privilege> selectUnionPrivilege(List<String> roleIds,PrivilegeSqlWhere where,String... fields);
}
