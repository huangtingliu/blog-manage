package com.huangtl.blogmgr.dao.param;

import java.util.HashMap;

import com.huangtl.blogmgr.model.common.NullObject;

/**
 * 持久化参数集
 * @date 2016年6月30日
 * @author PraiseLord
 * <em>参数值不为null，如果想指定一个null的值请用{@link com.huangtl.blogmgr.model.common.NullObject}</em>
 */
@SuppressWarnings("serial")
public abstract class WhereParam extends HashMap<String, Object> {
	@Override
	public Object put(String key, Object value) {
		if(value==null){return null;}
		
		if(value instanceof NullObject){
			value = NullObject.INSTANCE.toString();
		}
		
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
