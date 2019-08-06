package org.black.lotus.system.design;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;

public class Airport {

    private List<Plane> landingRequestPlanes;
    private List<Plane> takeOffRequestPlanes;
    private RunwayPool runwayPool;
    private ExecutorService scheduler;

    public Airport() {
        this.landingRequestPlanes = new ArrayList<>();
        this.takeOffRequestPlanes = new ArrayList<>();
        this.runwayPool = new RunwayPool();
        this.scheduler = Executors.newFixedThreadPool(100);
    }

    public void handleLanding(Plane landingPlane) {
        landingPlane.acknowledge();
        landingRequestPlanes.add(landingPlane);
        scheduler.submit(() -> {
            Runway runway = runwayPool.acquire();
            landingPlane.land(runway);
        });
    }
}

class Plane {
    private int planeId;

    void acknowledge() {
        System.out.println("Has been acked");
    }

    void land(Runway runway) {

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
            return pool.take();
        } catch (InterruptedException e) {
            return null;
        }
    }

    void releaseRunway(Runway runway) {
        try {
            pool.put(runway);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



