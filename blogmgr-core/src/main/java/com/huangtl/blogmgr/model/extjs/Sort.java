package com.huangtl.blogmgr.model.extjs;

import com.huangtl.blogmgr.model.common.Page.Direction;

/**
 * extjs 排序对象
 * @date 2016年8月9日
 * @author PraiseLord
 */
public class Sort {
	private String property;		//排序字段
	private Direction direction;	//降序、升序
	public Sort() {
		this(null,null);
	}
	public Sort(String property, Direction direction) {
		super();
		this.property = property;
		this.direction = direction;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	@Override
	public String toString() {
		return property+" : "+direction;
	}
}
