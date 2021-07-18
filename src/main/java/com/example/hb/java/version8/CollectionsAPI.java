package com.example.hb.java.version8;

import com.example.hb.java.version8.resources.Product;

import java.util.*;

public class CollectionsAPI {

    public static void main(String[] args) {

        List<Product> list2=new ArrayList<>();
        list2.add(new Product(1, "HP", 1510f));
        list2.add(new Product(2, "Sony", 3870f));
        list2.add(new Product(3, "Dell", 1720f));
        System.out.println(Collections.singleton("My singleton sout..."));
        System.out.println("-------------");
        System.out.println("Sorting on the basis of name...");
        Collections.sort(list2, (p1, p2) -> {
            return p1.getName().compareTo(p2.getName());
        });
        Collections.sort(list2, Comparator.comparing(p -> p.getName()));
        for (Product p : list2) {
            System.out.println(p.getId() + " " + p.getName() + " " + p.getPrice());
        }

        System.out.println("-------------");
        Collections.sort(list2, Comparator.comparing(p -> p.getPrice()));
        for (Product p : list2) {
            System.out.println(p.getId() + " " + p.getName() + " " + p.getPrice());
        }
        System.out.println("-------------");
        Comparator<Product> comparator = Comparator.comparing(Product::getId);
        Product[] pList = new Product[]{list2.get(1), list2.get(2), list2.get(0)};
        Arrays.sort(pList, comparator);
        for (Product p : pList) {
            System.out.println(p.getId() + " " + p.getName() + " " + p.getPrice());
        }

    }

}
