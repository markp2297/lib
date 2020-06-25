package com.example.libraryTry.demo.libraryTry.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(int id) {
        super(("User id not there : " + id));
    }

}
