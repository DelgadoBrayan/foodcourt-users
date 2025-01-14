package com.service.users.infrastucture.exception;

public class InvalidAuthException extends RuntimeException{
    public InvalidAuthException(String message){
        super(message);
    }
}
