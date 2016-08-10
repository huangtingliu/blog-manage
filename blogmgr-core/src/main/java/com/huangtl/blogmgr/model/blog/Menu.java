package com.huangtl.blogmgr.model.blog;

import com.huangtl.blogmgr.model.blog.type.MenuType;
import com.huangtl.blogmgr.model.common.ObjectValue;

/**
 * 菜单
 * @version 
 * @date 2016年6月30日
 * @author PraiseLord
 */
public class Menu extends ObjectValue {
	private static final long serialVersionUID = 3798069904994355609L;
	private String fId;				//
	private String fName;			//
	private String fParentId;		//父id
	private String fIcon;			//图标 iconClass
	private String fViewClass;		//视图类
	private String fUrl;			//链接
	private Integer fOrder;			//排序
    private String fDescr;			//描述
    private Integer fGlyph;			//glyph 值
    private Integer fExpand;		//是否展开
    private MenuType fType;			//菜单类型
    
	public String getfId() {
		return fId;
	}
	public void setfId(String fId) {
		this.fId = fId;
	}
	public MenuType getfType() {
		return fType;
	}
	public void setfType(MenuType fType) {
		this.fType = fType;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfParentId() {
		return fParentId;
	}
	public void setfParentId(String fParentId) {
		this.fParentId = fParentId;
	}
	public String getfIcon() {
		return fIcon;
	}
	public void setfIcon(String fIcon) {
		this.fIcon = fIcon;
	}
	public String getfViewClass() {
		return fViewClass;
	}
	public void setfViewClass(String fViewClass) {
		this.fViewClass = fViewClass;
	}
	public String getfUrl() {
		return fUrl;
	}
	public void setfUrl(String fUrl) {
		this.fUrl = fUrl;
	}
	public Integer getfOrder() {
		return fOrder;
	}
	public void setfOrder(Integer fOrder) {
		this.fOrder = fOrder;
	}
	public String getfDescr() {
		return fDescr;
	}
	public void setfDescr(String fDescr) {
		this.fDescr = fDescr;
	}
	public Integer getfGlyph() {
		return fGlyph;
	}
	public void setfGlyph(Integer fGlyph) {
		this.fGlyph = fGlyph;
	}
	public Integer getfExpand() {
		return fExpand;
	}
	public void setfExpand(Integer fExpand) {
		this.fExpand = fExpand;
	}
}
