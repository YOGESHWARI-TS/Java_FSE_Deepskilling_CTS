package com.library.service;

import org.springframework.stereotype.Service;

import com.library.repository.BookRepository;
@Service
public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBook() {
        System.out.println("Book: " + bookRepository.getBookDetails());
    }
    
    public void reserveBook() {
    	System.out.println("Reserve book: "+ bookRepository.getMessage());
    }
}

