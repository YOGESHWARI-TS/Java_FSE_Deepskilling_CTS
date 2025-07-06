package com.library.Librarymanagement2;

import com.library.repository.BookRepository;

public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    
    public BookServiceImpl(BookRepository bookRepository) {
        System.out.println("Constructor injection executed");
        this.bookRepository = bookRepository;
    }
    
    
    public BookServiceImpl() {
        System.out.println("Constructor called");
    }
    
    
    public void setBookRepository(BookRepository bookRepository) {
        System.out.println("Setter injection executed");
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBook(String bookTitle) {
        bookRepository.displayBook(bookTitle);
    }
}