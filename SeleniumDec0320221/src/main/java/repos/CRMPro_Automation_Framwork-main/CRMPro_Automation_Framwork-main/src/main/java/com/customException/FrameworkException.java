package com.customException;

public class FrameworkException extends RuntimeException{
	public FrameworkException(String messg){
		super(messg);
		printStackTrace();
	}
}
