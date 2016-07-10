package com.huangtl.blogmgr.model.common;

import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.huangtl.blogmgr.core.util.ValidationUtils;

@SuppressWarnings("serial")
public abstract class ObjectValue implements Serializable {
	
	/**
	 * 检测字段的有效性
	 * @return
	 */
	public Message checkValidity(String... exceptFields){
		return ValidationUtils.validate(this, exceptFields);
	}
	
	public String newId(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
