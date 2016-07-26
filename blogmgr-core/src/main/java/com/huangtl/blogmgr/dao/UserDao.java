package com.huangtl.blogmgr.dao;

import com.huangtl.blogmgr.core.dao.MybatisDao;
import com.huangtl.blogmgr.model.blog.User;

/**
 * 后台用户持久化对象
 * @date 2016年7月4日
 * @author PraiseLord
 * 查询参数默认使用 {@link com.huangtl.blogmgr.dao.param.UserParam}
 */
public interface UserDao extends MybatisDao<User> {

}
