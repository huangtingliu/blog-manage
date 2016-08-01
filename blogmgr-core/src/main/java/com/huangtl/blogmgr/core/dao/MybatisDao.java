package com.huangtl.blogmgr.core.dao;

import java.util.List;

import com.huangtl.blogmgr.dao.where.SqlWhere;
import com.huangtl.blogmgr.model.common.Page;


public interface MybatisDao<T> extends Dao<T> {
	/**
	 * 添加,返回记录的影响数
	 */
	int insert(T entity);
	/**
	 * 删除,返回记录的影响数
	 */
	int delete(SqlWhere param);
	
	/**
	 * 批量删除,返回记录的影响数
	 */
	int deleteBatch(List<String> entityIds);
	/**
	 * 修改,返回记录的影响数。如果查询参数为null或空，则返回 0
	 */
	int update(T entity ,SqlWhere param);
	/**
	 * 不分页查询，如果查询参数为null或空。则返回空集
	 */
	List<T> selectList(SqlWhere param);
	/**
	 * 分页查询
	 */
	int selectPaging(SqlWhere param,Page<T> page);
	
	/**
	 * 查询总数如果查询参数为null或空。则返回记录的总数
	 */
	long selectCount(SqlWhere param);
}
