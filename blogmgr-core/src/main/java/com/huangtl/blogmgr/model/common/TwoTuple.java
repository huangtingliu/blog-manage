package com.huangtl.blogmgr.model.common;

/**
 * 二元组
 * 
 * @date 2016年8月11日
 * @author PraiseLord
 */
public class TwoTuple<A, B> {
	public final A first;
	public final B second;

	public TwoTuple(A a, B b) {
		this.first = a;
		this.second = b;
	}
}
