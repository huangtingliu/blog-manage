package com.huangtl.blogmgr.model.extjs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.huangtl.blogmgr.core.dao.Operator;

/**
 * 查询过滤集
 * @date 2016年7月26日
 * @author PraiseLord
 */
public class FilterCollection implements Iterable<Filter> {
	private Map<String, Filter> filters;	
	
	public FilterCollection() {
		this(null);
	}
	public FilterCollection(List<Filter> filters) {
		super();
		this.filters = new HashMap<String,Filter>();
		if(filters!=null){
			for (Filter filter : filters) {
				this.addFilter(filter);
			}
		}
	}
	
	/**
	 * 添加一个查询过虑器
	 * @param filter
	 * @return
	 */
	public FilterCollection addFilter(Filter filter){
		if(filter==null || StringUtils.isBlank(filter.getProperty())){return this;}
		
		Operator operator = (filter.getOperator()==null?Operator.eq:filter.getOperator());
		this.filters.put(filter.getProperty()+"_"+operator, filter);
		return this;
	}
	
	/**
	 * 批量添加查询过虑器
	 * @param filters
	 * @return
	 */
	public FilterCollection addFilter(List<Filter> filters){
		if(filters!=null){
			for (Filter filter : filters) {
				this.addFilter(filter);
			}
		}
		return this;
	}
	
	/**
	 * 包含过滤器的个数
	 * @return
	 */
	public int size(){
		return this.filters.size();
	}
	
	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return size()==0;
	}
	
	/**
	 * 根据要过虑的字段，找到过滤器
	 * @param field
	 * @return
	 */
	public Filter getFilter(String field,Operator operator){
		return this.filters.get(field+"_"+operator.toString());
	}
	
	@Override
	public Iterator<Filter> iterator() {
		return this.filters.values().iterator();
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this.filters.values());
	}
	
}
