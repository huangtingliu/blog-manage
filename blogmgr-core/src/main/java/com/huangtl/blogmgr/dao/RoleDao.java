package com.huangtl.blogmgr.dao;

import java.util.List;

import com.huangtl.blogmgr.core.dao.MybatisDao;
import com.huangtl.blogmgr.dao.where.UserSqlWhere;
import com.huangtl.blogmgr.model.blog.Role;
import com.huangtl.blogmgr.model.common.TwoTuple;

/**
 * 角色持久化对象
 * <blockquote>
 * 查询参数：{@link com.huangtl.blogmgr.dao.where.RoleSqlWhere}<br><br>
 * 查询结果：<br>
 * 固定字段：【fId,fName,fCode,fStatus】<br>
 * 可选字段：【fDescr】
 * </blockquote>
 * @author PraiseLord
 * @date 2017年1月6日
 *
 */
public interface RoleDao extends MybatisDao<Role> {
	/**
	 * 根据角色id查询用户
	 * @param fId
	 * @return
	 */
	Role selectOne(String fId);
	
	/**
	 * 批量删除用户,数据从数据中抹去。慎重！！
	 * @param fIds 如果参数为null,或长度为0。返回0
	 * @return 返回影响的记录的个数
	 */
	int deleteBatch(String... fIds);
	
	/**
	 * 伪删除用户
	 * @param fIds 如果参数为null,或长度为0。返回0
	 * @return 返回影响的记录的个数
	 */
	int fakeDeleteBatch(String... fIds);
	
	/**
	 * 添加用户权限
	 * @param userRoles
	 * @return
	 */
	int insertUserRole(List<TwoTuple<String, String>> userRoles);
	
	/**
	 * 根据用户条件查询其权限
	 * @param where
	 * @return
	 */
	List<Role> selectByUserWhere(UserSqlWhere where,String... fields);
}
