package com.huangtl.blogmgr.model.blog.dictionary;

/**
 * 权限类型
 * @author PraiseLord
 * @date 2017年1月10日
 *
 */
public enum PrivilegeType {
	VIEW(1,"视图权限"),
	FUNCTION(2,"功能权限");
	
	
	private int code;
	private String text;
	private PrivilegeType(int code, String text) {
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
