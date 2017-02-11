package com.huangtl.blogmgr.core.security;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.alibaba.fastjson.JSONObject;
import com.huangtl.blogmgr.model.blog.LoginLog;
import com.huangtl.blogmgr.model.blog.Role;
import com.huangtl.blogmgr.model.blog.User;
import com.huangtl.blogmgr.model.common.Message;
import com.huangtl.blogmgr.service.LoginLogService;

import nl.bitwalker.useragentutils.Browser;
import nl.bitwalker.useragentutils.UserAgent;

/**
 * @author PraiseLord
 * @date 2017年1月1日 用户登录状态处理器，分别处理登录成功\失败状态的处理
 */
public class LoginStatusHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler {
	private final Logger logger = LoggerFactory.getLogger(LoginStatusHandler.class);
	
	private LoginLogService loginLogService;
	
	/**
	 * 1.用户登录成功处理：返回登录成功标识，并发送系统初始化使用的基础数据
	 * 2.记录登录日志
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		logger.debug("用户登录成功");
		
		
		
		response.setCharacterEncoding("utf-8");
		Writer writer = response.getWriter();
		
		Message msg = Message.success("登录成功");
		//base data
		User user = (User) authentication.getPrincipal();
		
		try {
			addLoginLog(request,user);
		} catch (Exception e) {
			logger.error("登录日志添加失败",e);
		}
		
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
		msg.setAnnex(data);
		
		writer.write(msg.toJson());
		writer.flush();
		writer.close();
		writer = null;
	}
	
	/**
	 * 添加登录日志
	 */
	private void addLoginLog(HttpServletRequest request,User user){
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
		Browser browser = userAgent.getBrowser();
		LoginLog loginLog = new LoginLog();
		loginLog.setfId(loginLog.newId());
		loginLog.setfCreateDate(new Date());
		//loginLog.setfIp(browser.);
		loginLog.setfBrowser(browser.getName()+" "+userAgent.getBrowserVersion());
		loginLog.setfUid(user.getfId());
		loginLog.setfIp(request.getRemoteAddr());
		loginLog.setfOperatingSystem(userAgent.getOperatingSystem().toString());
		
		this.loginLogService.addLoginLog(loginLog);
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		logger.debug("登录失败！");
		response.setCharacterEncoding("utf-8");
		Writer writer = response.getWriter();
		writer.write(Message.error("用户名密码错误").toJson());
		writer.flush();
		writer.close();
		writer = null;
	}
	
	public void setLoginLogService(LoginLogService loginLogService) {
		this.loginLogService = loginLogService;
	}

}
