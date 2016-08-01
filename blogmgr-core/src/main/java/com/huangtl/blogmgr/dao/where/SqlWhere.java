package com.huangtl.blogmgr.dao.where;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.huangtl.blogmgr.core.dao.Operator;
import com.huangtl.blogmgr.model.extjs.Filter;

/**
 * 持久化参数集
 * @date 2016年6月30日
 * @author PraiseLord
 * <em>参数值不为null</em>
 */
@SuppressWarnings("serial")
public abstract class SqlWhere extends HashMap<String, Object> {
	
	@Override
	public Object put(String key, Object value) {
		if(StringUtils.isBlank(key)){return null;}
		if(value==null){return null;}
		return super.put(key, value);
	}
	
	
	/**
	 * 单边模糊查询<br>
	 * 如： abc%
	 * @param property
	 * @param value
	 * @return
	 */
	public SqlWhere like(String property,String value){
		if(StringUtils.isBlank(value)){return this;}
		this.put(property, value+"%");
		return this;
	}
	
	/**
	 * 双边查询查询<br>
	 * 如： %abc%
	 * @param property
	 * @param value
	 * @return
	 */
	public SqlWhere likeIn(String property,String value){
		if(StringUtils.isBlank(value)){return this;}
		this.put(property, "%"+value+"%");
		return this;
	}
	
	/**
	 * in 查询<br>
	 * 如: val,val,val,...
	 * @param property
	 * @param value
	 * @param separator 分割字符，默认为 ,(逗号)
	 * @return
	 */
	public SqlWhere in(String property,String value,String separator){
		if(StringUtils.isBlank(value)){return this;}
		if(separator==null){separator=",";}
		List<String> values = Arrays.asList(value.split(separator));
		this.put(property, values);
		return this;
	}
	
	
	/**
	 * 根据extjs filter模型提取出查询
	 * @param filter 
	 */
	public SqlWhere putFilter(Filter filter){
		if(filter.getValue()==null){return this;}
		Operator operator = (filter.getOperator()!=null?filter.getOperator():Operator.eq);
		
		switch (operator) {
		case like:
			this.like(filter.getProperty()+"_"+operator, filter.getValue());
			break;
		case likein:
			this.likeIn(filter.getProperty()+"_"+operator, filter.getValue());
			break;
		case in:
			this.in(filter.getProperty()+"_"+operator, filter.getValue(), ",");
		default:
			this.put(filter.getProperty()+"_"+operator, filter.getValue());
		}
		
		return this;
	}
	
	/**
	 * 创建一个空白的查询参数
	 */
	public static SqlWhere blankWhere(){
		return new SqlWhere() {};
	}
}
