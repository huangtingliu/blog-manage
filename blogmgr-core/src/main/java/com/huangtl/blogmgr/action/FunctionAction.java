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
import com.huangtl.blogmgr.core.spring.resolver.Json;
import com.huangtl.blogmgr.dao.where.FunctionSqlWhere;
import com.huangtl.blogmgr.dao.where.SqlWhere;
import com.huangtl.blogmgr.model.blog.Function;
import com.huangtl.blogmgr.model.common.Message;
import com.huangtl.blogmgr.model.common.Page;
import com.huangtl.blogmgr.model.common.Page.Direction;
import com.huangtl.blogmgr.model.extjs.Filter;
import com.huangtl.blogmgr.model.extjs.FilterCollection;
import com.huangtl.blogmgr.model.extjs.Sort;
import com.huangtl.blogmgr.model.extjs.SortCollection;
import com.huangtl.blogmgr.model.extjs.TreeNode;
import com.huangtl.blogmgr.service.FunctionService;

/**
 * 系统功能管理url接口
 * @date 2016年6月30日
 * @author PraiseLord
 */
@Controller
@RequestMapping("/function")
public class FunctionAction extends BlogMgrAction {
	private static Logger logger = LoggerFactory.getLogger(FunctionAction.class);
	
	@Resource
	private FunctionService functionService;
	
	/**
	 * 系统功能分页查询，无权限
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
	  {message: "获取成功个数 15", total: 0, Functionlist: [{
			"fGlyph":59012,
			"fId":"B0010001",
			"fName":"用户统计",
			"fOrder":1,
			"fParentId":"B001",
			"fType":"NAVIGATOR",
			"fUrl":"",
			"fUsability":"ENABLE",
		}], success: true}
	 * </pre>
	 */
	@ResponseBody
	@RequestMapping("paging.data")
	public Object getPaging(Integer pageNo,Integer pageSize,
			FilterCollection filter,SortCollection sort) {
		
		Page<Function> page = new Page<>(pageNo,pageSize);
		if(sort==null || sort.isEmpty()){
			page.addSort("fId", Direction.ASC);
			page.addSort("fOrder", Direction.ASC);
		}else{
			for (Sort s : sort) {
				page.addSort(s.getProperty(), s.getDirection());
			}
		}
		
		FunctionSqlWhere whereParam = new FunctionSqlWhere();
		if(filter!=null && !filter.isEmpty()){
			for (Filter f : filter) {
				whereParam.putFilter(f);
			}
		}
		
		this.functionService.getDao().selectPaging(whereParam, page,"fUsability");
		
		JSONObject data = new JSONObject();
		data.put("functionlist", page.getPageContent());
		data.put("total", page.getTotal());
		data.put("success", true);
		data.put("message", "获取成功个数 "+page.getPageSize());
		return data;
	}
	
	/**
	 * 获取系统功能数据，用于构建成一棵树
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
		
		FunctionSqlWhere sqlWhere = new FunctionSqlWhere()
								.fParentIdEqual(parentId)
								.fIdEqual(nodeId);
		List<TreeNode> nodes = this.functionService.getDao().selectTreeNodes(sqlWhere);
		return nodes;
	}
	
	/**
	 * 获取单个系统功能，无权限
	 * @param id	系统功能id
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
		SqlWhere param = new FunctionSqlWhere().fIdEqual(id);
		List<Function> functions = this.functionService.getDao().selectList(param,"fUsability","fIcon","fDescr");
		
		if(CollectionUtils.isEmpty(functions)){return "{}";}
		
		return functions.get(0);
	}
	
	/**
	 * 添加一个系统功能<br>
	 * 必填字段：fId,fName,fType
	 * @param Function
	 * @return
	 */
	@ResponseBody
	@RequestMapping("add.do")
	public Object addFunction(Function function){
		 Message message = function.checkValidity();
		if(message.isError()){return message;}
		
		try {
			message = this.functionService.addFunction(function);
		} catch (Exception e) {
			logger.error("添加失败",e);
			message = Message.exception("添加失败");
		}
		return message;
	}
	
	
	/**
	 * 系统功能修改，必须指定fId
	 * 规则：<p>
	 * <li>如果提交的参数不为空null，那么就更新该字段，否则不更新
	 * <li>可供修改改字段：fName,fParentId,fIcon,fUrl,fViewClass,fType,fGlyph,fOrder,fUsability,fDescr
	 * @param Function
	 * @return
	 */
	@ResponseBody
	@RequestMapping("edit.do")
	public Object editFunction(Function function){
		if(function==null || StringUtils.isBlank(function.getfId())){return Message.error("fId未指定");}
		Message message = function.checkValidity(true);
		if(message.isError()){return message;}
		
		FunctionSqlWhere sqlWhere = new FunctionSqlWhere().fIdEqual(function.getfId());
		try {
			message = this.functionService.editFunction(function, sqlWhere);
		} catch (Exception e) {
			message = Message.exception("修改失败");
			logger.error("修改失败",e);
		}
		
		return message;
	}
	
	/**
	 * 批量修改系统功能,规则参见：editFunction<br>
	 * @param Functions 格式：
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
	public Object editBatchFunction(@Json List<Function> functions){
		Message message = null;
		if(CollectionUtils.isEmpty(functions)){return Message.error("无效参数");}
		for (Function function : functions) {
			if(function==null || StringUtils.isBlank(function.getfId())){return Message.error("无效参数");}
			message = function.checkValidity(true);
			if(message.isError()){return message;}
		}
		
		try {
			message = this.functionService.editBatchFunction(functions);
		} catch (Exception e) {
			message = Message.exception("系统异常");
			logger.error("修改失败",e);
		}
		
		return message;
	}
	
	/**
	 * 删除系统功能<br>
	 * @param id 系统功能id ,格式：【id,id,id,...】
	 * @return
	 */
	@ResponseBody
	@RequestMapping("delete.do")
	public Object deleteFunction(String id){
		Message message = null;
		if(StringUtils.isBlank(id)){return Message.error("无效参数");}
		
		try {
			message = this.functionService.deleteFunction(id.split(","));
		} catch (Exception e) {
			message = Message.exception("删除失败");
			logger.error("删除失败",e);
		}
		
		return message;
	}
	
}
