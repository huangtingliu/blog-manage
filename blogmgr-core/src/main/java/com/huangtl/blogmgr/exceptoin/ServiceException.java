package com.huangtl.blogmgr.exceptoin;

import com.huangtl.blogmgr.model.common.Message;

/**
 * 业务操作失败异常
 * @author PraiseLord
 * @date 2016年3月9日
 */
public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = -8611580355730108536L;
	
	private final Message message;
	
	public ServiceException(Message message) {
		this.message = message;
	}
	
	public Message getMessageModel() {
		return this.message;
	}
	
	public ServiceException() {
		super();
		message = null;
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.message = null;
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		this.message = null;
	}

	public ServiceException(String message) {
		super(message);
		this.message = null;
	}

	public ServiceException(Throwable cause) {
		super(cause);
		this.message = null;
	}
	
	
}
