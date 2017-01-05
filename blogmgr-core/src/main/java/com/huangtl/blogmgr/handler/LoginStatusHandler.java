package com.huangtl.blogmgr.handler;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.huangtl.blogmgr.model.common.Message;

/**
 * @author PraiseLord
 * @date 2017年1月1日 用户登录状态处理器，分别处理登录成功\失败状态的处理
 */
public class LoginStatusHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler {
	private final Logger logger = LoggerFactory.getLogger(LoginStatusHandler.class);

	// 用户登录成功处理
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		logger.debug("用户登录成功");
		// 认证成功后，获取用户信息并添加到session中
		request.getSession().setAttribute("user", "admin");
		Writer writer = response.getWriter();
		writer.write(Message.success("登录成功").toJson());
		writer.flush();
		writer.close();
		writer = null;
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

}
