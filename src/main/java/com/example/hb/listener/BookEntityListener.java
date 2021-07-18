package com.example.hb.listener;

import com.example.hb.entity.BookEntity;
import com.example.hb.entity.UserEntity;
import com.example.hb.service.BookService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
public class BookEntityListener {

    private static Log log = LogFactory.getLog(UserEntity.class);

    private static BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        BookEntityListener.bookService = bookService;
    }

    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(BookEntity bookEntity) {
        if (bookEntity.getId() == null) {
            log.info("[BOOK AUDIT] About to add a book");
        } else {
            log.info("[BOOK AUDIT] About to update/delete book: " + bookEntity.getId() + ". " + bookEntity.getName());
        }
    }

    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate(BookEntity bookEntity) {
        log.info("[BOOK AUDIT] add/update/delete complete for book: " + bookEntity.getId() + ". " + bookEntity.getName());
        //bookService.getBooks();
    }

    @PostLoad
    private void afterLoad(BookEntity bookEntity) {
        log.info("[BOOK AUDIT] book loaded from database: " + bookEntity.getId() + ". " + bookEntity.getName());
    }

}
