package com.huangtl.blogmgr.core.exception;


/**
 * 应用程序运行异常
 * @author PraiseLord
 * @date 2016年3月9日
 */
public class ApplicationRuntimeException extends RuntimeException {
	private static final long serialVersionUID = -8611580355730108536L;
	
	public ApplicationRuntimeException() {
		super();
	}

	public ApplicationRuntimeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ApplicationRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationRuntimeException(String message) {
		super(message);
	}

	public ApplicationRuntimeException(Throwable cause) {
		super(cause);
	}
	
	
}
