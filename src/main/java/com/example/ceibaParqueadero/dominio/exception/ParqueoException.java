package com.example.ceibaParqueadero.dominio.exception;

public class ParqueoException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ParqueoException(String message){
		super(message);
	}

}
