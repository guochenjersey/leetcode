package org.black.lotus.system.design.reddit;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.MoreExecutors;
import org.apache.commons.lang3.RandomUtils;
import org.black.lotus.marker.Important;
import redis.clients.jedis.Jedis;

import java.time.Instant;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * A post will be ranked by (vote up times * constant multiplier + posted time)
 * As time goes by the value will be lower and lower.
 * Solution: Redis zset is a perfect data structure for time series data.
 * note that: Any hot search project should be based on the model
 *
 * */
@Important
public class RedditVoteSystem {

    public static void main(String... args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(5, 50, 1000,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000), (r, executor) -> {
                    System.out.println("Can't take more tasks as the queue is full now");
                    executor.getActiveCount();
                });
        ListenableFutureTask<Boolean> postProducerTask = createUsers();
        ListenableFutureTask<Boolean> userProducerTask = createPosts();

        executorService.submit(postProducerTask);
        executorService.submit(userProducerTask);
        Futures.whenAllComplete(postProducerTask, userProducerTask).run(() -> {
            int idNo = RandomUtils.nextInt(0, 100000);
            String userId = "USER:" + idNo;
            Jedis jedis = new Jedis("node1");

        }, executorService);
    }

    private static ListenableFutureTask<Boolean> createPosts() {
        return ListenableFutureTask.create(new UserProducer());
    }

    private static ListenableFutureTask<Boolean> createUsers() {
        return ListenableFutureTask.create(new PostProducer());
    }
}

