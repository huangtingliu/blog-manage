package com.huangtl.blogmgr.service.impl;

import com.huangtl.blogmgr.dao.UserDao;
import com.huangtl.blogmgr.service.UserService;

/**
 * 后台用户业务层接口 - 默认实现
 * @date 2016年7月4日
 * @author PraiseLord
 */
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	@Override
	public UserDao getDao() {
		return userDao;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
