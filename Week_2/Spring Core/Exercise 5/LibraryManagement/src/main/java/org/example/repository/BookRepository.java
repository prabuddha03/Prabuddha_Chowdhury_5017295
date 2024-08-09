package org.example.repository;

import java.util.Arrays;
import java.util.List;

public class BookRepository {
    public List<String> getBooks() {
        return Arrays.asList("The Great Gatsby", "Moby Dick", "1984");
    }
}
