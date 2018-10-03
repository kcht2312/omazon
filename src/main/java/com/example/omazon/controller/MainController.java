package com.example.omazon.controller;

import com.example.omazon.domain.Book;
import com.example.omazon.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
     private BooksRepository booksRepository;

    @GetMapping("/")
    public String home(Map<String, Object> model) {
        return "home";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model){
        Iterable<Book> books = booksRepository.findAll();
        model.put("books", books);
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String name, @RequestParam String author, Map<String, Object> model){
        Book book = new Book(name,author);

        booksRepository.save(book);

        Iterable<Book> books = booksRepository.findAll();
        model.put("books", books);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model){

        Iterable<Book> books;

        if(filter != null && !filter.isEmpty()) {
            books = booksRepository.findByAuthor(filter);
            model.put("books", books);
        }else{
            books = booksRepository.findAll();
            model.put("books", books);
        }
        return "main";
    }
}
