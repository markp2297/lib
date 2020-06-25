package com.example.libraryTry.demo.libraryTry.Util;

import com.example.libraryTry.demo.libraryTry.DataAccessLayer.User;

public class UserValidator {

    public static boolean isValidUser(User user){
        if(user.getEmail()==null || user.getEmail()=="")
            return false;
        else return true;
    }

}
