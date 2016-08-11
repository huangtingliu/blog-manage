package com.huangtl.blogmgr.model.extjs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.huangtl.blogmgr.model.common.TwoTuple;

/**
 * ext 树模型结构
 * @date 2016年8月10日
 * @author PraiseLord
 */
public class TreeNode {
	private String id;					//节点id
	private String text;				//节点文字 
	private String parentId;			//父节点id
	private String icon;				//节点图标图片路径
	private String iconCls;				//节点图标样式
	private Boolean checked;			//是否被选中
	private Integer depth;				//节点的深度
	private String href;				//链接
	private String qtip;				//tip，悬浮提示文本
	private String qtitle;				//tip 悬浮提示标题
	private Boolean leaf;				//是否是叶子节点{true:是，false:不是}
	private Boolean expandable;			//是否可以展开
	private Boolean expanded;			//状态是否是展开{true:展开，false:缩起}
	private List<TreeNode> children;	//子节点
	
	private Integer childrenSize;		//子节点个数
	private Integer order;				//节点排序号
	private Map<String, Object> attr;	//附加属性
	
	public TreeNode() {
		this(null,null);
	}
	public TreeNode(String id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	
	/**
	 * 如果children 不为null，返回children#size 的值。
	 * @return
	 */
	public Integer getChildrenSize() {
		if(getChildren()!=null){return getChildren().size();}
		return childrenSize;
	}
	/**
	 * 如果children 不为null.则设置childrenSize无效
	 * @param childrenSize
	 */
	public void setChildrenSize(Integer childrenSize) {
		if(getChildren()!=null){
			this.childrenSize = getChildren().size();
			return;
		}
		this.setLeaf(childrenSize==0);
		this.childrenSize = childrenSize;
	}
	/**
	 * 优先判断ChildrenSize的值，如果ChildrenSize==0返回true
	 * @return
	 */
	public Boolean getLeaf() {
		 if(getChildrenSize() !=null && getChildrenSize()==0){
			return true;
		}
		return leaf;
	}
	/**
	 * 当值为true时，则同时设定expanded的值为false
	 * @param leaf
	 */
	public void setLeaf(Boolean leaf) {
		if(leaf==true){ this.setExpanded(false);}
		this.leaf = leaf;
	}
	
	/**
	 * 优先判断ChildrenSize的值，如果ChildrenSize==0返回false;
	 * @return
	 */
	public Boolean getExpanded() {
		if(getChildrenSize()!=null && getChildrenSize()==0){return false;}
	    return expanded;
	}
	/**
	 * 优先判断ChildrenSize的值，如果ChildrenSize==0 设置无效
	 * @param expanded
	 */
	public void setExpanded(Boolean expanded) {
		if(getChildrenSize()!=null && getChildrenSize()==0){return;}
		this.expanded = expanded;
	}
	/**
	 * 如果children#size ==0 设置 Leaf = true ,Expanded = false
	 * children#size > 0 设置 Leaf = false
	 */
	public void setChildren(List<TreeNode> children) {
		if(children==null){return;}
		this.setChildrenSize(children.size());
		this.children = children;
	}
	public List<TreeNode> getChildren() {
		return children;
	}
	public Map<String, Object> getAttr() {
		return attr;
	}
	public void setAttr(TwoTuple<String, Object> tuple) {
		if(this.attr==null){this.attr = new HashMap<String,Object>();}
		attr.put(tuple.first, tuple.second);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public Integer getDepth() {
		return depth;
	}
	public void setDepth(Integer depth) {
		this.depth = depth;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getQtip() {
		return qtip;
	}
	public void setQtip(String qtip) {
		this.qtip = qtip;
	}
	public String getQtitle() {
		return qtitle;
	}
	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}
	public Boolean getExpandable() {
		return expandable;
	}
	public void setExpandable(Boolean expandable) {
		this.expandable = expandable;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
}
