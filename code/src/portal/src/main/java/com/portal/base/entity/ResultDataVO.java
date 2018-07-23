package com.portal.base.entity;

public class ResultDataVO<T> {
	private int code;
	private String message;
	private T result;

	public ResultDataVO() {
		this.code = 200;
	}

	public ResultDataVO(int code) {
		this.code = code;
	}

	public ResultDataVO(int code, String message, T result) {
		this.code = code;
		this.message = message;
		this.result = result;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

}
