package com.huangtl.blogmgr.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.huangtl.blogmgr.core.dao.MybatisDaoAdaptor;
import com.huangtl.blogmgr.dao.RoleDao;
import com.huangtl.blogmgr.dao.where.RoleSqlWhere;
import com.huangtl.blogmgr.dao.where.UserSqlWhere;
import com.huangtl.blogmgr.model.blog.Role;
import com.huangtl.blogmgr.model.blog.dictionary.CommonDictionary.Usability;
import com.huangtl.blogmgr.model.common.TwoTuple;

/**
 * 角色持久化默认实现
 * @author PraiseLord
 * @date 2017年1月6日
 *
 */
public class RoleDaoImpl extends MybatisDaoAdaptor<Role> implements RoleDao {

	/**
	 * 角色-用户关映射命名空间
	 */
	private final String ROLE_USER_NAMESPACE = "com.huangtl.blogmgr.model.blog.RoleUser";
	
	@Override
	public Role selectOne(String fId) {
		if(StringUtils.isBlank(fId)){return null;}
		RoleSqlWhere where =new RoleSqlWhere().fIdEqual(fId);
		List<Role> users = this.selectList(where);
		if(users.isEmpty()){return null;}
		if(users.size()>1){throw new IllegalStateException("存在非法数据，出现了多个角色！");}
		return users.get(0);
	}

	@Override
	public int deleteBatch(String... fIds) {
		throw new UnsupportedOperationException("批量删除未实现");
	}

	@Override
	public int fakeDeleteBatch(String... fIds) {
		if(fIds==null || fIds.length==0){return 0;}
		
		List<Role> entitys = new ArrayList<Role>();
		for (String fId : fIds) {
			Role role = new Role();
			role.setfId(fId);
			role.setfStatus(Usability.DELETE);
			entitys.add(role);
		}
		return this.updateBatch(entitys);
	}

	@Override
	public List<Role> selectByUserWhere(UserSqlWhere where,String... fields) {
		
		if(where==null){where = new UserSqlWhere();}
		for (String field : fields) {
			where.put(field+"_show", true);
		}
		List<Role> lists = this.sqlSession.selectList(ROLE_USER_NAMESPACE+".selectRoles",where);
		return lists;
		
	}

	@Override
	public int insertUserRole(List<TwoTuple<String, String>> userRoles) {
		if(CollectionUtils.isEmpty(userRoles)){
			return 0;
		}
		
		return this.sqlSession.insert(ROLE_USER_NAMESPACE+".insertUserRole", userRoles);
	}

}
