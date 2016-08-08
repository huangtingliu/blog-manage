package com.huangtl.blogmgr.core.dao;


import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanIntrospector;
import org.apache.commons.beanutils.IntrospectionContext;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huangtl.blogmgr.dao.where.SqlWhere;
import com.huangtl.blogmgr.model.common.Page;

/**
 * 支持使用mybatis做orm的持久化
 * @author PraiseLord
 * @date 2016年3月9日
 */
public abstract class MybatisDaoAdaptor<T> implements MybatisDao<T> {
	protected  Logger logger = LoggerFactory.getLogger(getClass());
	private static final PropertyUtilsBean PROPERTY_UTIL = new PropertyUtilsBean();
	
	protected SqlSession sqlSession;
	protected  String nameSpace;
	
	public MybatisDaoAdaptor() {
		super();
		if(getEntityType()!=null){
			nameSpace = getEntityType().getName();
		}
		
		//利用PropertyUtilsBean 生成map时，只含实体的Fields的字段
		PROPERTY_UTIL.addBeanIntrospector(new BeanIntrospector() {
			@Override
			public void introspect(IntrospectionContext icontext) throws IntrospectionException {
				Class<?> clazz = icontext.getTargetClass();
				List<String> excludeProerty = new ArrayList<String>();
				
				for (String name : icontext.propertyNames()) {
					try {
						clazz.getDeclaredField(name);
					} catch (NoSuchFieldException | SecurityException e) {
						excludeProerty.add(name);
					}
				}
				
				for (String proerty : excludeProerty) {
					icontext.removePropertyDescriptor(proerty);
				}
			}
		});
	}
	
	/**
	 * 取得当前实体的类型
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Class<T> getEntityType(){
		Type supperType = getClass().getGenericSuperclass();
		
		if(supperType instanceof ParameterizedType){
			Type[] paramTypes = ((ParameterizedType) supperType).getActualTypeArguments();
			if (paramTypes.length>0) {
				return (Class<T>) paramTypes[0];
			}
			logger.warn("{}不能确定实体类型",getClass());
		}
		logger.warn("{}未指定实体的类型",getClass());
		return null;
	}
	
	/**
	 * 将实体转成map对象
	 * <li>获取实体所有的字段，并且该字段有get方法。如果只含get方法而实体无该字段，不列入转换值
	 * <li>字段必须以f开头，如fName,fGender,fId,...
	 * @param entity
	 * @return
	 */
	protected Map<String, Object> entityToMap(T entity){
		try {
			Map<String, Object> map = PROPERTY_UTIL.describe(entity);
			List<String> excludekey = new ArrayList<String>();
			for (String key : map.keySet()) {
				if(!Pattern.matches("^f[A-Z].*", key)){
					excludekey.add(key);
				}
			}
			for (String key : excludekey) {
				map.remove(key);
			}
			return map;
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			throw new RuntimeException(e);
		} 
	}
	
	/*
	 * 新增
	 */
	@Override
	public int insert(T entity){
		if(entity==null){return 0;}
		return this.sqlSession.insert(nameSpace+".insert", entity);
	}
	
	/*
	 * 删除
	 */
	@Override
	public int delete(SqlWhere param){
		if(param==null || param.size()==0){return 0;}
		return this.sqlSession.delete(nameSpace+".delete",param);
	};
	
	/*
	 * 更新新实体
	 * @param entity
	 * @return
	 */
	@Override
	public int update(T entity ,SqlWhere param){
		if(param==null || param.size()==0){return 0;}
		if(entity==null){return 0;}
		
		param.putAll(entityToMap(entity));
		return this.sqlSession.update(nameSpace+".update",param);
	};
	
	/**
	 * 根据查询参数查询
	 * @param param
	 * @return
	 */
	@Override
	public List<T> selectList(SqlWhere param){
		if(param==null){param = SqlWhere.blankWhere();}
		List<T> lists = this.sqlSession.selectList(nameSpace+".selectList",param);
		return lists;
	}
	
	/** 
	 * 查询总数
	 */
	@Override
	public long selectCount(SqlWhere param) {
		long count = this.sqlSession.selectOne(nameSpace+".selectCount",param);
		return count;
	}

	/** 
	 * 分页查询
	 */
	@Override
	public int selectPaging(SqlWhere param, Page<T> page) {
		if (param==null ) {param = SqlWhere.blankWhere();}
		page.setTotalRecNum(selectCount(param));
		param.put("startIndex", page.getStartIndex()-1);
		param.put("endIndex", page.getEndIndex()-1);
		param.put("pageSize", page.getPageSize());
		param.put("sorts", page.getSorts());
		List<T> lists = this.sqlSession.selectList(nameSpace+".selectPaging",param);
		page.setPageContent(lists);
		return lists==null?0:lists.size();
	}

	@Override
	public int deleteBatch(List<String> entityIds) {
		if(CollectionUtils.isEmpty(entityIds)){return 0;}
		return this.sqlSession.delete(nameSpace+".deleteBatch",entityIds);
	}

	public void setSqlSessionTemplate(SqlSession sqlSession){
		this.sqlSession = sqlSession;
	}
	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}
}
