package com.linktic.pruebatecnica.generic.response;

import java.io.Serializable;

public class GenericoResponse implements Serializable {

	private static final long serialVersionUID = 1480596635187427596L;

	private String status = "success";
	private String code = "200";
	private String message = "OK";
	private Object data;

	public GenericoResponse() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

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
