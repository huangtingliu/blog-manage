package com.huangtl.blogmgr.service;

import java.util.List;

import com.huangtl.blogmgr.dao.FunctionDao;
import com.huangtl.blogmgr.dao.where.FunctionSqlWhere;
import com.huangtl.blogmgr.model.blog.Function;
import com.huangtl.blogmgr.model.common.Message;

/**
 * 系统功能业务接口
 * @date 2016年6月30日
 * @author PraiseLord
 */
public interface FunctionService {
	/**
	 * 取得持久化对象
	 */
	public FunctionDao getDao();
	
	/**
	 * 新增一个系统功能<br>
	 * 必填字段：fId,fName,fType
	 * @param function
	 * @return Message
	 */
	 Message addFunction(Function function);
	
	/**
	 * 修改一个系统功能<br>
	 * 可修改字段：fName,fParentId,fRelevance,fHandler,fIcon,fType,fGlyph,fOrder,fUsability,fDescr
	 * @param function 如果menu字段不为null,那么将更新该字段。否则不更新
	 * @param where 更新条件
	 * @return Message
	 */
	 Message editFunction(Function function,FunctionSqlWhere where);
	
	/**
	 * 根据fId批量的修改系统功能
	 * 可修改字段：参见 editFunction
	 * @param functions
	 * @return 影响的记录数
	 */
	 Message editBatchFunction(List<Function> functions);
	
	/**
	 * 根据fId删除系统功能
	 * @param fId
	 * @return
	 */
	 Message deleteFunction(String... fId);
	
}
