package com.example.omazon.controller;

import com.example.omazon.domain.Book;
import com.example.omazon.domain.User;
import com.example.omazon.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model){
        Iterable<Book> books = booksRepository.findAll();

        if(filter != null && !filter.isEmpty()) {
            books = booksRepository.findByWriter(filter);
        }else{
            books = booksRepository.findAll();
        }

        model.addAttribute("books", books);
        model.addAttribute("filter", filter);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String name,
            @RequestParam String writer, Map<String, Object> model){
        Book book = new Book(name,writer,user);

        booksRepository.save(book);

        Iterable<Book> books = booksRepository.findAll();
        model.put("books", books);

        return "main";
    }
}
