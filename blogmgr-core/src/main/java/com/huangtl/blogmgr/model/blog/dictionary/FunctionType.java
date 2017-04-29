package com.huangtl.blogmgr.model.blog.dictionary;

/**
 * 菜单类型
 * @date 2016年8月10日
 * @author PraiseLord
 */
public enum FunctionType {
	NAVIGATOR(1,"导航菜单"),
	TOOLBAR(2,"工具栏"),
	UNIT(3,"部件");
	
	
	private String text;
	private int code;
	
	private FunctionType( int code,String text) {
		this.text = text;
		this.code = code;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
}