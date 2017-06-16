package com.huangtl.blogmgr.action.debug;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huangtl.blogmgr.action.BlogMgrAction;
import com.huangtl.blogmgr.model.blog.DevelopPlan;
import com.huangtl.blogmgr.model.common.Message;
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
