package com.huangtl.blogmgr.model.common;


/**
 * {@link org.pld.core.model.Message} 消息类型
 * @author PraiseLord
 * @date 2016年3月9日
 */
public enum MessageType {
	info,			//系统提示
	success,		//操作成功
	warn,			//警告
	error,			//操作失败
	exception;		//系统异常
}
