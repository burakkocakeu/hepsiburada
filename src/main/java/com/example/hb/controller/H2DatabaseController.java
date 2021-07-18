package com.example.hb.controller;

import com.example.hb.entity.BookEntity;
import com.example.hb.entity.UserEntity;
import com.example.hb.service.BookService;
import com.example.hb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/h2")
public class H2DatabaseController {

    private UserService userService;

    private BookService bookService;

    @Autowired
    public H2DatabaseController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping
    public List<UserEntity> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public String saveUser(@RequestBody UserEntity userEntity) {
        userService.saveUser(userEntity);
        return "success";
    }

    @GetMapping(path = "/book")
    public List<BookEntity> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping(path = "/book")
    public String saveBook(@RequestBody BookEntity bookEntity) {
        bookService.saveBook(bookEntity);
        return "success";
    }
}
