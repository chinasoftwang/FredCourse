package com.fred.cn.util;

public class ResultObj {

	public final static String CODE_OK = "200";

	public final static String CODE_BAD_REQUEST = "400";

	public final static String CODE_FORBIDDEN = "403";

	public final static String CODE_SERVER_ERROR = "500";

	private String code = ResultObj.CODE_OK;

	private String message = "SUCCESS";

	private Object data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
