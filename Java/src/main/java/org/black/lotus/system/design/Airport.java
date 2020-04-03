package org.black.lotus.system.design;

import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Airport {

    private PriorityQueue<Plane> landRequestQueue;
    private PriorityQueue<Plane> takeOffRequestQueue;
    private RunwayPool runwayPool;
    private ExecutorService scheduler;

    public Airport() {
        this.landRequestQueue = new PriorityQueue<>(10);
        this.takeOffRequestQueue = new PriorityQueue<>(10);
        this.runwayPool = new RunwayPool();
        this.scheduler = Executors.newFixedThreadPool(100);
    }

    public void handleLanding(Plane landingPlane) {
        landingPlane.acknowledge();
        landRequestQueue.add(landingPlane);
        scheduler.submit(() -> {
            Runway runway = runwayPool.acquire();
            landingPlane.land(runway);
        });
    }
}

class Plane implements Comparable<Plane> {
    private int planeId;

    void acknowledge() {
        System.out.println("Has been acked");
    }

    void land(Runway runway) {}

    @Override
    public int compareTo(Plane o) {
        return planeId - o.planeId;
    }
}

class Runway {
    private int runwayId;
}

class RunwayPool {
    private BlockingQueue<Runway> pool;

    RunwayPool() {
        this.pool = new ArrayBlockingQueue<>(10);
    }

    Runway acquire() {
        try {
            return pool.poll(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            return null;
        }
    }

    boolean releaseRunway(Runway runway) {
        try {
            return pool.offer(runway, 5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
}



