package com.example.libraryTry.demo.libraryTry.Controller;

import com.example.libraryTry.demo.libraryTry.DataAccessLayer.User;
import com.example.libraryTry.demo.libraryTry.DataAccessLayer.UserRepository;
import com.example.libraryTry.demo.libraryTry.Util.UserValidator;
import com.example.libraryTry.demo.libraryTry.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class UserResource {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Autowired
    private UserRepository repository;

    //find
    @GetMapping("/users")
    List<User> findAll(){
        return repository.findAll();
    }

    @PostMapping("users")
    //return 201 reated ani
    @ResponseStatus(HttpStatus.CREATED)
    User newUser(@RequestBody User newUser) throws Exception {
        if(UserValidator.isValidUser(newUser))
            return repository.save(newUser);
        else throw new Exception();
    }
    //find
    @GetMapping("/users/{id}")
    User findOne(@PathVariable int id) {
        LOGGER.info("/users/{id} called with id "+ id);
        //Optional<User> user = repository.findById(id);
        //return user.get();

        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

    }




}
