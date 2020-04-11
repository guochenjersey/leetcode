package zoo.keeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.barriers.DistributedBarrier;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.TimeUnit;

/**
 * Demonstrate two systems where SystemA is barrier for dependent
 *
 * NOTE: the controller must set the barrier before dependent checking. otherwise, dependent will think the barrier
 * doesn't exist and proceed.
 * */
public class CuratorBarrier {
    private static final String ZK_CONNECT = "node1:2181,node2:2181:node3:2181";
    private static final String ZK_BARRIER_PATH = "/barrier";

    public static void main(String... args) throws InterruptedException {
        new Thread(new SystemA()).start();
        for (int i = 0; i < 10; ++i) {
            new Thread(new DependentSystem(i)).start();
        }

        Thread.sleep(Integer.MAX_VALUE);
    }


    static class DependentSystem implements Runnable {

        private final int id;

        public DependentSystem(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            CuratorFramework client = curatorFramework();
            client.start();
            System.out.println(id + " is starting...");
            DistributedBarrier db = new DistributedBarrier(client, ZK_BARRIER_PATH);
            boolean shouldHold = true;
            while(shouldHold) {
                try {
                    System.out.println(id + "  is waiting for barrier");
                    shouldHold = !db.waitOnBarrier(5, TimeUnit.SECONDS);
                    if (!shouldHold) {
                        System.out.println("Barrier removed and " + id + " is proceeding to complete");
                    } else {
                        System.out.println(id + " didn't get barrier and will continue waiting");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            client.close();
        }

        private CuratorFramework curatorFramework() {
            ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);
            return CuratorFrameworkFactory.newClient(ZK_CONNECT, retryPolicy);
        }
    }

    static class SystemA implements Runnable {

        @Override
        public void run() {
            CuratorFramework client = curatorFramework();
            client.start();
            DistributedBarrier db = new DistributedBarrier(client, ZK_BARRIER_PATH);
            try {
                System.out.println("SystemA is starting...");
                db.setBarrier();
                System.out.println("SystemA has set the barrier");
                System.out.println("SystemA is doing sth....");
                Thread.sleep(1000 * 10);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    db.removeBarrier();
                    System.out.println("SystemA removed the barrier");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            client.close();
        }

        private CuratorFramework curatorFramework() {
            ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);
            return CuratorFrameworkFactory.newClient(ZK_CONNECT, retryPolicy);
        }
    }
}

