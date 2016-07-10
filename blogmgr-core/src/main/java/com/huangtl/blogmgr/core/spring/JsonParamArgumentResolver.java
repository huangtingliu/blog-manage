package com.huangtl.blogmgr.core.spring;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.alibaba.fastjson.JSON;

public class JsonParamArgumentResolver implements HandlerMethodArgumentResolver  {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
        //对要解析的参数进行判断，是否需要此解析器
		return parameter.hasParameterAnnotation(JsonParam.class);

	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		String paramName = parameter.getParameterName();
		Class<?> clazz= parameter.getParameterType();
		
		String paramValue = webRequest.getParameter(paramName);
		if(StringUtils.isBlank(paramValue)){return null;}
		
		return JSON.parseObject(paramValue, clazz);

	}

}
