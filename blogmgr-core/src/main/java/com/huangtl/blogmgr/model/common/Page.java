package com.huangtl.blogmgr.model.common;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import com.alibaba.fastjson.JSON;


/**
 * 分页对象<p>
 * <blockquote>
 * <li>页号 1 （默认）
 * <li>每页15条 
 * <li>页面按钮的数量5个
 * </blockquote>
 * @version 
 * @date 2016年4月2日
 * @author PraiseLord
 */
public class Page<T> {
	
	private int pageNo;    //当前页号
    private int pageSize;  //每页几条
    private long totalRecNum;  //共有多少条记录
    private Collection<T> pageContent; //该页的数据(记录明细)
    private int buttonNum;	//页面按钮的数量
    private Map<String, String> sorts;	
        
	public Page() {
        this(1,15); 	
	}
	
	public Page(Integer pageNo,Integer pageSize){
		 this(pageNo,pageSize,5);
	}
	
	public Page(Integer pageNo,Integer pageSize,Integer buttonNum){
		 this.pageNo=(pageNo==null || pageNo<=0)?1:pageNo;
		 this.pageSize = (pageSize==null || pageSize<=0)?15:pageSize;
		 this.buttonNum = (buttonNum==null || buttonNum<=0)?5:buttonNum;
		 totalRecNum = 0l;
	}
	public Page(Long startIndex,Integer pageSize){
		this.pageSize = (pageSize==null || pageSize<=0)?15:pageSize;
		setStartIndex(startIndex);
	}
	
	/**
	 * 当前页号
	 */
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo==null?1:pageNo;
	}
	/**
	 * 每页几条记录
	 */
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize==null?0:pageSize;
	}
	
	/**
	 * 是否有下一页
	 */
	public Boolean isNextPage() {
		return pageNo<getTotalPageNum()?true:false;
	}

	/**
	 * 是否有上一页
	 */
	public Boolean isPrePage() {
		return pageNo>1?true:false;
	}

	/**
	 * 共有几条记录
	 */
	public long getTotalRecNum() {
		return totalRecNum;
	}
	public void setTotalRecNum(Long totalRecNum) {
		
		this.totalRecNum = totalRecNum==null?0:totalRecNum;
	}
	
	/**
	 * 共多少页
	 */
	public int getTotalPageNum() {
		return totalRecNum%pageSize>0?(int)(totalRecNum/pageSize+1):(int)(totalRecNum/pageSize);
	}

	/**
	 * 页面内容
	 */
	public Collection<T> getPageContent() {
		if(this.pageContent==null){return Collections.emptyList();}
		return pageContent;
	}
	
	public void setPageContent(Collection<T> pageContent) {
		this.pageContent = pageContent;
	}
    
	/**
	 * 第一条记录在库中的编号(编号从1开始)<p>
	 * 如分页大小为10条，当前页号为第3页，那么第一条记录在库中的编号为21条
	 * @return
	 */
	public int getStartIndex()
	{
		return pageSize*(pageNo-1)+1;  
	}
	
	public void setStartIndex(Long start){
		if(start==null || start<=0){this.setPageNo(1);}
		int no = (int) (start/getPageSize());
		setPageNo(no+1);
	}
    
	/**
	 * 最后一条记录在库中的编号(编号从1开始)<p>
	 * 如分页大小为10条，当前页号为第3页，那么最后一条记录在库中的编号为30条
	 */
	public int getEndIndex()
	{
		return (pageSize*pageNo>this.totalRecNum)? (int)(this.totalRecNum):(pageSize*pageNo);
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
		if(this.getTotalPageNum()<this.buttonNum)
			return 1;
		int temp =this.buttonNum/2;
		if(this.getTotalPageNum()-this.pageNo<temp)
		{
			return this.getTotalPageNum()-this.buttonNum+1;
		}else{
			return this.pageNo <= temp+1?1:this.pageNo-temp;
		}
	}

	/**
	 * 按钮的结束数字
	 */
	public int getButtonEndNum() {
		
		if(this.getTotalPageNum()<this.buttonNum)
			return this.getTotalPageNum();
			
		int temp =this.buttonNum/2;
		if(this.pageNo > temp+1)
		return (this.pageNo+temp)>this.getTotalPageNum()?this.getTotalPageNum():this.pageNo+temp;
		else{
			return this.buttonNum;
		}
	}
	
	public String toJson(){
		return JSON.toJSONString(this);
	}
	
	/**
	 * 转DataTablePage
	 * @return
	 */
	public DataTablePage<T> toDataTablePage(Integer draw){
		draw = draw==null?0:draw;
		DataTablePage<T> p = new DataTablePage<T>(draw, this.getTotalRecNum(),this.getTotalRecNum() , this.getPageContent());
		return p;
	}
}
