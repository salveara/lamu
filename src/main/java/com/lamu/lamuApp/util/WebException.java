package com.lamu.lamuApp.util;

public class WebException extends Exception{

	private String userMessage;
	private String technicalMessage;
	private Exception originalException;
	private String idException;
	
	public String getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	public String getTechnicalMessage() {
		return technicalMessage;
	}
	public void setTechnicalMessage(String technicalMessage) {
		this.technicalMessage = technicalMessage;
	}
	public Exception getOriginalException() {
		return originalException;
	}
	public void setOriginalException(Exception originalException) {
		this.originalException = originalException;
	}
	public String getIdException() {
		return idException;
	}
	public void setIdException(String idException) {
		this.idException = idException;
	}
	
}
