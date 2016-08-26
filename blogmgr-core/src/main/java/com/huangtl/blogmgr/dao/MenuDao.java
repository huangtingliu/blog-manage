package com.huangtl.blogmgr.dao;

import java.util.List;

import com.huangtl.blogmgr.core.dao.MybatisDao;
import com.huangtl.blogmgr.dao.where.MenuSqlWhere;
import com.huangtl.blogmgr.model.blog.Menu;
import com.huangtl.blogmgr.model.extjs.TreeNode;

/**
 * 菜单持久化接口<br>
 * <blockquote>
 * 查询参数:<b>{@link com.huangtl.blogmgr.dao.where.MenuSqlWhere}</b><br><br>
 * 查询结果:<br>
 * <li>固定字段 --【fId,fName,fParentId,fUrl,fViewClass,fType,fGlyph,fOrder】
 * <li>可选字段--【fIcon,fExpand,fDescr,fUsability】
 * </blockquote>
 * @date 2016年6月30日
 * @author PraiseLord
 */
public interface MenuDao extends MybatisDao<Menu> {
	
	/**
	 * 根据查询条件查询，并转成TreeNode模型结果返回
	 * @param where {@link com.huangtl.blogmgr.dao.where.MenuSqlWhere}
	 * @return
	 */
	List<TreeNode> selectTreeNodes(MenuSqlWhere where);
	
	
}
