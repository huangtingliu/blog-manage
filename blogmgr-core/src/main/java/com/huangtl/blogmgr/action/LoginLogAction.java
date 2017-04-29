package com.huangtl.blogmgr.action;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.huangtl.blogmgr.dao.where.LoginLogSqlWhere;
import com.huangtl.blogmgr.model.blog.LoginLog;
import com.huangtl.blogmgr.model.common.Page;
import com.huangtl.blogmgr.model.common.Page.Direction;
import com.huangtl.blogmgr.model.extjs.Filter;
import com.huangtl.blogmgr.model.extjs.FilterCollection;
import com.huangtl.blogmgr.model.extjs.Sort;
import com.huangtl.blogmgr.model.extjs.SortCollection;
import com.huangtl.blogmgr.service.LoginLogService;

/**
 * 登录日志页面高度
 * @author PraiseLord
 * @date 2017年2月11日
 *
 */
@Controller
@RequestMapping("/loginlog")
public class LoginLogAction extends BlogMgrAction  {
	private static Logger logger  = LoggerFactory.getLogger(LoginLogAction.class);
	
	@Resource
	private LoginLogService loginLogService;
	
	
	/**
	 * 用户分页查询
	* @param pageNo 当前页号
	 * @param pageSize 每页记录个数 
	 * @param filter 查询过滤器 <br>
	 * <blockquote>
	 *  格式  filter:[{"property":"fName","value":"张三","operator":"like"}] 
	 *  </blockquote>
	 * @param sort 排序方案 <br>
	 * <blockquote>
	 *  格式   sort:[{"property":"fCreateDate","direction":"ASC\DESC"}]
	 * </blockquote>
	 * @return
	 * <pre>
	 * {message: "获取成功个数 15", total: 0, list: [], success: true}
	 * </pre>
	 */
	@RequestMapping("paging.data")
	@ResponseBody
	public Object getPaging(Integer pageNo,Integer pageSize,
			FilterCollection filter,SortCollection sort) {
		logger.debug("登录日志查询");
		Page<LoginLog> page = new Page<>(pageNo, pageSize);
		if(sort.isEmpty()){
			page.addSort("fCreateDate", Direction.DESC);
		}else{
			for (Sort s : sort) {
				page.addSort(s.getProperty(), s.getDirection());
			}
		}
		
		LoginLogSqlWhere whereParam = new LoginLogSqlWhere();
		for (Filter f : filter) {
			whereParam.putFilter(f);
		}
		
		this.loginLogService.getDao().selectPaging(whereParam, page);
		
		JSONObject data = new JSONObject();
		data.put("list", page.getPageContent());
		data.put("total", page.getTotal());
		data.put("success", true);
		data.put("message", "获取成功个数 "+page.getPageSize());
		return data;
	}
	
}
