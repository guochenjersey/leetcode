package org.black.lotus.kata;

import org.black.lotus.marker.Important;
import org.black.lotus.marker.MultiThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Print t1, t2, t3 thread in sequence
 */
@MultiThread
@Important
public class PrintT1T2T3 {
    public static void main(String... args) {
        ReentrantLock t1Lock = new ReentrantLock(true);
        Condition t1Condition = t1Lock.newCondition();
        AtomicBoolean t1Completed = new AtomicBoolean(false);
        AtomicBoolean t2Completed = new AtomicBoolean(false);


        ReentrantLock t2Lock = new ReentrantLock(true);
        Condition t2Condition = t2Lock.newCondition();

        Thread t1 = new Thread(() -> {
            t1Lock.lock();
            try {
                System.out.println("t1");
                t1Completed.set(true);
                t1Condition.signalAll();
            } finally {
                t1Lock.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            t1Lock.lock();
            try {
                while (!t1Completed.get()) {
                    t1Condition.await(100, TimeUnit.MILLISECONDS);
                }
                System.out.println("t2");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                t1Lock.unlock();
            }
            t2Completed.set(true);
            try {
                t2Lock.lock();
                t2Condition.signalAll();
            } finally {
                t2Lock.unlock();
            }
        });

        Thread t3 = new Thread(() -> {
           t2Lock.lock();
            try {
                while (!t2Completed.get()) {
                    t2Condition.await(100, TimeUnit.MILLISECONDS);
                }
                System.out.println("t3");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                t2Lock.unlock();
            }
        });

        t2.start();
        t1.start();
        t3.start();
    }
}


