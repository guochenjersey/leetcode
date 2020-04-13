package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

public class PrintInOrderTest {

    public static void main(String... args) throws InterruptedException {
        PrintInOrder printInOrder = new PrintInOrder();
        ExecutorService es = Executors.newFixedThreadPool(3);
        es.submit(() -> {
            try {
                printInOrder.first(() -> System.out.println("A"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        es.submit(() -> {
            try {
                printInOrder.third(() -> System.out.println("C"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        es.submit(() -> {
            try {
                printInOrder.second(() -> System.out.println("B"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}