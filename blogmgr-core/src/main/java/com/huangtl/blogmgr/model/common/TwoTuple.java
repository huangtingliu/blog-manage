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

	public TwoTuple(A first, B second) {
		this.first = first;
		this.second = second;
	}
	public A getFirst() {
		return first;
	}
	public B getSecond() {
		return second;
	}
}
