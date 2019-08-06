package com.cafe24.noahshop.frontend.dto;

public class ResponseJSONResult extends JSONResult{
	private String result;  //success, fail
	private String message; //if fail, set
	private Object data;    //if success, set

	public static ResponseJSONResult success(Object data) {
		return new ResponseJSONResult("success", null, data);
	}

	public static ResponseJSONResult fail(String message) {
		return new ResponseJSONResult("fail", message, null);
	}
	
	private ResponseJSONResult(String result, String message, Object data) {
		this.result = result;
		this.message = message;
		this.data = data;
	}
	
	public String getResult() {
		return result;
	}
	public String getMessage() {
		return message;
	}
	public Object getData() {
		return data;
	}
}
