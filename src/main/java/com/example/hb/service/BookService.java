package com.example.hb.service;

import com.example.hb.entity.BookEntity;
import com.example.hb.entity.UserEntity;
import com.example.hb.repository.BookRepository;
import com.example.hb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookEntity> getBooks() {
        return bookRepository.findAll();
    }

    public void saveBook(BookEntity book) {
        bookRepository.save(book);
    }
}
