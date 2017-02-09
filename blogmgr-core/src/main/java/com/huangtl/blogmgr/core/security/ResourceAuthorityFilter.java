package com.huangtl.blogmgr.core.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import com.huangtl.blogmgr.model.blog.Privilege;
import com.huangtl.blogmgr.model.blog.Role;
import com.huangtl.blogmgr.model.blog.User;
import com.huangtl.blogmgr.model.blog.dictionary.AuthPriority;
import com.huangtl.blogmgr.service.PrivilegeService;

/**
 * web资源权限验证
 * @author PraiseLord
 * @date 2017年2月1日
 *
 */
public class ResourceAuthorityFilter extends GenericFilterBean {

	private final Logger logger = LoggerFactory.getLogger(ResourceAuthorityFilter.class);
	
	private PrivilegeService privilegeService;
	
	/**
	 * 根据参数中的【功能代码】与当前的用户的角色，判断用户是否有该功能的操作权限;
	 * 如果请求中没有带有【_mgr_fucode】参数值，那么默认为有权限
	 */
	@Override
	public void doFilter(ServletRequest _request, ServletResponse _response, FilterChain chain)
			throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest) _request;
			HttpServletResponse response = (HttpServletResponse) _response;
			String url = request.getServletPath();
			
			User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			StringBuilder roleIds = new StringBuilder();
			
			boolean denied = true;
			for(Role role : currentUser.getRoles()){
				roleIds.append(role.getfId()).append(",");
				denied = !validate(role.getfId(),url);
				if(!denied){break;}
			}
			if(denied){
				logger.debug("【权限验证 】failure 用户为：{},角色为：{}",currentUser.getfAccount(),roleIds.toString());
				throw new AccessDeniedException("您无该功能的操作无权限");
			}
			
		logger.debug("【权限验证 】success 用户为：{},角色为：{}",currentUser.getfAccount(),roleIds.toString());
		chain.doFilter(request, response);
	}

	/*
	 * 根据角色与功能编号。验证是否有权限
	 * @return true 有权限，否则没有权限
	 */
	private boolean validate(String roleId,String servletPath){
		List<Privilege> privileges = this.privilegeService.queryPrivilegesByRoleId(roleId,"funRelevance");
		if(CollectionUtils.isEmpty(privileges)){return false;}
		
		for (Privilege privilege : privileges) {
			String relevanceUrl = privilege.getFunRelevance();
			if(StringUtils.isBlank(relevanceUrl)){continue;}
			if(!relevanceUrl.startsWith("/")){
				relevanceUrl = "/"+relevanceUrl;
			}
			if(servletPath.equals(relevanceUrl)){
				AuthPriority priority = privilege.getfPriority();
				return priority == AuthPriority.ENABLE || priority == AuthPriority.LIMIT;
			}
		}
		
		return true;
	}
	
	public void setPrivilegeService(PrivilegeService privilegeService) {
		this.privilegeService = privilegeService;
	}
}
