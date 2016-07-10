package com.huangtl.blogmgr.action;


import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huangtl.blogmgr.core.util.PinYinUtils;
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
		msg.setContent(page);
		return page;
	}
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@RequestMapping("addUser.do")
	@ResponseBody
	private Object addUser(User user){
		if(user==null){
			return Message.error("参数为空");
		}
		Message message = null;
		user.setfId(user.newId());
		user.setfCreateDate(new Date());
		user.setfCreater("root");
		message = user.checkValidity();
		
		if(message.isError()){return message;}
		
		user.setfPinYin(PinYinUtils.toPinYin(user.getfPinYin()));      //拼音转换
		user.setfPassword(DigestUtils.md5Hex(user.getfPassword()));  
			
		return this.userService.addUser(user);
	}
	
	
}
