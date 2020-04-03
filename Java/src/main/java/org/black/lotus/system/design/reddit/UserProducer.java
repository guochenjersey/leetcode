package org.black.lotus.system.design.reddit;

import redis.clients.jedis.Jedis;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Callable;

public class UserProducer implements Callable<Boolean> {
    private static final int MAX_USER = 100_000;
    private static final String USER_KEY = "USER";

    @Override
    public Boolean call() throws Exception {
        try {
            Jedis jedis = new Jedis("node1");
            jedis.connect();
            Instant start = Instant.now();
            for (int i = 0; i < MAX_USER; ++i) {
                jedis.sadd(USER_KEY, USER_KEY + ":" + i);
            }
            Instant end = Instant.now();
            System.out.println(Duration.between(start, end).getSeconds());
            jedis.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
