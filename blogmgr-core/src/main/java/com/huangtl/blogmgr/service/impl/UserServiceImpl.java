package com.huangtl.blogmgr.service.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huangtl.blogmgr.dao.UserDao;
import com.huangtl.blogmgr.dao.where.UserSqlWhere;
import com.huangtl.blogmgr.exceptoin.ServiceException;
import com.huangtl.blogmgr.model.blog.User;
import com.huangtl.blogmgr.model.common.Message;
import com.huangtl.blogmgr.service.UserService;

/**
 * 后台用户业务层接口 - 默认实现
 * @date 2016年7月4日
 * @author PraiseLord
 */
public class UserServiceImpl implements UserService {
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private UserDao userDao;
	
	@Override
	public UserDao getDao() {
		return userDao;
	}

	@Override
	public Message addUser(User user) {
		logger.debug("添加用户{}",user);
		int effectRow = this.userDao.insert(user);
		return Message.get(effectRow, "添加成功!", "添加失败!");
	}

	@Override
	public Message editUser(User user, UserSqlWhere where) {
		int effectRow = this.userDao.update(user, where);
		return Message.get(effectRow, "修改成功!", "修改失败!");
	}

	@Override
	public Message batchEditUser(List<User> users) {
		if(CollectionUtils.isEmpty(users)){return Message.error("参数为空");}
		UserSqlWhere sqlWhere = new UserSqlWhere();
		int effectRow = 0;
		for (User user : users) {
			if(StringUtils.isEmpty(user.getfId())){throw new ServiceException("无效参数：\n"+user.toString());}
			sqlWhere.idEqual(user.getfId());
			effectRow = this.userDao.update(user, sqlWhere);
			if(effectRow==0){throw new ServiceException("更新失败！\n"+user.toString());}
		}
		return Message.success("修改成功");
	}

	@Override
	public Message deleteUser(String... uids) {
		if(uids==null || uids.length==0){
			return Message.error("未指定删除对象!");
		}
		int effectRow = this.userDao.deleteBatch(Arrays.asList(uids));
		return Message.get(effectRow, "成功删除"+uids.length+"个用户!", "删除失败!");
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
