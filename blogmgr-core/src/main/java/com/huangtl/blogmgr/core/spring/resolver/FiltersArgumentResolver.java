package com.huangtl.blogmgr.core.spring.resolver;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.alibaba.fastjson.JSON;
import com.huangtl.blogmgr.model.extjs.Filter;
import com.huangtl.blogmgr.model.extjs.FilterCollection;

/**
 * spring mvc 参数解析器，解析extjs中filter过虑参数。将其封装成{@code com.huangtl.blogmgr.model.extjs.FilterCollection}<br>
 * 后台参数如：[{"property":"fName","value":"sdf","operator":"like"}]
 * @date 2016年7月26日
 * @author PraiseLord
 */
public class FiltersArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		Class<?> clazz =  parameter.getParameterType();
		return clazz.equals(FilterCollection.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		
			FilterCollection filterCollection = new FilterCollection();
			String paramName = parameter.getParameterName();
			String paramValue = webRequest.getParameter(paramName);
			if(StringUtils.isBlank(paramValue)){return filterCollection; }
			
			List<Filter> filters = JSON.parseArray(paramValue, Filter.class);
			
			filterCollection.addFilter(filters);
			
			return filterCollection;
		
	}

}
