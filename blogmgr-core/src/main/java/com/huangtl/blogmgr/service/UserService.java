package com.huangtl.blogmgr.service;

import com.huangtl.blogmgr.dao.UserDao;
import com.huangtl.blogmgr.dao.param.UserParam;
import com.huangtl.blogmgr.model.blog.User;
import com.huangtl.blogmgr.model.common.Message;

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
	
	/**
	 * 添加一名用户
	 * @param user
	 * @return
	 */
	Message addUser(User user);
	
	/**
	 * 修改用户
	 * @param user
	 * @param whereParam
	 */
	Message eidtUser(User user, UserParam whereParam);
	
	/**
	 * 删除用户
	 * @param uids
	 */
	Message deleteUser(String... uids);
	
}
