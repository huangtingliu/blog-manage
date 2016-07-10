package com.huangtl.blogmgr.core.interceptor;


import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.huangtl.blogmgr.core.spring.MultipleDataSource;



/**
 * 多数据源切换拦截器,根据url路径来切换不同的数据源
 * @author PraiseLord
 * @date 2016年3月15日
 */
public class DataSourceDispatchInteceptor extends HandlerInterceptorAdapter {
	private static Logger logger = LoggerFactory.getLogger(DataSourceDispatchInteceptor.class);
	private Map<String, String> rule;	//{url:dataSourceName}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestURI = request.getRequestURI();
		
		for (String key : rule.keySet()) {
			String url = StringUtils.replace(key, "*", ".*");
			
			if(Pattern.matches(url,requestURI)){
				MultipleDataSource.setDataSourceKey(rule.get(key));
				logger.debug("【{}】匹配【{}】,切到{}数据源",new Object[]{requestURI,url,rule.get(key)});
				break;
			}
		}
		
		return super.preHandle(request, response, handler);
	}
	
	public void setRule(Map<String, String> rule) {
		this.rule = rule;
	}
}
