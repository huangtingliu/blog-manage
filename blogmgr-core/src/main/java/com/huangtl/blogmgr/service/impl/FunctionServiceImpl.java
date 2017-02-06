package com.huangtl.blogmgr.service.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.huangtl.blogmgr.dao.FunctionDao;
import com.huangtl.blogmgr.dao.where.FunctionSqlWhere;
import com.huangtl.blogmgr.model.blog.Function;
import com.huangtl.blogmgr.model.common.Message;
import com.huangtl.blogmgr.service.FunctionService;

/**
 * 系统功能业务接口 - 默认实现
 * @date 2016年6月30日
 * @author PraiseLord
 */
public class FunctionServiceImpl implements FunctionService {
	private FunctionDao functionDao;
	
	@Override
	public FunctionDao getDao() {
		return functionDao;
	}
	
	@Override
	public Message addFunction(Function menu) {
		int effectRow = functionDao.insert(menu);
		return Message.get(effectRow, "添加成功", "添加失败");
	}
	
	@Override
	public Message editFunction(Function menu, FunctionSqlWhere where) {
		int effectRow = this.functionDao.update(menu, where);
		return Message.get(effectRow, "修改成功", "修改失败");
	}
	
	@Override
	public Message editBatchFunction(List<Function> menus) {
		if(CollectionUtils.isEmpty(menus)){return Message.error("无效参数");}
		int effectRow = this.functionDao.updateBatch(menus);
		return Message.get(effectRow, "修改成功", "修改失败");
	}
	
	

	@Override
	public Message deleteFunction(String... fId) {
		if(fId==null || fId.length==0){return Message.error("无效参数");}
		
		FunctionSqlWhere where = new FunctionSqlWhere().fIdIn(fId);
		int effectRow = this.functionDao.delete(where);
		
		return Message.get(effectRow, "删除成功", "删除失败");
	}
	
	 public void setFunctionDao(FunctionDao functionDao) {
		this.functionDao = functionDao;
	}
	
}
