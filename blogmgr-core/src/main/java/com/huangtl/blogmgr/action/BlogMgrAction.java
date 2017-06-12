package com.huangtl.blogmgr.action;

import java.util.UUID;

/**
 * 博客后台url接口
 * @date 2016年6月30日
 * @author PraiseLord
 */
public abstract class BlogMgrAction {
	//protected User
	
	/**
	 * 创建一个uuid
	 * @return
	 */
	public static String uuid(){
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");
		return uuid;
	}
	
}
