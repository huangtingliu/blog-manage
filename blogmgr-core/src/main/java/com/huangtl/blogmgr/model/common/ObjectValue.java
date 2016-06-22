package com.huangtl.blogmgr.model.common;

import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@SuppressWarnings("serial")
public abstract class ObjectValue implements Serializable {
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	public String newId(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
