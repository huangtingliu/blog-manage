package com.huangtl.blogmgr.service.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.huangtl.blogmgr.dao.RoleDao;
import com.huangtl.blogmgr.dao.UserDao;
import com.huangtl.blogmgr.dao.where.UserSqlWhere;
import com.huangtl.blogmgr.model.blog.Role;
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
	private RoleDao roleDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(StringUtils.isBlank(username)){
			logger.error("无效的用户名：{}",username);
			  throw new UsernameNotFoundException("用户名为空！");
		}
		
		UserSqlWhere where = new UserSqlWhere().fAccountEqual(username);
		List<User> users =  userDao.selectList(where,"fPassword");
		if(users.isEmpty()){
			 throw new UsernameNotFoundException("没有找到名为:"+username+"用户!");
		}
		
		List<Role> roles = roleDao.selectByUserWhere(where);
		if(CollectionUtils.isEmpty(roles)){
			 throw new UsernameNotFoundException("该用户无任何权限！"); 
		}
		User user = users.get(0);
		user.setRoles(roles);
		return user;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
}
