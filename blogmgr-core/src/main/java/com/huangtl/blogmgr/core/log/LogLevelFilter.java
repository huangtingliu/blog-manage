package com.huangtl.blogmgr.core.log;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;


/**
 * @author PraiseLord
 * @date 2016年2月25日
 * @param <E>
 */
public class LogLevelFilter<E> extends Filter<E> {

	/**
	 * 大于指定的日志级别
	 */
	private Level greaterThan;
	/**
	 * 小于指定的日志级别
	 */
	private Level lessThan;
	
	@Override
	public FilterReply decide(E eventObject) {
		
		if(greaterThan == null && lessThan==null){return FilterReply.NEUTRAL;}
		
		LoggingEvent event = (LoggingEvent) eventObject;
		
		if(greaterThan!=null ){
			if(event.getLevel().toInt()>greaterThan.toInt()){
				if(lessThan == null ){
					return FilterReply.ACCEPT;
				}else if(event.getLevel().toInt()<lessThan.toInt()){
					return FilterReply.ACCEPT;
				}
			}
		}else if(event.getLevel().toInt()<lessThan.toInt()){
			return FilterReply.ACCEPT;
		}
		
		return FilterReply.DENY;
	}
	
	
	public void setGreaterThan(Level level) {
		this.greaterThan = level;
	}
	public void setLessThan(Level level) {
		this.lessThan = level;
	}
}
