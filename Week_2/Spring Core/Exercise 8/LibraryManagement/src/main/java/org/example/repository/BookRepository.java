package org.example.repository;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public List<String> getBooks() {
        return Arrays.asList("The Great Gatsby", "Moby Dick", "1984");
    }
}
