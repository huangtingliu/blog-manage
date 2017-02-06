package com.huangtl.blogmgr.dao;

import java.util.List;

import com.huangtl.blogmgr.core.dao.MybatisDao;
import com.huangtl.blogmgr.dao.where.FunctionSqlWhere;
import com.huangtl.blogmgr.model.blog.Function;
import com.huangtl.blogmgr.model.extjs.TreeNode;

/**
 * 系统功能持久化接口<br>
 * <blockquote>
 * 查询参数:<b>{@link com.huangtl.blogmgr.dao.where.FunctionSqlWhere}</b><br><br>
 * 查询结果:<br>
 * <li>固定字段 --【fId,fName,fParentId,fUrl,fViewClass,fType,fGlyph,fOrder】
 * <li>可选字段--【fIcon,fExpand,fDescr,fUsability】
 * </blockquote>
 * @date 2016年6月30日
 * @author PraiseLord
 */
public interface FunctionDao extends MybatisDao<Function> {
	
	/**
	 * 根据查询条件查询，并转成TreeNode模型结果返回
	 * @param where {@link com.huangtl.blogmgr.dao.where.FunctionSqlWhere}
	 * @return
	 */
	List<TreeNode> selectTreeNodes(FunctionSqlWhere where);
	
}
