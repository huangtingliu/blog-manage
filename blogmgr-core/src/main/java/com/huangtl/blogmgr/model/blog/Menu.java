package com.huangtl.blogmgr.model.blog;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.huangtl.blogmgr.model.blog.dictionary.CommonDictionary.Usability;
import com.huangtl.blogmgr.model.blog.dictionary.MenuType;
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
    private Integer fGlyph;			//glyph值
    private MenuType fType;			//菜单类型
    private Integer fExpand;		//是否展开{0：不展开，1：展开},默认0
    private Usability fUsability;	//是否可用，默认 ENABLE
    
    @NotBlank(message="菜单id为空")
	public String getfId() {
		return fId;
	}
	public void setfId(String fId) {
		this.fId = fId;
	}
	@NotNull(message="菜单类型为空")
	public MenuType getfType() {
		return fType;
	}
	public void setfType(MenuType fType) {
		this.fType = fType;
	}
	@NotBlank(message="菜单名为空")
	@Length(message="菜单名长度2-10",min=2,max=10)
	@Pattern(regexp="[\\u4e00-\\u9fa5]*",message="菜单名必须是中文")
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
	@Range(message="菜单序号0-100",min=0,max=100)
	public Integer getfOrder() {
		return fOrder;
	}
	public void setfOrder(Integer fOrder) {
		this.fOrder = fOrder;
	}
	@Length(message="菜单描述长度300",max=300)
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
	public Usability getfUsability() {
		return fUsability;
	}
	public void setfUsability(Usability fUsability) {
		this.fUsability = fUsability;
	}
}
