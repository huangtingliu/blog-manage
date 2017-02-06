package com.huangtl.blogmgr.dao.impl;

import java.util.List;

import com.huangtl.blogmgr.core.dao.MybatisDaoAdaptor;
import com.huangtl.blogmgr.dao.FunctionDao;
import com.huangtl.blogmgr.dao.where.FunctionSqlWhere;
import com.huangtl.blogmgr.model.blog.Function;
import com.huangtl.blogmgr.model.extjs.TreeNode;

/**
 * 系统功能持久化接口 -  默认实现<br>
 * @date 2016年6月30日
 * @author PraiseLord
 */
public class FunctionDaoImpl extends MybatisDaoAdaptor<Function> implements FunctionDao {
	private final static String  MENU_TREE_NAMESPACE = "com.huangtl.blogmgr.model.blog.tree.Function";

	@Override
	public List<TreeNode> selectTreeNodes(FunctionSqlWhere where) {
		return this.sqlSession.selectList(MENU_TREE_NAMESPACE+".selectTreeNodes", where);
	}
	
}
