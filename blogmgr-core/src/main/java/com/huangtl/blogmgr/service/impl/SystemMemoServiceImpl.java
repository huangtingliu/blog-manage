package com.huangtl.blogmgr.service.impl;

import com.huangtl.blogmgr.dao.SystemMemoDao;
import com.huangtl.blogmgr.dao.where.SystemMemoWhere;
import com.huangtl.blogmgr.model.blog.SystemMemo;
import com.huangtl.blogmgr.model.common.Message;
import com.huangtl.blogmgr.service.SystemMemoService;

public class SystemMemoServiceImpl implements SystemMemoService {
	
	private SystemMemoDao systemMemoDao;
	
	@Override
	public SystemMemoDao getDao() {
		return systemMemoDao;
	}

	@Override
	public Message addMemo(SystemMemo memo) {
		systemMemoDao.insert(memo);
		return Message.success("添加成功");
	}
	
	@Override
	public Message editMemo(SystemMemo memo,SystemMemoWhere where) {
		systemMemoDao.update(memo, where);
		return null;
	}

	@Override
	public Message deleteMemo(String... ids) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setSystemMemoDao(SystemMemoDao systemMemoDao) {
		this.systemMemoDao = systemMemoDao;
	}

	
}
