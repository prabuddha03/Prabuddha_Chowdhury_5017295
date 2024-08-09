package org.example.service;

import org.example.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printBooks() {

        System.out.println(bookRepository.getBooks());
        System.out.println("Dependency Injection Verified");
    }
}
