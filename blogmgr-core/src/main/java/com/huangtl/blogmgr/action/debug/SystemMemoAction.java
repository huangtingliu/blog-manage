package com.huangtl.blogmgr.action.debug;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.huangtl.blogmgr.action.BlogMgrAction;
import com.huangtl.blogmgr.dao.where.SystemMemoWhere;
import com.huangtl.blogmgr.model.blog.SystemMemo;
import com.huangtl.blogmgr.model.common.Page;
import com.huangtl.blogmgr.model.common.Page.Direction;
import com.huangtl.blogmgr.model.extjs.Filter;
import com.huangtl.blogmgr.model.extjs.FilterCollection;
import com.huangtl.blogmgr.model.extjs.Sort;
import com.huangtl.blogmgr.model.extjs.SortCollection;
import com.huangtl.blogmgr.service.SystemMemoService;

/**
 * 系统备忘录调度接口
 * @author Canaan
 * @date 2017年4月29日
 *
 */
@Controller
@RequestMapping("/debug/memo")
public class SystemMemoAction extends BlogMgrAction {
	
	@Resource
	private SystemMemoService systemMemoService;
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param filter
	 * @param sort
	 * @return
	 */
	@RequestMapping("paging.data")
	@ResponseBody
	public Object getPaging(Integer pageNo,Integer pageSize,
			FilterCollection filter,SortCollection sort) {
		
		Page<SystemMemo> page = new Page<>(pageNo, pageSize);
		if(sort.isEmpty()){
			page.addSort("fOrder", Direction.ASC);
		}else{
			for (Sort s : sort) {
				page.addSort(s.getProperty(), s.getDirection());
			}
		}
		
		SystemMemoWhere whereParam = new SystemMemoWhere();
		for (Filter f : filter) {
			whereParam.putFilter(f);
		}
		
		this.systemMemoService.getDao().selectPaging(whereParam, page);
		
		JSONObject data = new JSONObject();
		data.put("memolist", page.getPageContent());
		data.put("total", page.getTotal());
		data.put("success", true);
		data.put("message", "获取成功个数 "+page.getPageSize());
		return data;
	}
	
	@RequestMapping("get.data")
	@ResponseBody
	public Object getMemo(String id){
		Assert.hasLength(id, "参数id不能为空");
		SystemMemo memo = this.systemMemoService.getDao().selectById(id);
		return memo;
	}
	
	@RequestMapping("delete.do")
	@ResponseBody
	public Object deleteMemo(String id){
		Assert.hasLength(id, "参数id未指定");
		return this.systemMemoService.deleteMemo(id.split(","));
	}
	
	@RequestMapping("add.do")
	@ResponseBody
	public Object addMemo(SystemMemo systemMemo){
		systemMemo.checkValidityThrow();
		systemMemo.setfId(systemMemo.newId());
		return this.systemMemoService.addMemo(systemMemo);
	}
	
	@RequestMapping("tree.data")
	@ResponseBody
	public Object getTree(){
		//TODO
		return "";
	}
	
}
