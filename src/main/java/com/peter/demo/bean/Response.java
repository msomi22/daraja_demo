/**
 * 
 */
package com.peter.demo.bean;

/**
 * @author t_pnjeru
 *
 */
public class Response {

	private int statusCode;
	private String description;

	public Response() {

	}

	public Response(int code,String message) {
		this.statusCode = code;
		this.description = message;
	}

	@Override
	public String toString() {
		return "Response [statusCode=" + statusCode + ", description=" + description + "]";
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
