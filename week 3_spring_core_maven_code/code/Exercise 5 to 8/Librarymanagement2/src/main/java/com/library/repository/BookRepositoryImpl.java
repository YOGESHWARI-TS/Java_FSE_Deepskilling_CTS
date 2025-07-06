package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {
    @Override
    public void displayBook(String bookTitle) {
        System.out.println("Saving book: " + bookTitle);
    }
}