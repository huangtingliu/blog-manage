package com.huangtl.blogmgr.dao.where;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
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
	private final static String DEFAULT_WHERE_KEY = "defaultWhere"; //默认条件关键字
	
	public SqlWhere(){
		this(true);
	}
	
	/**
	 *  是否有默认的查询条件（1=1），默认（有）可以不带任何查询条件。否则必须带查询参数
	 * @param defaultWhere
	 */
	public SqlWhere(boolean defaultWhere){
		super();
		this.put(DEFAULT_WHERE_KEY, defaultWhere);
	}
	
	/** 
	 * {@code value}为null,或长度为0的数组,或长度为0的集合,都将越过。
	 */
	@Override
	public Object put(String key, Object value) {
		if(StringUtils.isBlank(key)){return null;}
		if(value==null){
			return null;
		}else if(String.class.isInstance(value)){
			//nothing to do ,just improve program effective
		}else if(Collection.class.isInstance(value)){
			Collection<?> col = (Collection<?>) value;
			if(col.size()==0){return null;}
		}else if(value.getClass().isArray()){
			Object[] os = (Object[])value;
			if(os.length==0){return null;}
		}
		
		return super.put(key, value);
	}
	
	public void defaultWhere(boolean defaultWhere){
		this.put(DEFAULT_WHERE_KEY, defaultWhere);
	}
	
	/**
	 * 单边模糊查询<br>
	 * 如： abc%
	 * @param property
	 * @param value
	 * @return
	 */
	protected void like(String property,String value){
		if(StringUtils.isBlank(value)){return ;}
		this.put(property, value+"%");
	}
	/**
	 * 空字段判断
	 * @param property
	 */
	protected void isNull(String property){
		this.put(property, true);
	}
	/**
	 * 非空字段判断
	 * @param property
	 */
	protected void isNotNull(String property){
		this.put(property, true);
	}
	
	/**
	 * 双边查询查询<br>
	 * 如： %abc%
	 * @param property
	 * @param value
	 * @return
	 */
	protected void likeIn(String property,String value){
		if(StringUtils.isBlank(value)){return ;}
		this.put(property, "%"+value+"%");
	}
	
	/**
	 * in 查询<br>
	 * 例1: val,val,val,...<br>
	 * 例2：['a','b','c',...]
	 * @param property
	 * @param value
	 * @param separator 分割字符，默认为 ,(逗号)
	 * @return
	 */
	protected void in(String property,String value,String separator){
		if(StringUtils.isBlank(value)){return ;}
		
		if(Pattern.matches("^\\[.*\\]$", value)){ //json数组解析
			List<String> values = JSON.parseArray(value, String.class);
			this.put(property, values);
		}else{
			if(separator==null){separator=",";}
			List<String> values = Arrays.asList(value.split(separator));
			this.put(property, values);
		}
	}
	
	
	/**
	 * 根据extjs filter模型提取出查询
	 * @param filter 
	 */
	public void putFilter(Filter filter){
		if(filter.getValue()==null){return ;}
		Operator operator = (filter.getOperator()!=null?filter.getOperator():Operator.eq);
		switch (operator) {
		case like:
			this.like(operator.eval(filter.getProperty()), filter.getValue());
			break;
		case likein:
			this.likeIn(operator.eval(filter.getProperty()), filter.getValue());
			break;
		case in:
			this.in(operator.eval(filter.getProperty()), filter.getValue(), ",");
			break;
		default:
			this.put(operator.eval(filter.getProperty()), filter.getValue());
		}
	}
	
	/**
	 * 创建一个空白的查询参数
	 */
	public static SqlWhere blankWhere(){
		return new SqlWhere() {};
	}
}
