package com.huangtl.blogmgr.model.extjs;

import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.alibaba.fastjson.JSON;
import com.huangtl.blogmgr.core.dao.Operator;

/**
 * stroe对象中的filter.用来数据查询过滤
 * @date 2016年7月26日
 * @author PraiseLord
 */
public class Filter {
	private String property;			//过滤字段
	private String value;				//过滤值
	private Operator operator;			//操作类型
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		if(value!=null && Pattern.matches("^\\[.*\\]$", value)){
			List<String> list = JSON.parseArray(value, String.class);
			StringBuilder sb = new StringBuilder();
			for (String val : list) {
				sb.append(val).append(",");
			}
			this.value = sb.deleteCharAt(sb.length()-1).toString();
		}else{
			this.value = value;
		}
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
