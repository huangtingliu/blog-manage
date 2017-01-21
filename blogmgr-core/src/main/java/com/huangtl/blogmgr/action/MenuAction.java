package com.huangtl.blogmgr.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.huangtl.blogmgr.core.spring.resolver.Json;
import com.huangtl.blogmgr.dao.where.MenuSqlWhere;
import com.huangtl.blogmgr.dao.where.SqlWhere;
import com.huangtl.blogmgr.dao.where.UserSqlWhere;
import com.huangtl.blogmgr.model.blog.Menu;
import com.huangtl.blogmgr.model.blog.Role;
import com.huangtl.blogmgr.model.blog.User;
import com.huangtl.blogmgr.model.blog.dictionary.AuthPriority;
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
	 * 菜单分页查询，无权限
	 * @param pageNo 当前页号
	 * @param pageSize 每页记录个数 
	 * @param filter 查询过滤器 ,允许null<br>
	 * <blockquote>
	 *  格式  filter:[{"property":"fName","value":"张三","operator":"like"}] 
	 *  </blockquote>
	 * @param sort 排序方案 ,允许null<br>
	 * <blockquote>
	 *  可排序字段：fId,fOrder
	 *  格式   sort:[{"property":"fCreateDate","direction":"ASC\DESC"}]
	 * </blockquote>
	 * @return
	 * <pre>
	  {message: "获取成功个数 15", total: 0, menulist: [{
			"fGlyph":59012,
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
	@ResponseBody
	@RequestMapping("paging.data")
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
		
		this.menuService.getDao().selectPaging(whereParam, page,"fUsability");
		
		JSONObject data = new JSONObject();
		data.put("menulist", page.getPageContent());
		data.put("total", page.getTotal());
		data.put("success", true);
		data.put("message", "获取成功个数 "+page.getPageSize());
		return data;
	}
	
	/**
	 * 获取多个菜单，有权限
	 * @param parentId  菜单的父id
	 * @param menuId    根据菜单id查询
	 * @return
	 * <pre>
	 	{message: "获取成功个数 15", menulist: [{
			"fGlyph":59012,
			"fId":"B0010001",
			"fName":"用户统计",
			"fOrder":1,
			"fParentId":"B001",
			"fType":"NAVIGATOR",
			"fUrl":"",
			"fUsability":"ENABLE",d
			"fViewClass":""
		}], success: true}
	 * </pre>
	 */
	@ResponseBody
	@RequestMapping("authMenus.data")
	public Object getAuthMenus(String menuId,String parentId) {
		List<Menu> menus = null;
		
		//获取当前角色
		@SuppressWarnings("unchecked")
		List<Role> roles = (List<Role>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		if(CollectionUtils.isEmpty(roles)){
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			logger.error("当前用户:{}无权限",user.toString());
			menus = new ArrayList<>();
		}else{
			String[] roleIds = new String[roles.size()];
			for (int i = 0; i < roles.size(); i++) {
				roleIds[i] = roles.get(i).getfId();
			}
			AuthPriority[] authPrioritys = {AuthPriority.ENABLE,AuthPriority.LIMIT,AuthPriority.DISABLE};
			menus = this.menuService.getDao().selectPrivilegeMenu(roleIds, authPrioritys, parentId, menuId);
		}
		JSONObject data = new JSONObject();
		data.put("menulist", menus);
		data.put("success", true);
		data.put("message", "获取成功个数 "+menus.size());
		return data;
	}
	
	/**
	 * 树型结构查询权限菜单
	 * @param parentId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("authTreeMenus.data")
	public Object getAuthTreeMenus(String parentId) {
		//获取当前角色
		JSONObject tree = null;
		@SuppressWarnings("unchecked")
		List<Role> roles = (List<Role>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		if(CollectionUtils.isEmpty(roles)){
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			logger.error("当前用户:{}无权限",user.toString());
			tree = new JSONObject();
		}else{
			String[] roleIds = new String[roles.size()];
			for (int i = 0; i < roles.size(); i++) {
				roleIds[i] = roles.get(i).getfId();
			}
			AuthPriority[] authPrioritys = {AuthPriority.ENABLE,AuthPriority.LIMIT,AuthPriority.DISABLE};
			tree = this.menuService.getDao().selectTreePrivilegeMenu(roleIds, authPrioritys, parentId, 2);
		}
		
		return tree;
	}
	
	/**
	 * 获取菜单数据，用于构建成一棵树
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
	@ResponseBody
	@RequestMapping("tree.data")
	public Object getTreeNode(String parentId,String nodeId){
		if("root".equals(parentId)){parentId="";}
		
		MenuSqlWhere sqlWhere = new MenuSqlWhere()
								.fParentIdEqual(parentId)
								.fIdEqual(nodeId);
		List<TreeNode> nodes = this.menuService.getDao().selectTreeNodes(sqlWhere);
		return nodes;
	}
	
	/**
	 * 获取单个菜单，无权限
	 * @param id	菜单id
	 * @return
	 * <pre>
	   {
			"fGlyph":59012,
			"fIcon":"fa-bar-chart",
			"fId":"B0010001",
			"fName":"用户统计",
			"fOrder":1,
			"fParentId":"B001",
			"fType":"NAVIGATOR",
			"fUrl":"",
			"fUsability":"ENABLE",
			"fDescr":"博客前台管理",
			"fViewClass":""
		}
	<pre>
	 */
	@ResponseBody
	@RequestMapping("get.data")
	public Object getOne(String id){
		SqlWhere param = new MenuSqlWhere().fIdEqual(id);
		List<Menu> menus = this.menuService.getDao().selectList(param,"fUsability","fIcon","fDescr");
		
		if(CollectionUtils.isEmpty(menus)){return "{}";}
		
		return menus.get(0);
	}
	
	/**
	 * 添加一个菜单<br>
	 * 必填字段：fId,fName,fType
	 * @param menu
	 * @return
	 */
	@ResponseBody
	@RequestMapping("add.do")
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
	 * <li>如果提交的参数不为空null，那么就更新该字段，否则不更新
	 * <li>可供修改改字段：fName,fParentId,fIcon,fUrl,fViewClass,fType,fGlyph,fOrder,fUsability,fDescr
	 * @param menu
	 * @return
	 */
	@ResponseBody
	@RequestMapping("edit.do")
	public Object editMenu(Menu menu){
		if(menu==null || StringUtils.isBlank(menu.getfId())){return Message.error("fId未指定");}
		Message message = menu.checkValidity(true);
		if(message.isError()){return message;}
		
		MenuSqlWhere sqlWhere = new MenuSqlWhere().fIdEqual(menu.getfId());
		try {
			message = this.menuService.editMenu(menu, sqlWhere);
		} catch (Exception e) {
			message = Message.exception("修改失败");
			logger.error("菜单修改失败",e);
		}
		
		return message;
	}
	
	/**
	 * 批量修改菜单,规则参见：editMenu<br>
	 * @param menus 格式：
	 <pre>
	 	[{
	 		fId:'',
	 		fName:'',
	 		...
	 	},{...}]
	 <pre>
	 * @return
	 */
	@ResponseBody
	@RequestMapping("editbatch.do")
	public Object editBatchMenu(@Json List<Menu> menus){
		Message message = null;
		if(CollectionUtils.isEmpty(menus)){return Message.error("无效参数");}
		for (Menu menu : menus) {
			if(menu==null || StringUtils.isBlank(menu.getfId())){return Message.error("无效参数");}
			message = menu.checkValidity(true);
			if(message.isError()){return message;}
		}
		
		try {
			message = this.menuService.editBatchMenu(menus);
		} catch (Exception e) {
			message = Message.exception("菜单失败");
			logger.error("菜单修改失败",e);
		}
		
		return message;
	}
	
	/**
	 * 删除菜单<br>
	 * @param id 菜单id ,格式：【id,id,id,...】
	 * @return
	 */
	@ResponseBody
	@RequestMapping("delete.do")
	public Object deleteMenu(String id){
		Message message = null;
		if(StringUtils.isBlank(id)){return Message.error("无效参数");}
		
		try {
			message = this.menuService.deleteMenu(id.split(","));
		} catch (Exception e) {
			message = Message.exception("菜单删除失败");
			logger.error("菜单删除失败",e);
		}
		
		return message;
	}
	
}
