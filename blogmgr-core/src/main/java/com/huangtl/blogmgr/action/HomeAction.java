package com.huangtl.blogmgr.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.huangtl.blogmgr.model.blog.Role;
import com.huangtl.blogmgr.model.blog.User;

/**
 * 系统主页
 * @version 
 * @date 2016年6月28日
 * @author PraiseLord
 */
@Controller
@RequestMapping("/")
public class HomeAction extends BlogMgrAction {
	
	/**
	 * 主页面
	 * @return
	 */
	@RequestMapping("home.htm")
	private ModelAndView homePage() {
		ModelAndView view = new ModelAndView("home");
		return view;
	}
	
	/**
	 * 主页默认页面
	 * @return
	 */
	@RequestMapping("home/index.htm")
	private ModelAndView homeIndexPage() {
		ModelAndView view = new ModelAndView("home/index");
		return view;
	}
	
	/**
	 * 获取基础数据,用来用户界面的初始化
	 * 1.userId      当前用户id
	 * 2.userName    当前用户呢称
	 * 3.userAccount 当前用户账号
	 * 4.userStatus  当前用户状态
	 * 5.userPhone   当前用户电话
	 * 6.userEmail	  当前用户邮箱
	 * 7.userRole	  当前用户角色
	 *
	 * 8.serversDate  服务器时间
	 * 9.baseUrl 基础路径
	 * @return
	 */
	@RequestMapping("home/baseData.data")
	@ResponseBody
	private Object getBaseData(HttpServletRequest request){
		SecurityContextImpl securityContext = (SecurityContextImpl) request  
				 .getSession().getAttribute("SPRING_SECURITY_CONTEXT"); 
		
		User user = (User) securityContext.getAuthentication().getPrincipal();
		
		
		JSONObject data = new JSONObject();
		data.put("userId", user.getfId());
		data.put("userName", user.getfName());
		data.put("userAccount", user.getfAccount());
		data.put("userStatus", user.getfStatus());
		data.put("userPhone", user.getfPhone());
		data.put("userEmail", user.getfEmail());
		
		StringBuilder sb  = new StringBuilder();
		for (Role role : user.getRoles()) {
			sb.append(",").append(role.getfName());
		}
		sb.deleteCharAt(0);
		data.put("userRole", sb.toString());
		data.put("serversDate", new Date());
		
		String baseUrl = "http://" + request.getServerName()  + ":" + request.getServerPort() + request.getContextPath()+"/";       
		data.put("baseUrl", baseUrl);
		
		return data;
	}

}
