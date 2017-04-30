package com.huangtl.blogmgr.core.exception;

import com.huangtl.blogmgr.model.common.Message;

/**
 * 参数验证失败异常
 * @author Canaan
 * @date 2017年4月30日
 *
 */
public class ArgumentValidationFailureException extends ApplicationRuntimeException {
	private static final long serialVersionUID = -865936476641252937L;
private final Message message;
	
	public ArgumentValidationFailureException(Message message) {
		this.message = message;
	}
	
	public Message getMessageModel() {
		return this.message;
	}
	
	public ArgumentValidationFailureException() {
		super();
		message = null;
	}

	public ArgumentValidationFailureException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.message = null;
	}

	public ArgumentValidationFailureException(String message, Throwable cause) {
		super(message, cause);
		this.message = null;
	}

	public ArgumentValidationFailureException(String message) {
		super(message);
		this.message = null;
	}

	public ArgumentValidationFailureException(Throwable cause) {
		super(cause);
		this.message = null;
	}
}
