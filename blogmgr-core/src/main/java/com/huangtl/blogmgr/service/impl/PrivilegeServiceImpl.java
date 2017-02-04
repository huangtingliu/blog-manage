package com.huangtl.blogmgr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

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
	
	@CacheEvict(value="privilegeCache",key="#privilege.fRoleId")
	@Override
	public Message addPrivilege(Privilege privilege) {
		// TODO Auto-generated method stub
		return null;
	}

	@CacheEvict(value="privilegeCache",allEntries=true)
	@Override
	public Message deletePrivilege(PrivilegeSqlWhere where) {
		// TODO Auto-generated method stub
		return null;
	}

	@CacheEvict(value="privilegeCache",allEntries=true)
	@Override
	public Message eidtPrivilege(Privilege privilege, PrivilegeSqlWhere where) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Cacheable(value="privilegeCache",key="#roleId") 
	@Override
	public List<Privilege> queryPrivilegesByRoleId(String roleId){
		if(StringUtils.isBlank(roleId)){return new ArrayList<>();}
		
		PrivilegeSqlWhere where = new PrivilegeSqlWhere().fRoleIdEqual(roleId);
		return this.privilegeDao.selectList(where);
	}

	@Override
	public PrivilegeDao getDao() {
		return this.privilegeDao;
	}

	
	@CacheEvict(value="privilegeCache",allEntries=true)
	@Override
	public Message editBatch(List<Privilege> privileges) {
		int efftectRow = this.privilegeDao.updateBatch(privileges);
		return Message.get(efftectRow, "修改成功。", "修改失败！");
	}
	
	public void setPrivilegeDao(PrivilegeDao privilegeDao) {
		this.privilegeDao = privilegeDao;
	}
}
