package com.example.hb.java.version8;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Threads {

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 is running... [" + Thread.currentThread().getId() + "]");

                Long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                System.out.println("Thread 1 is running... [" + Thread.currentThread().getId() + "] -> " +
                        "Used Memory: " + (memoryUsed) + " | " +
                        "Free Memory: " + Runtime.getRuntime().freeMemory());
            }
        };
        Thread t1 = new Thread(r1);
        t1.start();
        System.out.println("------------- Async log here! [" + Thread.currentThread().getId() + "]");

        Runnable r2 = () -> System.out.println("Thread 2 is running... [" + Thread.currentThread().getId() + "]");
        Thread t2 = new Thread(r2);
        t2.start();

        Thread t3 = new Thread(() -> System.out.println("Thread 3 is running... [" + Thread.currentThread().getId() + "]"));
        t3.start();

        System.out.println("Total memory is " + Runtime.getRuntime().totalMemory());
        System.out.println("Free memory is " + Runtime.getRuntime().freeMemory());

        var ref = new Object() {
            Long maxMemory = 0L;
        };

        // Used Memory is 671358896
        /*Arrays.stream(new int[8320]).forEach(index -> new Thread(() -> {
            Long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            System.out.println("Thread " + index + " is running... [" + Thread.currentThread().getId() + "] -> " +
                    "Used Memory: " + (memoryUsed) + " | " +
                    "Free Memory: " + Runtime.getRuntime().freeMemory());
            ref.maxMemory = memoryUsed > ref.maxMemory ? memoryUsed : ref.maxMemory;
        }).start());*/

        // Used Memory is 671354456
        /*IntStream.range(1, 8321).forEach(index -> new Thread(() -> {
            Long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            System.out.println("Thread " + index + " is running... [" + Thread.currentThread().getId() + "] -> " +
                    "Used Memory: " + (memoryUsed) + " | " +
                    "Free Memory: " + Runtime.getRuntime().freeMemory());
            ref.maxMemory = memoryUsed > ref.maxMemory ? memoryUsed : ref.maxMemory;
        }).start());*/

        // Used Memory is 671318568
        /*for (int i=1; i<8320; i++) {
            int finalI = i;
            new Thread(() -> {
                Long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                System.out.println("Thread " + finalI + " is running... [" + Thread.currentThread().getId() + "] -> " +
                        "Used Memory: " + (memoryUsed) + " | " +
                        "Free Memory: " + Runtime.getRuntime().freeMemory());
                ref.maxMemory = memoryUsed > ref.maxMemory ? memoryUsed : ref.maxMemory;
            }).start();
        }*/

        System.out.println("Max memory used is " + ref.maxMemory);

    }
}
