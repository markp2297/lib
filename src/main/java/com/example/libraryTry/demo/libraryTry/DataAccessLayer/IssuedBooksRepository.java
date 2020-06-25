package com.example.libraryTry.demo.libraryTry.DataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IssuedBooksRepository extends JpaRepository<IssuedBooks, Integer> {
}
