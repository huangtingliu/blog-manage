package com.huangtl.blogmgr.service;

import java.util.List;

import com.huangtl.blogmgr.dao.PrivilegeDao;
import com.huangtl.blogmgr.dao.where.PrivilegeSqlWhere;
import com.huangtl.blogmgr.model.blog.Privilege;
import com.huangtl.blogmgr.model.common.Message;

/**
 * 权限业务层接口
 * @author PraiseLord
 * @date 2017年1月10日
 *
 */
public interface PrivilegeService {
	
	/**
	 * 获取权限持久化对象
	 * @return
	 */
	PrivilegeDao getDao();
	
	/**
	 * 添加权限
	 * @param privilege
	 * @return
	 */
	Message addPrivilege(Privilege privilege);
	
	/**
	 * 删除指定的权限
	 * @param privilegeIds
	 * @return
	 */
	Message deletePrivilege(PrivilegeSqlWhere where);
	
	/**
	 * 修改权限
	 * @param privilege
	 * @param where
	 * @return
	 */
	Message eidtPrivilege(Privilege privilege,PrivilegeSqlWhere where);
	
	/**
	 * 批量修改权限
	 * @param privileges
	 * @return
	 */
	Message editBatch(List<Privilege> privileges);
	
	
	/**
	 * 根据角色id查询权限
	 * @param roleId  角色id
	 * @param fields  额外展示的字段，默认字段参见 PrivilegeDao 注解
	 * @return
	 */
	List<Privilege> queryPrivilegesByRoleId(String roleId,String... fields);
}
