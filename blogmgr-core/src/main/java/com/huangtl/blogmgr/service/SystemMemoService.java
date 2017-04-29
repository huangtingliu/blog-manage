package com.huangtl.blogmgr.service;

import com.huangtl.blogmgr.dao.SystemMemoDao;
import com.huangtl.blogmgr.dao.where.SystemMemoWhere;
import com.huangtl.blogmgr.model.blog.SystemMemo;
import com.huangtl.blogmgr.model.common.Message;
/**
 * 系统备忘业务接口
 * @author Canaan
 * @date 2017年4月29日
 *
 */
public interface SystemMemoService {
	SystemMemoDao getDao();
	Message addMemo(SystemMemo memo);
	Message editMemo(SystemMemo memo,SystemMemoWhere where);
	Message deleteMemo(String... ids);
}
