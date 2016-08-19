package com.huangtl.blogmgr.model.blog.dictionary;

/**
 * 用户状态
 * @date 2016年7月4日
 * @author PraiseLord
 */
public enum UserStatus {
	ENABLE(0,"可用"),
	DISABLE(1,"不可用");
	
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
