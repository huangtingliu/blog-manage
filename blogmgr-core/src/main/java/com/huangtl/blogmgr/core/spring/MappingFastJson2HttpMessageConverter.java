package com.huangtl.blogmgr.core.spring;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class MappingFastJson2HttpMessageConverter extends AbstractGenericHttpMessageConverter<Object> {
	
	public MappingFastJson2HttpMessageConverter() {
		super(MediaType.APPLICATION_JSON, new MediaType("application", "*+json"));
	}
	@Override
	protected boolean supports(Class<?> clazz) {
		return true;
	}
	
	@Override
	protected void writeInternal(Object t, Type type, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {
		JSON.writeJSONStringTo(t, new PrintWriter(outputMessage.getBody()),SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.WriteDateUseDateFormat);
	}
	
	@Override
	protected Object readInternal(Class<? extends Object> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		// TODO 未知的方法，先不做处理
		throw new UnsupportedOperationException();
	}
	
	@Override
	public Object read(Type type, Class<?> contextClass, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException {
		// TODO 未知的方法，先不做处理
		throw new UnsupportedOperationException();
	}
	
}
