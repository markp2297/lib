package com.example.libraryTry.demo.libraryTry.Controller;

import com.example.libraryTry.demo.libraryTry.DataAccessLayer.Book;
import com.example.libraryTry.demo.libraryTry.DataAccessLayer.BookRepository;
import com.example.libraryTry.demo.libraryTry.DataAccessLayer.IssuedBooksRepository;
import com.example.libraryTry.demo.libraryTry.DataAccessLayer.UserRepository;
import com.example.libraryTry.demo.libraryTry.Util.BookValidator;
import com.example.libraryTry.demo.libraryTry.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class BookResource {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    IssuedBooksRepository issuedBooksRepository;

    @Autowired
    private BookRepository repository;

    BookValidator validator = new BookValidator();

    @GetMapping("/hi")
    public String sayHello(){
        return "Hello from book controller";
    }

    //find all books
    @GetMapping("/books")
    List<Book> findAll() {
        LOGGER.info("findAll called");
        List<Book> list = new ArrayList<Book>();
        //list = repository.findAll();
        try {
            list = repository.findAll();
            if (list.size() == 0) {
                LOGGER.severe("No book found");
                throw new BookNotFoundException(5);
            }
        }
        catch(BookNotFoundException exc)
        {
            LOGGER.severe(exc.toString());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Book Found", exc);
        }
        return list;

    }

    @PostMapping("/books")
    //201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    Book newBook(@RequestBody Book newBook) {
        if(validator.isValid(newBook)){
            return repository.save(newBook);
        }
        else{
            LOGGER.severe("New Book is not valid");
            return null;
        }
    }

    @GetMapping(value = "/searchBooksBySubject")
    public List<Book> searchBooksBySubject(@RequestParam(value= "q") String subject){
        List<Book> books = bookRepository.findAll();
        ArrayList<Book> list = new ArrayList<Book>();
        for(Book book: books){
            if(book.getSubject().equals(subject)) list.add(book);
        }
        return list;
    }


}
