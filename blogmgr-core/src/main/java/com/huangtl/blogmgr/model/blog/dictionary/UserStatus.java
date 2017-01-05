package com.huangtl.blogmgr.model.blog.dictionary;

/**
 * 用户状态
 * @date 2016年7月4日
 * @author PraiseLord
 */
public enum UserStatus {
	ENABLE(0,"可用"),
	DISABLE(1,"不可用"),
	LOCKED(2,"账号锁住"),
	CREDENTIALS_EXPIRED(3,"证书过期"),
	ACCOUNT_EXPIRED(4,"账号过期");
	
	private int code;
	private String text;
	private UserStatus(int code, String text) {
		this.code = code;
		this.text = text;
	}
	public String getText() {
		return text;
	}
	public int getCode() {
		return code;
	}
}
