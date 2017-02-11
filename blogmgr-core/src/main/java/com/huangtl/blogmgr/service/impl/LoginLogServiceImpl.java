package com.huangtl.blogmgr.service.impl;

import com.huangtl.blogmgr.dao.LoginLogDao;
import com.huangtl.blogmgr.model.blog.LoginLog;
import com.huangtl.blogmgr.model.common.Message;
import com.huangtl.blogmgr.service.LoginLogService;

/**
 * 登录日志业务接口 默认实现 
 * @author PraiseLord
 * @date 2017年2月10日
 *
 */
public class LoginLogServiceImpl implements LoginLogService {
	private LoginLogDao loginLogDao;
	
	@Override
	public Message addLoginLog(LoginLog loginLog) {
		int effectRow = this.loginLogDao.insert(loginLog);
		return Message.get(effectRow);
	}
	
	@Override
	public LoginLogDao getDao() {
		return loginLogDao;
	}
	public void setLoginLogDao(LoginLogDao loginLogDao) {
		this.loginLogDao = loginLogDao;
	}
}
