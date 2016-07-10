package com.huangtl.blogmgr.model.common;

public class BtnPage<T> extends Page<T> {
	private int buttonNum; // 页面按钮的数量

	public BtnPage() {
		super();
	}

	public BtnPage(Integer pageNo, Integer pageSize) {
		this(pageNo, pageSize, 5);
	}

	public BtnPage(Integer pageNo, Integer pageSize, Integer buttonNum) {
		super(pageNo, pageSize);
		this.buttonNum = (buttonNum == null || buttonNum <= 0) ? 5 : buttonNum;
	}

	public BtnPage(Long startIndex, Integer pageSize) {
		super(startIndex, pageSize);
	}
	
	
	/**
	 * 当前页的按钮数量
	 */
	public int getButtonNum() {
		return buttonNum;
	}

	public void setButtonNum(Integer buttonNum) {
		this.buttonNum = buttonNum==null?0:buttonNum;
	}
	/**
	 * 按钮的开始数字
	 */
	public int getButtonStartNum() {
		if(this.getPageTotal()<this.buttonNum)
			return 1;
		int temp =this.buttonNum/2;
		if(this.getPageTotal()-this.pageNo<temp)
		{
			return this.getPageTotal()-this.buttonNum+1;
		}else{
			return this.pageNo <= temp+1?1:this.pageNo-temp;
		}
	}

	/**
	 * 按钮的结束数字
	 */
	public int getButtonEndNum() {
		
		if(this.getPageTotal()<this.buttonNum)
			return this.getPageTotal();
			
		int temp =this.buttonNum/2;
		if(this.pageNo > temp+1)
		return (this.pageNo+temp)>this.getPageTotal()?this.getPageTotal():this.pageNo+temp;
		else{
			return this.buttonNum;
		}
	}
}
