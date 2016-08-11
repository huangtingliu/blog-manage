package com.huangtl.blogmgr.dao;

import java.util.List;

import com.huangtl.blogmgr.core.dao.MybatisDao;
import com.huangtl.blogmgr.dao.where.MenuSqlWhere;
import com.huangtl.blogmgr.model.blog.Menu;
import com.huangtl.blogmgr.model.extjs.TreeNode;

/**
 * 菜单持久化接口
 * @date 2016年6月30日
 * @author PraiseLord
 * 查询参数默认使用 {@link com.huangtl.blogmgr.dao.where.MenuSqlWhere}
 */
public interface MenuDao extends MybatisDao<Menu> {
	List<TreeNode> selectTreeNodes(MenuSqlWhere where);
}
