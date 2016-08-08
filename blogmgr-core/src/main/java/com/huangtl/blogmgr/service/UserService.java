package com.huangtl.blogmgr.service;

import java.util.List;

import com.huangtl.blogmgr.dao.UserDao;
import com.huangtl.blogmgr.dao.where.UserSqlWhere;
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
	Message editUser(User user, UserSqlWhere where);
	
	/**
	 * 批量修改用户，根据fId
	 * @param users
	 * @return
	 */
	Message batchEditUser(List<User> users);
	
	/**
	 * 删除用户
	 * @param uids
	 */
	Message deleteUser(String... uids);
	
}
