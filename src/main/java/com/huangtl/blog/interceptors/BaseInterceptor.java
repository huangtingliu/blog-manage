package com.huangtl.blog.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.huangtl.blog.service.LoginService;

/**
 *描述：基础拦截器
 *创建人:黄廷柳
 *创建日期：2016年1月26日 下午5:41:55
 **/
public class BaseInterceptor implements HandlerInterceptor {

	private static final Logger log = Logger.getLogger(LoginService.class);
	
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object obj) throws Exception {

		req.setCharacterEncoding("utf-8");
		
		String ctnPath = req.getContextPath();
		String path = req.getServletPath();
		String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()
				+ctnPath+path;
		
		
		
		if("/base/login/toLogin".equals(path)){
			return true;
		}
		
//		log.info("不能访问该路径："+basePath);
		log.info("访问路径："+basePath);
		return true;
	}

}
