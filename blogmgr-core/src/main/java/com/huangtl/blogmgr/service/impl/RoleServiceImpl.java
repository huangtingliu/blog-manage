package com.huangtl.blogmgr.service.impl;

import com.huangtl.blogmgr.dao.RoleDao;
import com.huangtl.blogmgr.dao.where.RoleSqlWhere;
import com.huangtl.blogmgr.model.common.Message;
import com.huangtl.blogmgr.service.RoleService;
import com.huangtl.blogmgr.model.blog.Role;

/**
 * 权限配置接口默认实现
 * @author PraiseLord
 * @date 2017年1月7日
 *
 */
public class RoleServiceImpl implements RoleService {
	
	private RoleDao roleDao;
	
	@Override
	public RoleDao getDao() {
		return roleDao;
	}

	@Override
	public Message addRole(Role role) {
		int effectRow = this.roleDao.insert(role);
		return Message.get(effectRow, "添加成功！", "添加失败！");
	}

	@Override
	public Message editRole(Role role, RoleSqlWhere where) {
		throw new UnsupportedOperationException("未实现");
	}

	@Override
	public Message fakeDeleteRole(String... roleIds) {
		if(roleIds==null || roleIds.length==0){return Message.error("无效参数");}
		int effectRow = this.roleDao.fakeDeleteBatch(roleIds);
		return Message.get(effectRow, "删除成功！", "删除失败！");
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
}
