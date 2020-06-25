package com.example.libraryTry.demo.libraryTry.DataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
