package kafka;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String... args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2000);
        Set<ListenableFutureTask<Boolean>> tasks = new HashSet<>();
        ListeningExecutorService les = MoreExecutors.listeningDecorator(es);
        Instant start = Instant.now();
        for (int i = 0; i < 2000; ++i) {
            ListenableFutureTask<Boolean> task = ListenableFutureTask.create(new Producer(i));
            tasks.add(task);
            les.submit(task);
        }

        Futures.whenAllComplete(tasks).run(() -> {
            Instant end = Instant.now();
            System.out.println(Duration.between(start, end).toMillis() / 1000);
        }, es);

        Thread.sleep(Integer.MAX_VALUE);
    }
}
