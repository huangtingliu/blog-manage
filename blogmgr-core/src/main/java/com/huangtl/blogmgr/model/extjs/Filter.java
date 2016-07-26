package com.huangtl.blogmgr.model.extjs;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * stroe对象中的filter.用来数据查询过滤
 * @date 2016年7月26日
 * @author PraiseLord
 */
public class Filter {
	private String property;	//过滤字段
	private String value;		//过滤值
	private Operator operator;		//操作类型
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	/**
	 * 查询动作
	 * @date 2016年7月26日
	 * @author PraiseLord
	 */
	public enum Operator{
		eq,		
		in,		
		like,
		lt,
		gt,
	}
}
