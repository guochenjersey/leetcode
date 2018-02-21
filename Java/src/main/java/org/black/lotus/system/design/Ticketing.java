package org.black.lotus.system.design;

import com.lambdaworks.redis.Limit;
import com.lambdaworks.redis.Range;
import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.api.sync.RedisCommands;
import java.time.Duration;
import java.time.Instant;

public class Ticketing {

  private static final String ZSET_KEY = "ZSET_KEY";
  private static final String HASH_KEY = "HASH_KEY";
  private static final String INCUR_KEY = "INCUR_KEY";
  private static final String LAST_LOGIN = "RECENT_KEY";

  public static void main(String... args) {
    RedisClient client = RedisClient.create("redis://localhost");
    RedisCommands<String, String> sync = client.connect().sync();
    operateOnZset(sync);
    sync.close();
    client.shutdown();
  }

  private static void operateOnZset(RedisCommands<String, String> sync) {
    sync.zadd(ZSET_KEY, 3.4f, "postId1");
    sync.zadd(ZSET_KEY, 4.5f, "postId2");
    sync.zadd(ZSET_KEY, 7.8f, "postId3");
    System.out.println("Having " + sync.zcard(ZSET_KEY) + " in zset");
    sync.zaddincr(ZSET_KEY, 9.8f, "postId1");
    Range<Float> floatRange = Range.create(0f, 50f);
    sync.zrangebyscore(ZSET_KEY, floatRange).forEach(System.out::println);
    Limit limit = Limit.create(0, 10);

    int operator = 0;
    Instant now = Instant.now();
    while (true) {
      if (operator % 10000 == 0) {
        Instant end = Instant.now();
        System.out.println(operator + " " + Duration.between(now, end).getSeconds());
        now = end;
      }
      ++operator;
      String token = "token" + operator;
      sync.hset(HASH_KEY, "token1", "user1");
      sync.hset(HASH_KEY, "token2", "user2");
      sync.hset(HASH_KEY, "token3", "user3");
      sync.zadd(LAST_LOGIN, System.currentTimeMillis(), token);

    }
  }

}
