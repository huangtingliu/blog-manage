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

	/*
	 	{
			"fAccount":"ouiogyui",
			"fCreateDate":1469447144000,
			"fCreater":"root",
			"fEmail":"",
			"fGender":"MALE",
			"fId":"09dbccec890a4fa8bcd6b71f360551f4",
			"fName":"uoyui",
			"fPhone":"",
			"fStatus":"ENABLE"
		}
	 */
	@Override
	public User selectOne(String fId) {
		if(StringUtils.isBlank(fId)){return null;}
		UserSqlWhere where = new UserSqlWhere().fIdEqual(fId);
		List<User> users = this.selectList(where);
		if(users.isEmpty()){return null;}
		if(users.size()>1){throw new IllegalStateException("存在非法数据，出现了多个用户");}
		return users.get(0);
	}

	@Override
	public int deleteBatch(String... fIds) {
		if(fIds.length==0){return 0;}
		UserSqlWhere where = new UserSqlWhere().fIdIn(fIds);
		return this.delete(where);
	}
}
