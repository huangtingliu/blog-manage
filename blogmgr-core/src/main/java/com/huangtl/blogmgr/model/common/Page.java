package com.huangtl.blogmgr.model.common;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.annotation.JSONField;


/**
 * 分页对象<p>
 * <blockquote>
 * <li>页号 1 （默认）
 * <li>每页15条 
 * </blockquote>
 * @version 
 * @date 2016年4月2日
 * @author PraiseLord
 */
public class Page<T> {
	
	protected int pageNo;    //当前页号
	protected int pageSize;  //每页几条
	protected long total;  //共有多少条记录
	protected Collection<T> pageContent; //该页的数据(记录明细)
	protected Map<String, Order> sorts;	
        
	public Page() {
        this(1,15); 	
	}
	
	public Page(Integer pageNo,Integer pageSize){
		this.pageNo=(pageNo==null || pageNo<=0)?1:pageNo;
		this.pageSize = (pageSize==null || pageSize<=0)?15:pageSize;
		total = 0l;
		sorts = new HashMap<String, Order>();
	}
	
	public Page(Long startIndex,Integer pageSize){
		this.pageSize = (pageSize==null || pageSize<=0)?15:pageSize;
		setStartIndex(startIndex);
		sorts = new HashMap<String, Order>();
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
		return pageNo<getPageTotal()?true:false;
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
	public long getTotal() {
		return total;
	}
	public void setTotalRecNum(Long totalRecNum) {
		
		this.total = totalRecNum==null?0:totalRecNum;
	}
	
	/**
	 * 共多少页
	 */
	public int getPageTotal() {
		return total%pageSize>0?(int)(total/pageSize+1):(int)(total/pageSize);
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
	@JSONField(serialize=false)
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
	@JSONField(serialize=false)
	public int getEndIndex()
	{
		return (pageSize*pageNo>this.total)? (int)(this.total):(pageSize*pageNo);
	}
	
	@JSONField(serialize=false)
	public Map<String, Order> getSorts() {
		return sorts;
	}
	
	/**
	 * 添加排序
	 * @param field
	 * @param order
	 * @return
	 */
	public Map<String, Order> addSort(String field,Order order){
		if(StringUtils.isBlank(field)){return this.sorts;}
		this.sorts.put(field, order);
		return this.sorts;
	}
	
	
	public enum Order{
		desc,
		asc
	}
}
