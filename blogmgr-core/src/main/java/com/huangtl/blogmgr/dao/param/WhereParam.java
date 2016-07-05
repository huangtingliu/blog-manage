package com.huangtl.blogmgr.dao.param;

import java.util.HashMap;

/**
 * 持久化参数集
 * @date 2016年6月30日
 * @author PraiseLord
 */
@SuppressWarnings("serial")
public abstract class WhereParam extends HashMap<String, Object> {
	@Override
	public Object put(String key, Object value) {
		if(value==null){return null;}
		
		return super.put(key, value);
	}
	
	/**
	 * 创建一个空白的查询参数
	 */
	public static WhereParam instance(){
		return new WhereParam() {
		};
	}
}
