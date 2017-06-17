package com.huangtl.blogmgr.core.spring;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * 字符串转日期，
 * @author Canaan
 * @date 2017年6月16日
 *
 */
public class StringToDateConverter implements Converter<String, Date> {
	
	@Override
	public Date convert(String source) {
		if(StringUtils.isBlank(source)){return null;}
		
		try {
			Date date = DateUtils.parseDate(source, "yyyy-MM-dd","yyyy-MM-dd HH:mm:ss");
			return date;
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

}
