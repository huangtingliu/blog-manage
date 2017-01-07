package com.huangtl.blogmgr.model.blog.dictionary;

/**
 * 用户状态
 * @date 2016年7月4日
 * @author PraiseLord
 */
public enum UserStatus {
	DELETE(0,"已删除"),
	ENABLE(1,"可用"),
	DISABLE(2,"不可用"),
	LOCKED(3,"账号锁住"),
	CREDENTIALS_EXPIRED(4,"密码过期"),
	ACCOUNT_EXPIRED(5,"账号过期");
	
	
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
