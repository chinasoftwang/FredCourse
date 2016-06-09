package com.fred.cn.exception;

public class CourseNotExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CourseNotExistsException(String message, Throwable cause) {
		super(message, cause);

	}

	public CourseNotExistsException(String message) {
		super(message);

	}

}
