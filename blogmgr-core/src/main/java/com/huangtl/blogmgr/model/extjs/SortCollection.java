package com.huangtl.blogmgr.model.extjs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;

/**
 * extjs 排序集合
 * @date 2016年8月9日
 * @author PraiseLord
 */
public class SortCollection implements Iterable<Sort>{
	private Map<String, Sort> sorts;
	
	public SortCollection() {
		this(null);
	}

	public SortCollection(List<Sort> sorts) {
		super();
		this.sorts = new HashMap<String,Sort>();
		if(sorts!=null){
			for (Sort sort : sorts) {
				this.addSort(sort);
			}
		}
	}

	/**
	 * 添加排项
	 * @param srot
	 * @return
	 */
	public  SortCollection addSort(Sort srot){
		if( srot==null || StringUtils.isBlank( srot.getProperty())){return this;}
		this.sorts.put(srot.getProperty(), srot);
		return this;
	}
	
	/**
	 * 批量添加
	 * @param srots
	 * @return
	 */
	public  SortCollection addSort(List<Sort> sorts){
		if(sorts==null){return this;}
		for (Sort sort : sorts) {
			addSort(sort);
		}
		return this;
	}
	
	/**
	 * 排序个数
	 * @return
	 */
	public int size(){
		return this.sorts.size();
	}
	
	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return size()==0;
	}
	
	/**
	 * 根据 排序字段，查询Sort
	 * @param property
	 * @return
	 */
	public Sort getSort(String property){
		return this.sorts.get(property);
	}
	
	@Override
	public Iterator<Sort> iterator() {
		return this.sorts.values().iterator();
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this.sorts.values());
	}
}
