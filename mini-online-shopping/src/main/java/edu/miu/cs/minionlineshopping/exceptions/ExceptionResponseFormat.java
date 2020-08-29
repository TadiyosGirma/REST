package edu.miu.cs.minionlineshopping.exceptions;

import java.util.Date;

public class ExceptionResponseFormat {

	private Date time;
	private String message;
	private String detail;

	public ExceptionResponseFormat(Date time, String message, String detail) {
		super();
		this.time = time;
		this.message = message;
		this.detail = detail;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

//	@Override
//	public String toString() {
//		return "ExceptionResponseFormat [time=" + time + ", message=" + message + ", detail=" + detail + "]";
//	}
}
