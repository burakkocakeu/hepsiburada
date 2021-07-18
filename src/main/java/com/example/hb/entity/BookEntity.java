package com.example.hb.entity;

import com.example.hb.listener.BookEntityListener;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@EntityListeners(BookEntityListener.class)
@Entity
@Getter
@Setter
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
