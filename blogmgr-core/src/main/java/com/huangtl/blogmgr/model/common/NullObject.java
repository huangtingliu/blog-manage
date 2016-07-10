package com.huangtl.blogmgr.model.common;

/**
 * 表示一个空对象
 * @date 2016年6月30日
 * @author PraiseLord
 */
public final class NullObject extends ObjectValue {
	private static final long serialVersionUID = -4903718298064836467L;
	public static final NullObject INSTANCE = new NullObject();
	
	private NullObject() {
		super();
	}
	
	@Override
	public String toString() {
		return null;
	}
	
}
