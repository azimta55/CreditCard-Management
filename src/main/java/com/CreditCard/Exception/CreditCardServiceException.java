package com.CreditCard.Exception;



public class CreditCardServiceException extends RuntimeException {
	
	
	private static final long serialVersionUID = -470180507998010368L;

	private String errorcode;
	private String errorMessage;
	
	
	public CreditCardServiceException(String errorcode) {
		super();
		this.errorcode = errorcode;
		this.errorMessage = errorMessage;
	}


	public String getErrorcode() {
		return errorcode;
	}


	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

		
	}
	


