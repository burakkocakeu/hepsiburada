package com.example.hb.repository;

import com.example.hb.entity.BookEntity;
import com.example.hb.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
