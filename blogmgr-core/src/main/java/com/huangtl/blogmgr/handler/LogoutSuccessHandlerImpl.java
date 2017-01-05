package com.huangtl.blogmgr.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * 用户退出登录成功后处理
 * @author PraiseLord
 * @date 2017年1月5日
 *
 */
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler{
	private final Logger logger = LoggerFactory.getLogger(LogoutSuccessHandlerImpl.class);
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		logger.debug("退出登录\n Details：{}",authentication.getDetails().toString());
		logger.debug("Principal: {}",authentication.getPrincipal().toString());
		logger.debug("name: {}",authentication.getName());
		response.sendRedirect("login.htm");
	} 

}
