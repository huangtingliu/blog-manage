package com.huangtl.blogmgr.core.spring;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * spring mvc参数解析类型，将json字符参数转化为对象
 * @date 2016年7月26日
 * @author PraiseLord
 */
@Target(ElementType. PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Json {
	
}
