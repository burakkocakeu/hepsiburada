package com.example.hb.java.version8.resources;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
