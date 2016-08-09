package com.huangtl.blogmgr.core.spring.resolver;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.alibaba.fastjson.JSON;
import com.huangtl.blogmgr.model.extjs.Sort;
import com.huangtl.blogmgr.model.extjs.SortCollection;

public class SortArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		Class<?> clazz =  parameter.getParameterType();
		return clazz.equals(SortCollection.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		
		SortCollection sortCollection = new SortCollection();
		String paramName = parameter.getParameterName();
		String paramValue = webRequest.getParameter(paramName);
		if(StringUtils.isBlank(paramValue)){return sortCollection; }
		
		List<Sort> sorts = JSON.parseArray(paramValue, Sort.class);
		
		sortCollection.addSort(sorts);
		
		return sortCollection;
	}

}
