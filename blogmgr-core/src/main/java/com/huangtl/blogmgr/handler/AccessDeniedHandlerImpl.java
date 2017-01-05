package com.huangtl.blogmgr.handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.access.AccessDeniedHandler;

public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
	
	private final Logger logger = LoggerFactory.getLogger(AccessDeniedHandlerImpl.class);
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		request.setAttribute(WebAttributes.ACCESS_DENIED_403,
				accessDeniedException);
		logger.debug("无权限");
		// Set the 403 status code.
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);

		// forward to error page.
		RequestDispatcher dispatcher = request.getRequestDispatcher("noauth.htm");
		dispatcher.forward(request, response);
		
	}

}
