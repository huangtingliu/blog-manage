package com.huangtl.blogmgr.service;

import java.util.List;

import com.huangtl.blogmgr.dao.UserDao;
import com.huangtl.blogmgr.dao.where.UserSqlWhere;
import com.huangtl.blogmgr.model.blog.User;
import com.huangtl.blogmgr.model.common.Message;

/**
 * 后台用户业务接口
 * @date 2016年7月4日
 * @author PraiseLord
 */
public interface UserService {
	/**
	 * 获取持久化对象
	 */
	UserDao getDao();
	
	/**
	 * 添加一名用户<br>
	 * 必填字段：fId,fName,fAccount,fPassword,fPinYin,fCreater,fCreateDate
	 * @param user
	 * @return
	 */
	Message addUser(User user);
	
	/**
	 * 修改用户<br>
	 * 可修改字段：fName,fPassword,fStatus,fPinYin,fDescr,fEditor,fEditDate,fEmail,fPhone,fGender
	 * @param user 修改不为null的字段，否则不修改
	 * @param whereParam 
	 */
	Message editUser(User user, UserSqlWhere where);
	
	/**
	 * 根据fId,批量修改用户<br>
	 * 可修改字段：fName,fPassword,fStatus,fPinYin,fDescr,fEditor,fEditDate,fEmail,fPhone,fGender
	 * @param users
	 */
	Message editBatchUser(List<User> users);
	
	/**
	 * 删除用户
	 * @param uids
	 */
	Message deleteUser(String... uids);
	
}
