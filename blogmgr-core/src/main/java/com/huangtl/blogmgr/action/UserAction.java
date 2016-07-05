package com.huangtl.blogmgr.action;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huangtl.blogmgr.model.blog.User;
import com.huangtl.blogmgr.model.common.Message;
import com.huangtl.blogmgr.model.common.Page;
import com.huangtl.blogmgr.service.UserService;

/**
 * 后台用户url接口
 * @date 2016年7月4日
 * @author PraiseLord
 */
@Controller
@RequestMapping("/mgruser/*")
public class UserAction extends BlogMgrAction {
	@Resource
	private UserService userService;
	
	/**
	 * 主页面
	 * @return
	 */
	@RequestMapping("paging.data")
	@ResponseBody
	private Object menuSearch(
			Integer pageSize,Integer pageNo) {
		Page<User> page = new Page<>(pageNo, pageSize);
		this.userService.getDao().selectPaging(null, page);
		
		Message msg = Message.success("success");
		msg.setData(page);
		return page;
	}
}
