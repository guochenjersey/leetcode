package zoo.keeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorEventType;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.TreeSet;

import static org.apache.zookeeper.Watcher.Event.EventType.NodeChildrenChanged;
import static org.apache.zookeeper.Watcher.Event.EventType.NodeCreated;
import static org.apache.zookeeper.Watcher.Event.EventType.NodeDeleted;

public class CuratorWatch {
    private static final String ZK_CONNECT = "node1:2181,node2:2181,node3:2181";
    private static final String ZK_LOCK = "/locks/lock";

    public static void main(String... args) throws Exception {
        new Thread(new MonitorThread()).start();

        CuratorFramework client = curatorFramework();
        client.start();
        if (client.checkExists().forPath(ZK_LOCK) != null) {
            client.delete().guaranteed().forPath(ZK_LOCK);
        }
        client.create().creatingParentContainersIfNeeded()
                .withMode(CreateMode.PERSISTENT)
                .forPath(ZK_LOCK);
        client.setData().forPath(ZK_LOCK, "data".getBytes());
        Thread.sleep(2000);
        client.close();
    }


    private static class MonitorThread implements Runnable {

        @Override
        public void run() {

            CuratorFramework client = curatorFramework();
            try {
                client.start();
                client.getChildren().usingWatcher((Watcher) event -> {
                    if (event.getType().equals(NodeCreated)) {
                        System.out.println("data being deleted");
                    } else if (event.getType().equals(NodeDeleted)) {
                        System.out.println("data being created");
                    } else if (event.getType().equals(NodeChildrenChanged)) {
                        System.out.println("node children changed");
                    }
                }).forPath(ZK_LOCK);

            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(2000 * 100);
                client.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private static CuratorFramework curatorFramework() {
            ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);
            return CuratorFrameworkFactory.newClient(ZK_CONNECT, retryPolicy);
        }
    }

    private static CuratorFramework curatorFramework() {
        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);
        return CuratorFrameworkFactory.newClient(ZK_CONNECT, retryPolicy);
    }
}
