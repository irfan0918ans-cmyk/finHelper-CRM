package com.proj.finHelper.exception;

public class LenderNotFoundException extends RuntimeException{

    public LenderNotFoundException(String message){
        super(message);
    }
    public LenderNotFoundException(){
        super();
    }
}
