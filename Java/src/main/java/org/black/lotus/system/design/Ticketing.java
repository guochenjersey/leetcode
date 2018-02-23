package org.black.lotus.system.design;

import static org.black.lotus.system.design.Ticketing.INCUR_KEY;
import static org.black.lotus.system.design.Ticketing.ZSET_KEY;

import com.lambdaworks.redis.LettuceFutures;
import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisFuture;
import com.lambdaworks.redis.api.StatefulRedisConnection;
import com.lambdaworks.redis.api.async.RedisAsyncCommands;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ticketing {

  static final String ZSET_KEY = "ZSET_KEY";
  static final String HASH_KEY = "HASH_KEY";
  static final String INCUR_KEY = "INCUR_KEY";
  static final String LAST_LOGIN = "RECENT_KEY";

  public static void main(String... args) {
    Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new Collector(), 5, 5, TimeUnit.SECONDS);
    produce();
  }

  private static void produce() {
    RedisClient client = RedisClient.create("redis://localhost");
    StatefulRedisConnection<String, String> connect = client.connect();
    RedisAsyncCommands<String, String> asyncCommands = connect.async();
    asyncCommands.setAutoFlushCommands(false);

    List<RedisFuture<?>> futures = new ArrayList<>();
    Instant start = Instant.now();
    Random random = new Random(System.currentTimeMillis());
    int counter = 5000;
    while (--counter > 0) {
      for (int i = 0; i < 100_000; i++) {
        futures.add(asyncCommands.zadd(ZSET_KEY, random.nextDouble(), String.valueOf(random.nextDouble())));
        futures.add(asyncCommands.incr(INCUR_KEY));
      }

      asyncCommands.flushCommands();
      boolean successful = LettuceFutures
          .awaitAll(10, TimeUnit.SECONDS,
              futures.toArray(new RedisFuture[futures.size()]));
      if (successful) {
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).getSeconds());
        start = end;
      } else {
        System.out.println("Can't complete");
      }
    }
    connect.close();
    client.shutdown();
  }
}

class Collector implements Runnable {

  @Override
  public void run() {
    RedisClient client = RedisClient.create("redis://localhost");
    StatefulRedisConnection<String, String> connect = client.connect();
    RedisAsyncCommands<String, String> asyncCommands = connect.async();
    asyncCommands.setAutoFlushCommands(false);

    List<RedisFuture<?>> futures = new ArrayList<>();
    Instant start = Instant.now();
    futures.add(asyncCommands.get(INCUR_KEY));
    RedisFuture<Long> zremrangebyscore = asyncCommands.zremrangebyscore(ZSET_KEY, 1, 5);
    futures.add(zremrangebyscore);
    asyncCommands.flushCommands();
    boolean successful = LettuceFutures
        .awaitAll(5, TimeUnit.SECONDS, futures.toArray(new RedisFuture[futures.size()]));
    if (successful) {
    } else {
      System.out.println("Can't complete");
    }

    connect.close();
    client.shutdown();
  }
}
