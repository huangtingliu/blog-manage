package com.huangtl.blogmgr.dao;

import com.huangtl.blogmgr.core.dao.MybatisDao;
import com.huangtl.blogmgr.model.blog.User;

/**
 * 后台用户持久化对象
 * @date 2016年7月4日
 * @author PraiseLord
 * 查询参数默认使用 {@link com.huangtl.blogmgr.dao.where.UserSqlWhere}
 */
public interface UserDao extends MybatisDao<User> {
	/**
	 * 根据用户id查询用户
	 * @param fId
	 * @return
	 */
	User selectOne(String fId);
	
	/**
	 * 批量删除用户
	 * @param fIds
	 * @return
	 */
	int deleteBatch(String... fIds);
}
