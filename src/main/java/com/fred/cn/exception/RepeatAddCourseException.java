package com.fred.cn.exception;

/**
 * 重复添加相同课程
 * 
 * @author wanganlei
 * 
 */
public class RepeatAddCourseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RepeatAddCourseException(String message) {

		super(message);
	}

	public RepeatAddCourseException(String message, Throwable cause) {
		super(message, cause);
	}

}
