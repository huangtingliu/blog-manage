package com.huangtl.blogmgr.service.impl;

import com.huangtl.blogmgr.dao.DevelopPlanDao;
import com.huangtl.blogmgr.model.blog.DevelopPlan;
import com.huangtl.blogmgr.model.common.Message;
import com.huangtl.blogmgr.service.DevelopPlanService;

public class DevelopPlanServiceImpl implements DevelopPlanService {
	private DevelopPlanDao developPlanDao;
	
	@Override
	public Message addDevelopPlan(DevelopPlan plan) {
		int effectRow = this.developPlanDao.insert(plan);
		return Message.get(effectRow, "添加成功", "添加失败");
	}

	public DevelopPlanDao getDevelopPlanDao() {
		return developPlanDao;
	}
	public void setDevelopPlanDao(DevelopPlanDao developPlanDao) {
		this.developPlanDao = developPlanDao;
	}
}
