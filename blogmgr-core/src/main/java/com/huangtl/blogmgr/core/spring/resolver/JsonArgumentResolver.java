package com.huangtl.blogmgr.core.spring.resolver;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.alibaba.fastjson.JSON;

public class JsonArgumentResolver implements HandlerMethodArgumentResolver{

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
        //对要解析的参数进行判断，是否需要此解析器
		return parameter.hasParameterAnnotation(Json.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		Class<?> clazz= parameter.getParameterType();
		String paramName = parameter.getParameterName();
		String paramValue = webRequest.getParameter(paramName);
		if(StringUtils.isBlank(paramValue)){return null;}
		
		if(clazz.equals(List.class)){	//是一个集合
			Class<?> listItemClass = null;
			Type supperType = parameter.getNestedGenericParameterType();
			if(supperType instanceof ParameterizedType){
				Type[] paramTypes = ((ParameterizedType) supperType).getActualTypeArguments();
				if (paramTypes.length>0) {
					listItemClass = (Class<?>) paramTypes[0];
				}
			}
			return JSON.parseArray(paramValue,listItemClass);
		}
		
		return  JSON.parseObject(paramValue, clazz);

	}
	
}
