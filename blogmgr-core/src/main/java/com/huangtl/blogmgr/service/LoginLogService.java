package com.huangtl.blogmgr.service;

import com.huangtl.blogmgr.dao.LoginLogDao;
import com.huangtl.blogmgr.model.blog.LoginLog;
import com.huangtl.blogmgr.model.common.Message;

/**
 * 登录日志业务接口
 * @author PraiseLord
 * @date 2017年2月10日
 *
 */
public interface LoginLogService {
	LoginLogDao getDao();
	
	/**
	 * 新增一个登录日志
	 * @param loginLog
	 * @return
	 */
	Message addLoginLog(LoginLog loginLog);
}
