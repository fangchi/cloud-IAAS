package com.hicomb.cloud.rest;

/**
 * Rese 响应
 */
public class RestResponse {

	/*响应编号*/
	private int responseCode;
	
	/*响应消息*/
	private String responseMsg;

	public RestResponse(int responseCode, String responseMsg) {
		super();
		this.responseCode = responseCode;
		this.responseMsg = responseMsg;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	
	
}
