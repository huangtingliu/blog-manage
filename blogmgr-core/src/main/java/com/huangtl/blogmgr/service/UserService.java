package com.huangtl.blogmgr.service;

import com.huangtl.blogmgr.dao.UserDao;

/**
 * 后台用户业务层接口
 * @date 2016年7月4日
 * @author PraiseLord
 */
public interface UserService {
	/**
	 * 获取持久化对象
	 */
	UserDao getDao();
}
