package com.example.hb.java.version8;

import com.example.hb.java.version8.interfaces.Calcy;
import com.example.hb.java.version8.interfaces.Talky;
import com.example.hb.java.version8.interfaces.TalkyParam;

import java.util.*;

public class LambdaExpression {

    public static void main(String[] args) {

        /* Lambda syntax #1 */
        Talky t = () -> {
          return "I have nothing to say!";
        };

        /* Lambda syntax #2 */
        t = () -> "I have nothing to say!";

        System.out.println(t.talk());
        System.out.println("-------------");

        TalkyParam tt = (word) -> {
          String s1 = "Welcome to ";
          String s2 = s1 + word;

          return s2;
        };
        System.out.println(tt.talk("world!"));
        System.out.println("-------------");

        Calcy c = (a, b) -> (a+b);
        System.out.println(c.calc(2,5));
        System.out.println("-------------");

        List<String> list=new ArrayList<>();
        list.add("ankit");
        list.add("mayank");
        list.add("irfan");
        list.add("jai");

        list.forEach(System.out::println); // Not a lambda example but cool code piece anyways.
        System.out.println("-------------");
        list.forEach((n)-> System.out.println(n));

    }

}
