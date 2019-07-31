package org.black.lotus.kata;

import org.apache.commons.lang3.RandomUtils;
import org.black.lotus.marker.MultiThread;

import java.util.concurrent.Semaphore;

/**
 * Need to 2 Hydrogen and 1 oxygen to create a H2O
 * */
@MultiThread
public class H2O {

    public static void main(String... args) throws InterruptedException {
        Semaphore hydroSemaphore = new Semaphore(0);
        Semaphore oxySemaphore = new Semaphore(0);

        new Thread(() -> {
            int h2oNum = 0;
            try {
                while (true) {
                    hydroSemaphore.acquire(2);
                    oxySemaphore.acquire(1);
                    System.out.println("H2O " + ++h2oNum);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            int hydroNum = 0;
            try {
                while (true) {
                    int nextHydroTime = RandomUtils.nextInt(1, 2);
                    Thread.sleep(1000 * nextHydroTime);
                    hydroSemaphore.release(1);
                    System.out.println("hydro num " + ++hydroNum);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            int oxyNum = 0;
            while(true) {
                try {
                    int nextOxyTime = RandomUtils.nextInt(1, 4);
                    Thread.sleep(1000 * nextOxyTime);
                    oxySemaphore.release(1);
                    System.out.println("oxy num " + ++oxyNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(1000 * 1000);
    }
}
