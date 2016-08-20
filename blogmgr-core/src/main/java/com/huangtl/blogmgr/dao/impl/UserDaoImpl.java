package com.huangtl.blogmgr.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.huangtl.blogmgr.core.dao.MybatisDaoAdaptor;
import com.huangtl.blogmgr.dao.UserDao;
import com.huangtl.blogmgr.dao.where.UserSqlWhere;
import com.huangtl.blogmgr.model.blog.User;

/**
 * 用户持久化对象默认实现
 * @date 2016年7月4日
 * @author PraiseLord
 * 查询参数默认使用 {@link com.huangtl.blogmgr.dao.where.UserSqlWhere}
 */
public class UserDaoImpl extends MybatisDaoAdaptor<User> implements UserDao {

	@Override
	public User selectOne(String userId) {
		if(StringUtils.isBlank(userId)){return null;}
		UserSqlWhere where = new UserSqlWhere().fIdEqual(userId);
		List<User> users = this.selectList(where);
		if(users.isEmpty()){return null;}
		if(users.size()>1){throw new IllegalStateException("存在非法数据，出现了多个用户");}
		return users.get(0);
	}

}
