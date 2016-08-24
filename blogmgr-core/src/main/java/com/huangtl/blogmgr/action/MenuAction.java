package com.huangtl.blogmgr.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.huangtl.blogmgr.dao.where.MenuSqlWhere;
import com.huangtl.blogmgr.dao.where.SqlWhere;
import com.huangtl.blogmgr.dao.where.UserSqlWhere;
import com.huangtl.blogmgr.model.blog.Menu;
import com.huangtl.blogmgr.model.common.Message;
import com.huangtl.blogmgr.model.common.Page;
import com.huangtl.blogmgr.model.common.Page.Direction;
import com.huangtl.blogmgr.model.extjs.Filter;
import com.huangtl.blogmgr.model.extjs.FilterCollection;
import com.huangtl.blogmgr.model.extjs.Sort;
import com.huangtl.blogmgr.model.extjs.SortCollection;
import com.huangtl.blogmgr.model.extjs.TreeNode;
import com.huangtl.blogmgr.service.MenuService;

/**
 * 菜单管理url接口
 * @date 2016年6月30日
 * @author PraiseLord
 */
@Controller
@RequestMapping("/menu")
public class MenuAction extends BlogMgrAction {
	private static Logger logger = LoggerFactory.getLogger(MenuAction.class);
	
	@Resource
	private MenuService menuService;
	
	/**
	 * 菜单分页查询
	 * @param pageNo 当前页号
	 * @param pageSize 每页记录个数 
	 * @param filter 查询过滤器 ,允许null<br>
	 * <blockquote>
	 *  格式  filter:[{"property":"fName","value":"张三","operator":"like"}] 
	 *  </blockquote>
	 * @param sort 排序方案 ,允许null<br>
	 * <blockquote>
	 *  格式   sort:[{"property":"fCreateDate","direction":"ASC\DESC"}]
	 * </blockquote>
	 * @return
	 * <pre>
	  {message: "获取成功个数 15", total: 0, menulist: [{
			"fGlyph":59012,
			"fIcon":"fa-bar-chart",
			"fId":"B0010001",
			"fName":"用户统计",
			"fOrder":1,
			"fParentId":"B001",
			"fType":"NAVIGATOR",
			"fUrl":"",
			"fUsability":"ENABLE",
			"fViewClass":""
		}], success: true}
	 * </pre>
	 */
	@RequestMapping("paging.data")
	@ResponseBody
	public Object getPaging(Integer pageNo,Integer pageSize,
			FilterCollection filter,SortCollection sort) {
		
		Page<Menu> page = new Page<>(pageNo,pageSize);
		if(sort==null || sort.isEmpty()){
			page.addSort("fId", Direction.ASC);
			page.addSort("fOrder", Direction.ASC);
		}else{
			for (Sort s : sort) {
				page.addSort(s.getProperty(), s.getDirection());
			}
		}
		
		UserSqlWhere whereParam = new UserSqlWhere();
		if(filter!=null && !filter.isEmpty()){
			for (Filter f : filter) {
				whereParam.putFilter(f);
			}
		}
		
		this.menuService.getDao().selectPaging(whereParam, page);
		
		JSONObject data = new JSONObject();
		data.put("menulist", page.getPageContent());
		data.put("total", page.getTotal());
		data.put("success", true);
		data.put("message", "获取成功个数 "+page.getPageSize());
		return data;
	}
	
	/**
	 * 获取多个菜单
	 * @param parentId  菜单的父id
	 * @param menuId    根据菜单id查询
	 * @return
	 * <pre>
	 	{message: "获取成功个数 15", menulist: [{
			"fGlyph":58901,
			"fIcon":"fa-users",
			"fId":"A0010001",
			"fName":"博客用户",
			"fParentId":"A001",
			"fUrl":"",
			"fUsability":"ENABLE",
			"fViewClass":""
		}], success: true}
	 * </pre>
	 */
	@RequestMapping("list.data")
	@ResponseBody
	public Object getList(String parentId,String menuId) {
		SqlWhere param = new MenuSqlWhere()
						  .fParentIdEqual(parentId)
						  .fIdEqual(menuId);
		List<Menu> menus = this.menuService.getDao().selectList(param);
		
		JSONObject data = new JSONObject();
		data.put("menulist", menus);
		data.put("success", true);
		data.put("message", "获取成功个数 "+menus.size());
		return data;
	}
	
	/**
	 * 获取菜单数据，用于构建成一棵树
	 * 
	 * @param parentId 根据父节点查询其子节点
	 * @param nodeId   根据节点id查询节点
	 * @return
	 * <pre>
		 [{
			"attr":{
				"fOrder":1,
				"fType":"NAVIGATOR"
			},
			"childrenSize":0,
			"expanded":false,
			"iconCls":"fa-users",
			"id":"A0010001",
			"leaf":true,
			"parentId":"A001",
			"text":"博客用户"
		},{...}]
	 * </pre>
	 */
	@RequestMapping("tree.data")
	@ResponseBody
	public Object getTreeNode(String parentId,String nodeId){
		if("root".equals(parentId)){parentId="";}
		
		MenuSqlWhere sqlWhere = new MenuSqlWhere()
								.fParentIdEqual(parentId)
								.fIdEqual(nodeId);
		List<TreeNode> nodes = this.menuService.getDao().selectTreeNodes(sqlWhere);
		return nodes;
	}
	
	/**
	 * 获取单个菜单
	 * @param menuId	菜单id
	 * @return
	 * <pre>
	   {
			"fGlyph":58917,
			"fIcon":"fa-tencent-weibo",
			"fId":"A001",
			"fName":"",
			"fParentId":"",
			"fUrl":"",
			"fUsability":"ENABLE",
			"fViewClass":""
		}
	<pre>
	 */
	@RequestMapping("get.data")
	@ResponseBody
	public Object getOne(String menuId){
		SqlWhere param = new MenuSqlWhere().fIdEqual(menuId);
		List<Menu> menus = this.menuService.getDao().selectList(param);
		
		if(CollectionUtils.isEmpty(menus)){return "{}";}
		
		return menus.get(0);
	}
	
	@RequestMapping("add.do")
	@ResponseBody
	public Object addMenu(Menu menu){
		 Message message = menu.checkValidity();
		if(message.isError()){return message;}
		try {
			message = this.menuService.addMenu(menu);
		} catch (Exception e) {
			logger.error("菜单添加失败",e);
			message = Message.exception("菜单添加失败");
		}
		return message;
	}
	
	
	/**
	 * 菜单修改，必须指定fId
	 * 规则：<p>
	 * <li>如果提交的参数不为空，那么就更新该字段。（空字符串也算）
	 * 
	 * @param menu
	 * @return
	 */
	@RequestMapping("edit.do")
	@ResponseBody
	public Object editMenu(Menu menu){
		if(menu==null || StringUtils.isBlank(menu.getfId())){return Message.error("fId未指定");}
		
		return Message.warn("未实现");
	}
}
