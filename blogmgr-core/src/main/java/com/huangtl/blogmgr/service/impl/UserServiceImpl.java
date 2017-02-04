package com.huangtl.blogmgr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huangtl.blogmgr.dao.RoleDao;
import com.huangtl.blogmgr.dao.UserDao;
import com.huangtl.blogmgr.dao.where.UserSqlWhere;
import com.huangtl.blogmgr.model.blog.Role;
import com.huangtl.blogmgr.model.blog.User;
import com.huangtl.blogmgr.model.blog.dictionary.UserStatus;
import com.huangtl.blogmgr.model.common.Message;
import com.huangtl.blogmgr.model.common.TwoTuple;
import com.huangtl.blogmgr.service.UserService;

/**
 * 后台用户业务层接口 - 默认实现
 * @date 2016年7月4日
 * @author PraiseLord
 */
public class UserServiceImpl implements UserService {
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private UserDao userDao;
	private RoleDao roleDao;
	
	@Override
	public UserDao getDao() {
		return userDao;
	}

	/* 
	 * 1. 添加用户基础信息
	 * 2. 为用户添加权限
	 */
	@Override
	public Message addUser(User user) {
		logger.debug("添加用户{}",user);
		int effectRow = this.userDao.insert(user);
		
		Message.get(effectRow).throwIfError("系统异常,用户添加失败！");;
		
		//添加权限
		List<TwoTuple<String, String>> userRoles = new ArrayList<>();
		for (Role role : user.getRoles()) {
			userRoles.add(new TwoTuple<String, String>(user.getfId(), role.getfId()));
		}
		
		effectRow = this.roleDao.insertUserRole(userRoles);
		
		Message.get(effectRow).throwIfError("系统异常,用户角色添加失败！");;
		
		return Message.get(effectRow, "添加成功!", "添加失败!");
	}

	@Override
	public Message editUser(User user, UserSqlWhere where) {
		int effectRow = this.userDao.update(user, where);
		return Message.get(effectRow, "修改成功!", "修改失败!");
	}

	@Override
	public Message editBatchUser(List<User> users) {
		if(CollectionUtils.isEmpty(users)){return Message.error("参数为空");}
		
		int effectRow = this.userDao.updateBatch(users);
		Message message = Message.get(effectRow,"修改成功","修改失败");
		message.setAnnex(users.size());
		return message;
	}

	@Override
	public Message deleteUser(String... uids) {
		if(uids.length==0){return Message.error("未指定删除对象!");}
		int effectRow = this.userDao.deleteBatch(uids);
		return Message.get(effectRow, "成功删除"+uids.length+"个用户!", "删除失败!");
	}
	
	@Override
	public Message fakeDeleteUser(String... uids) {
		if(uids.length==0){return Message.error("未指定删除对象!");}
		
		List<User> entitys = new ArrayList<>();
		for (String userId : uids) {
			User user = new User();
			user.setfId(userId);
			user.setfStatus(UserStatus.DELETE);
			entitys.add(user);
		}
		
		int effectRow = this.userDao.updateBatch(entitys);
		
		return Message.get(effectRow, "成功删除"+uids.length+"个用户!", "删除失败!");
	}
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	
}
