package com.huangtl.blogmgr.service;

import com.huangtl.blogmgr.model.blog.DevelopPlan;
import com.huangtl.blogmgr.model.common.Message;

/**
 * 开发计划业务层接口
 * @author Canaan
 * @date 2017年6月16日
 *
 */
public interface DevelopPlanService {
	/**
	 * 新增一个开发计划
	 * @param plan
	 * @return
	 */
	Message addDevelopPlan(DevelopPlan plan);
}
