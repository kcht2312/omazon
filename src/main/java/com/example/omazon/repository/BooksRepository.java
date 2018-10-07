package com.example.omazon.repository;

import com.example.omazon.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BooksRepository extends CrudRepository<Book, Integer> {

    List<Book> findByWriter(String author);
}
