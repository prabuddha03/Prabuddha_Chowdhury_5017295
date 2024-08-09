package org.example.repository;

import java.util.Arrays;
import java.util.List;

public class BookRepository {

    public List<String> getBooks() {
        List<String> books = Arrays.asList("Avengers End Game", "Avengers Infinity War", "Avengers Dooms Day");
        books.forEach(System.out::println);
        return books;
    }
}
