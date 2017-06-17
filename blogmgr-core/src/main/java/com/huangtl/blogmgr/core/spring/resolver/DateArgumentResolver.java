package com.huangtl.blogmgr.core.spring.resolver;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class DateArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		Class<?> clazz =  parameter.getParameterType();
		return clazz.equals(Date.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		String paramName = parameter.getParameterName();
		String paramValue = webRequest.getParameter(paramName);
		if(StringUtils.isBlank(paramValue)){return null; }
		
		return DateUtils.parseDate(paramValue, "yyyy-MM-dd","yyyy-MM-dd HH:mm:ss");
	}
}
