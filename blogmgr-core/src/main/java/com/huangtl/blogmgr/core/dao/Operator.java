package com.huangtl.blogmgr.core.dao;

/**
 * 查询操作
 * @date 2016年7月26日
 * @author PraiseLord
 */
public enum Operator{
	ne,		//不等于
	eq,		//等于
	in,		//包含
	like,	//单边模糊
	likein, //双边模糊
	lt,		//小于
	gt,		//大于
}
