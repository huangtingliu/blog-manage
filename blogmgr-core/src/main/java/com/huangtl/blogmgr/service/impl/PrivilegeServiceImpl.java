package com.huangtl.blogmgr.service.impl;

import java.util.List;

import com.huangtl.blogmgr.dao.PrivilegeDao;
import com.huangtl.blogmgr.dao.where.PrivilegeSqlWhere;
import com.huangtl.blogmgr.model.blog.Privilege;
import com.huangtl.blogmgr.model.common.Message;
import com.huangtl.blogmgr.service.PrivilegeService;

/**
 * 权限业务层接口默认实现 
 * @author PraiseLord
 * @date 2017年1月10日
 *
 */
public class PrivilegeServiceImpl implements PrivilegeService {
	
	private PrivilegeDao privilegeDao;
	
	@Override
	public Message addPrivilege(Privilege privilege) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message deletePrivilege(PrivilegeSqlWhere where) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message eidtPrivilege(Privilege privilege, PrivilegeSqlWhere where) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setPrivilegeDao(PrivilegeDao privilegeDao) {
		this.privilegeDao = privilegeDao;
	}

	@Override
	public PrivilegeDao getDao() {
		return this.privilegeDao;
	}

	@Override
	public Message editBatch(List<Privilege> privileges) {
		int efftectRow = this.privilegeDao.updateBatch(privileges);
		return Message.get(efftectRow, "修改成功。", "修改失败！");
	}
	
}
