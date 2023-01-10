package com.patho.clinic.payloads;

public class RequestPayload {
	
	private Long id;
	private String param;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getParam() {
		return param;
	}
	
	public void setParam(String param) {
		this.param = param;
	}
	
	@Override
	public String toString() {
		return "RequestPayload [id=" + id + ", param=" + param + "]";
	}
}
