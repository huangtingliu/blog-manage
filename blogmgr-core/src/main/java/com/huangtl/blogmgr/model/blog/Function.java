package com.huangtl.blogmgr.model.blog;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.huangtl.blogmgr.model.blog.dictionary.CommonDictionary.Usability;
import com.huangtl.blogmgr.model.blog.dictionary.FunctionType;
import com.huangtl.blogmgr.model.common.ObjectValue;

/**
 * 系统功能
 * @version 
 * @date 2016年6月30日
 * @author PraiseLord
 */
public class Function extends ObjectValue {
	private static final long serialVersionUID = 3798069904994355609L;
	private String fId;				//id
	private String fName;			//功能名称
	private String fParentId;		//父id
	private String fIcon;			//图标 iconClass
	private String fRelevance;		//URL关联值
	private String fHandler;		//处理方式
	private Integer fOrder;			//排序 默认 0
    private String fDescr;			//描述
    private Integer fGlyph;			//glyph值 
    private FunctionType fType;		//功能类型
    private Usability fUsability;	//是否可用，默认 ENABLE
    
    @NotBlank(message="功能id为空")
	public String getfId() {
		return fId;
	}
	public void setfId(String fId) {
		this.fId = fId;
	}
	@NotNull(message="功能类型为空")
	public FunctionType getfType() {
		return fType;
	}
	public void setfType(FunctionType fType) {
		this.fType = fType;
	}
	@NotBlank(message="功能名为空")
	@Length(message="功能名长度2-10",min=2,max=10)
	@Pattern(regexp="[\\u4e00-\\u9fa5]*",message="功能名必须是中文")
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
	public String getfRelevance() {
		return fRelevance;
	}
	public void setfRelevance(String fRelevance) {
		this.fRelevance = fRelevance;
	}
	public String getfHandler() {
		return fHandler;
	}
	public void setfHandler(String fHandler) {
		this.fHandler = fHandler;
	}
	@Range(message="功能序号0-100",min=0,max=100)
	public Integer getfOrder() {
		return fOrder;
	}
	public void setfOrder(Integer fOrder) {
		this.fOrder = fOrder;
	}
	@Length(message="功能描述长度300",max=300)
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
	public Usability getfUsability() {
		return fUsability;
	}
	public void setfUsability(Usability fUsability) {
		this.fUsability = fUsability;
	}
}
