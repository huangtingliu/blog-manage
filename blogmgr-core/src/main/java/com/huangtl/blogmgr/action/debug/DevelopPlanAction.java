package com.huangtl.blogmgr.action.debug;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.huangtl.blogmgr.action.BlogMgrAction;
import com.huangtl.blogmgr.dao.where.DevelopPlanSqlWhere;
import com.huangtl.blogmgr.model.blog.DevelopPlan;
import com.huangtl.blogmgr.model.common.Message;
import com.huangtl.blogmgr.model.common.Page;
import com.huangtl.blogmgr.model.common.Page.Direction;
import com.huangtl.blogmgr.model.extjs.Filter;
import com.huangtl.blogmgr.model.extjs.FilterCollection;
import com.huangtl.blogmgr.model.extjs.Sort;
import com.huangtl.blogmgr.model.extjs.SortCollection;
import com.huangtl.blogmgr.service.DevelopPlanService;

/**
 * 开发计划view层高度接口
 * @author Canaan
 * @date 2017年6月16日
 *
 */
@Controller
@RequestMapping("/debug/developplan")
public class DevelopPlanAction extends BlogMgrAction {
	@Resource
	private DevelopPlanService developPlanService;
	
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
	public Object getPaging( Integer pageNo, Integer pageSize,
			FilterCollection filter,SortCollection sort) {
		
		Page<DevelopPlan> page = new Page<>(pageNo, pageSize);
		if(sort.isEmpty()){
			page.addSort("fCreateDate", Direction.DESC);
		}else{
			for (Sort s : sort) {
				page.addSort(s.getProperty(), s.getDirection());
			}
		}
		
		DevelopPlanSqlWhere whereParam = new DevelopPlanSqlWhere();
		for (Filter f : filter) {
			whereParam.putFilter(f);
		}
		this.developPlanService.getDao().selectPaging(whereParam, page,"createUserName");
		
		JSONObject data = new JSONObject();
		data.put("planlist", page.getPageContent());
		data.put("total", page.getTotal());
		data.put("success", true);
		data.put("message", "获取成功个数 "+page.getPageSize());
		return data;
	}
	
	
	/**
	 * 新增一个开发计划
	 * @param plan
	 * @return
	 */
	@RequestMapping(value="add.do",method=RequestMethod.POST)
	@ResponseBody
	public Object addDevelopPlan(DevelopPlan plan){
		//默认值填充
		plan.setfId(plan.newId());
		plan.setfCreateDate(new Date());
		plan.setfCreateUser(getCurrentUser().getfId());
		plan.setfProgress(0);
		plan.setPlanTerminatorName(null);
		plan.setfPlanTerminator(null);
		plan.setfPlanStauts("ENABLE");
		plan.setfFinishDate(null);
		
		plan.checkValidityThrow();
		Message message = developPlanService.addDevelopPlan(plan);
		
		return message;
	}
}
