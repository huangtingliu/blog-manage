package com.huangtl.blogmgr.core.dao;

import java.util.List;

import com.huangtl.blogmgr.dao.where.SqlWhere;
import com.huangtl.blogmgr.model.common.Page;


/**
 * 基于 mybatis 框架 持久化的通用操作接口
 * @date 2016年8月25日
 * @author PraiseLord
 * @param <T> 实体模型
 */
public interface MybatisDao<T> extends Dao<T> {
	/**
	 * 插入一条记录
	 * @param entity 插入实体
	 * @return 返回记录的影响数
	 */
	int insert(T entity);
	
	/**
	 * 批量的插入记录
	 * @param entitys 如果参数为null或空，返回0
	 * @return  返回记录的影响数
	 */
	int insertBatch(List<T> entitys);
	
	/**
	 * 删除一条记录,如果{@code where}为null或空，返回0<br>
	 * 当删除条件不匹配时，将会抛出异常
	 * @param where 删除条件
	 * @return 返回记录的影响数
	 */
	int delete(SqlWhere where);
	
	/**
	 * 更新,返回记录的影响数。如果查询参数为null或空，则不更新返回 0<br>
	 * 当更新条件不匹配时，将出抛出异常
	 * @param entity 更新实体
	 * @param where 更新条件
	 * @return 返回记录的影响数
	 */
	int update(T entity ,SqlWhere where);
	
	/**
	 * 批量更新,根据实体的id分别来修改各个实体
	 * @param entitys 更新实体,当参数为null或空时返回0
	 * @return 返回影响的记录数
	 */
	int updateBatch(List<T> entitys);
	
	/**
	 * 查询多条记录，如果查询参数为null或空。则返回所有记录<br>
	 * 查询结果除一些固定字段外，还可以根据{@code fields}来显示额外的字段
	 * @param where 查询条件
	 * @param fields 显示的额外字段,不指定即显示默认的字段
	 */
	List<T> selectList(SqlWhere where,String... fields);
	
	/**
	 * 分页查询，查询结果除一些固定字段外，还可以根据{@code fields}来显示额外的字段
	 * @param where 查询条件
	 * @param page 分页条件
	 * @param fields 显示的额外字段,不指定即显示默认的字段
	 */
	int selectPaging(SqlWhere where,Page<T> page,String... fields);
	
	/**
	 * 查询总数如果查询参数为null或空。返回记录的总数
	 * @param where 查询条件
	 * @return 返回记录个数
	 */
	long selectCount(SqlWhere where);
	
}
