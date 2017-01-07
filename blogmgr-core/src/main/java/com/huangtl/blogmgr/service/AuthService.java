package com.huangtl.blogmgr.service;

import com.huangtl.blogmgr.dao.RoleDao;
import com.huangtl.blogmgr.dao.where.RoleSqlWhere;
import com.huangtl.blogmgr.model.blog.Role;
import com.huangtl.blogmgr.model.common.Message;

/**
 * 权限配置业务层接口
 * @author PraiseLord
 * @date 2017年1月7日
 *
 */
public interface AuthService {
	
	/**
	 * 取得角色持久化对象
	 * @return
	 */
	RoleDao getDao();
	
	/**
	 * 新增一个角色
	 * @param role
	 * @return
	 */
	Message addRole(Role role);
	
	/**
	 * 修改角色
	 * @param role
	 * @param where
	 * @return
	 */
	Message editRole(Role role, RoleSqlWhere where);
	
	/**
	 * 伪删除角色
	 * @param roleId
	 * @return
	 */
	Message fakeDeleteRole(String... roleId);
}
