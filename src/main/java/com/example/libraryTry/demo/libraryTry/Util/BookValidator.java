package com.example.libraryTry.demo.libraryTry.Util;

import com.example.libraryTry.demo.libraryTry.DataAccessLayer.Book;

public class BookValidator {

    public boolean isValid(Book book){
        if(book.getTitle()=="" || book.getTitle() == null)
            return false;
        return true;
    }

}
