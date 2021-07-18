package com.example.hb.java.version8;

import com.example.hb.java.version8.resources.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("ankit");
        list.add("mayank");
        list.add("irfan");
        list.add("jai");

        list.forEach(System.out::println);
        System.out.println("-------------");
        list.forEach((n)-> System.out.println(n));
        System.out.println("-------------");
        System.out.println(list.stream().findFirst().get());
        System.out.println("-------------");
        System.out.println(list.stream().findFirst());
        System.out.println("-------------");

        List<Product> list2=new ArrayList<>();
        list2.add(new Product(1, "HP", 1510f));
        list2.add(new Product(2, "Sony", 3870f));
        list2.add(new Product(3, "Dell", 1720f));

        List<Float> list3 = list2.stream().map(Product::getPrice).collect(Collectors.toList());
        System.out.println(list3);
        System.out.println("-------------");

        int[] numbers = {1,2,3,4,5,6,7,8,9};
        System.out.println("Double Numbers");
        Arrays.stream(numbers).map(x -> x * 2).forEach(System.out::println);
    }

}
