package com.huangtl.blogmgr.core.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;

/**
 * web资源权限验证
 * @author PraiseLord
 * @date 2017年2月1日
 *
 */
public class ResourceAuthorityFilter extends GenericFilterBean {

	private final Logger logger = LoggerFactory.getLogger(ResourceAuthorityFilter.class);
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//throw new AccessDeniedException("当前无权限"); 当访问受限时主可抛出此异常
		chain.doFilter(request, response);
	}

}
