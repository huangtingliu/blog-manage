package com.huangtl.blogmgr.core.security;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.huangtl.blogmgr.model.common.Message;

/**
 * springSecurity 访问受限处理类
 * @author PraiseLord
 * @date 2017年2月4日
 *
 */
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
	
	private final Logger logger = LoggerFactory.getLogger(AccessDeniedHandlerImpl.class);
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		request.setAttribute(WebAttributes.ACCESS_DENIED_403,
				accessDeniedException);
		logger.debug("无权限");
		
		response.setCharacterEncoding("utf-8");
		String requestType = request.getHeader("X-Requested-With");  
		
		if("XMLHttpRequest".equals(requestType)){ //此为ajax 请求
			String msg = accessDeniedException.getMessage();
			if(StringUtils.isBlank(msg)){msg = "抱歉，你无该权限";}
			Message message = Message.error("访问受限", msg);
			Writer writer = response.getWriter();
			writer.write(message.toJson());
			writer.flush();
			writer.close();
			writer = null;
		}else{ //其他的请求
			// Set the 403 status code.
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			// redirect to error page.
			response.sendRedirect("/blogmgr/noauth.htm");
		}
	}
	
}
