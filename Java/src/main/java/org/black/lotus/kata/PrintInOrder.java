package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PrintInOrder {
    private final Object firstLock;
    private final Object secondLock;
    private final Object thirdLock;

    public PrintInOrder() {
        this.firstLock = new Object();
        this.secondLock = new Object();
        this.thirdLock = new Object();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (firstLock) {
            printFirst.run();
            synchronized (secondLock) {
                secondLock.notify();
            }
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (secondLock) {
            secondLock.wait();
            printSecond.run();
            synchronized (thirdLock) {
                thirdLock.notify();
            }
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (thirdLock) {
            thirdLock.wait();
            printThird.run();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
    }

}
