package com.example.libraryTry.demo.libraryTry.exception;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(int id) {

        super("Book id not found : " + id);
    }
}
