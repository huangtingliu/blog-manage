package com.huangtl.blogmgr.dao.impl;

import java.util.List;

import com.huangtl.blogmgr.core.dao.MybatisDaoAdaptor;
import com.huangtl.blogmgr.dao.MenuDao;
import com.huangtl.blogmgr.dao.where.MenuSqlWhere;
import com.huangtl.blogmgr.model.blog.Menu;
import com.huangtl.blogmgr.model.extjs.TreeNode;

/**
 * 菜单持久化接口 -  默认实现, 查询参数见{@link com.huangtl.blogmgr.dao.where.MenuParam}
 * @date 2016年6月30日
 * @author PraiseLord
 */
public class MenuDaoImpl extends MybatisDaoAdaptor<Menu> implements MenuDao {
	private final static String  MENU_TREE_NAMESPACE = "com.huangtl.blogmgr.model.blog.tree.Menu";

	@Override
	public List<TreeNode> selectTreeNodes(MenuSqlWhere where) {
		return this.sqlSession.selectList(MENU_TREE_NAMESPACE+".selectTreeNodes", where);
	}

}
