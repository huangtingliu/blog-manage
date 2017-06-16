package com.huangtl.blogmgr.action;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import com.huangtl.blogmgr.model.blog.User;

/**
 * 博客后台url接口
 * @date 2016年6月30日
 * @author PraiseLord
 */
public abstract class BlogMgrAction {
	private final Logger logger = LoggerFactory.getLogger(BlogMgrAction.class);
	/**
	 * 获取当前的用户
	 * @return
	 */
	protected User getCurrentUser(){
		User currentUser;
		try {
			currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			currentUser = new User();
			logger.warn("无法获取当前用户信息",e);
		}
		return currentUser;
	}
	
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
