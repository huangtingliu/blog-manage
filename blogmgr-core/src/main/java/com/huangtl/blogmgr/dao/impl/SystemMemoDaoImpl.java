package com.huangtl.blogmgr.dao.impl;

import java.util.List;

import com.huangtl.blogmgr.core.dao.MybatisDaoAdaptor;
import com.huangtl.blogmgr.dao.SystemMemoDao;
import com.huangtl.blogmgr.dao.where.SystemMemoWhere;
import com.huangtl.blogmgr.model.blog.SystemMemo;

/**
 * 系统备忘录持久化mybatis实现
 * @author Canaan
 * @date 2017年4月29日
 *
 */
public class SystemMemoDaoImpl extends MybatisDaoAdaptor<SystemMemo> implements SystemMemoDao {

	@Override
	public SystemMemo selectById(String id) {
		SystemMemoWhere where = new SystemMemoWhere()
								.fIdEqual(id);
		List<SystemMemo> list = this.selectList(where);
		if(list==null){
			return null;
		}else if(list.isEmpty()){
			return null;
		}else if(list.size()>1){
			 throw new IllegalStateException("查询SystemMemo主键为: "+id+"得到超过"+list.size()+"条数据！！！");
		}
		return list.get(0);
	}
}
