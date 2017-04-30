package com.huangtl.blogmgr.core.dao;

/**
 * 查询操作
 * @date 2016年7月26日
 * @author PraiseLord
 */
public enum Operator{
	/**
	 * 不等于
	 */
	ne,		
	/**
	 * 等于
	 */
	eq,		
	/**
	 * 包含
	 */
	in,		
	/**
	 * 单边模糊
	 */
	like,	
	/**
	 * 双边模糊
	 */
	likein, 
	/**
	 * 小于
	 */
	lt,		
	/**
	 * 大于
	 */
	gt,		
	/**
	 * 不包含
	 */
	nin,
	/**
	 * 为空
	 */
	isnull,
	/**
	 * 不为空
	 */
	isnotnull;
	
	public String eval(String field){
		if(field==null||field.trim().equals("")){
			throw new IllegalStateException("参数不能为空");
		}
		return field+"_"+this.toString();
	}
}
