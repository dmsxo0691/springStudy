package com.example.springStudy.chap02.handle;

public class DuplicateMemberException extends RuntimeException{
    public DuplicateMemberException(String message){
        super(message);
    }
}
