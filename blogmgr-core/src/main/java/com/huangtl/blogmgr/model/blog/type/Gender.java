package com.huangtl.blogmgr.model.blog.type;

/**
 * 性别
 * @date 2016年7月9日
 * @author PraiseLord
 */
public enum Gender {
	UNKNOW(0,"未知"),
	MALE(1,"男"),
	FEMALE(2,"女");
	
	private int code;
	private String text;
	private Gender(int code, String text) {
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
