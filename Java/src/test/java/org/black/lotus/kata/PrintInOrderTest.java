package org.black.lotus.kata;

import org.apache.commons.lang3.event.EventUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import sun.misc.Unsafe;

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

        Source source = new Source();

        EventUtils.addEventListener(source, Listener.class, new Listener());
        source.doSth();
        System.out.println();
        Unsafe.getUnsafe().compareAndSwapInt(source, 1, 1, 2);
    }

    static class Listener {

    }

    static class Source {
        public void addListener(Listener listener) {

        }

        public void doSth() {
            System.out.println("dosth");
        }
    }
}