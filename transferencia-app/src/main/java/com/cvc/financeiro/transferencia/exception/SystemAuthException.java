package com.cvc.financeiro.transferencia.exception;

import org.springframework.http.HttpStatus;

public class SystemAuthException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public SystemAuthException(String message) {
		super(message);
	}

	public SystemAuthException(HttpStatus status, String message) {
		super(message);
	}

}
