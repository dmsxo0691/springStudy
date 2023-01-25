package com.example.springStudy.chap05.spring;

public class DuplicateMemberException extends RuntimeException{
    public DuplicateMemberException(String message){
        super(message);
    }
}
