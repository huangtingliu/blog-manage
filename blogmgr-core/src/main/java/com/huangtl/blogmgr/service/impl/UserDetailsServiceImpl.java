package com.huangtl.blogmgr.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.huangtl.blogmgr.dao.UserDao;
import com.huangtl.blogmgr.dao.where.SqlWhere;
import com.huangtl.blogmgr.dao.where.UserSqlWhere;
import com.huangtl.blogmgr.model.blog.User;



/**
 * @author PraiseLord
 * @date 2017年1月1日
 * 
 * spring security 用户管理，加载
 */
public class UserDetailsServiceImpl implements UserDetailsService {

	private final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		if(StringUtils.isBlank(arg0)){
			logger.error("无效的用户名：{}",arg0);
			  throw new UsernameNotFoundException("无效的用户名,无法做为查询条件！");
		}
		
		SqlWhere where = new UserSqlWhere().fAccountEqual(arg0);
		List<User> users =  userDao.selectList(where);
		
		if(users.isEmpty()){
			 throw new UsernameNotFoundException("没有找到用户为:"+arg0+"用户!");
		}
		
		//TODO 权限载入
		
		return users.get(0);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
