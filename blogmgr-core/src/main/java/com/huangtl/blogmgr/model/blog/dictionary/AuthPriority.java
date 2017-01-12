package com.huangtl.blogmgr.model.blog.dictionary;

/**
 * 关于权限的优先级别
 * @author PraiseLord
 * @date 2017年1月10日
 *
 */
public enum AuthPriority {
	ENABLE(1,"可用"),
	LIMIT(2,"受约束"),
	DISABLE(3,"禁用"),
	CLOSE(4,"关闭");
	
	
	private int code;
	private String text;
	private AuthPriority(int code, String text) {
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
