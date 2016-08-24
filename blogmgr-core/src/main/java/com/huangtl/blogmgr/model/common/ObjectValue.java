package com.huangtl.blogmgr.model.common;

import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.huangtl.blogmgr.core.util.ValidationUtils;

@SuppressWarnings("serial")
public abstract class ObjectValue implements Serializable {
	
	/**
	 * 带过滤的验证字段的有效性
	 * @param exceptFields 排除验证的字段
	 * @param allowNull 是否验证为null的字段，默认false,验证为null字段
	 * @return 当验证失败时 返回 Message.error 类型,否则返回Message.success
	 */
	public Message checkValidity(boolean allowNull,String... exceptFields){
		return ValidationUtils.validate(this, allowNull,exceptFields);
	}
	/**
	 * 验证字段的有效性
	 * @return 当验证失败时 返回 Message.error 类型,否则返回Message.success
	 */
	public Message checkValidity(){
		return ValidationUtils.validate(this, false,ArrayUtils.EMPTY_STRING_ARRAY);
	}
	
	public String newId(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
