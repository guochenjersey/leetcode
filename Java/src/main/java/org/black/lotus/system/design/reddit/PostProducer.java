package org.black.lotus.system.design.reddit;

import com.google.common.collect.ImmutableMap;
import redis.clients.jedis.Jedis;

import java.time.Instant;
import java.util.concurrent.Callable;

public class PostProducer implements Callable<Boolean> {

    private static final String POST_PREFIX = "POST";
    private static final String RANKING_ZSET = "Ranking:";

    @Override
    public Boolean call() throws Exception {
        try {
            Jedis jedis = new Jedis("node1");
            jedis.connect();
            for (int i = 0; i < 10000; i++) {
                String postId = POST_PREFIX + ":" + i;
                jedis.sadd(POST_PREFIX, postId);
                String initPageScore = String.valueOf(Instant.now().toEpochMilli());
                jedis.hmset(postId, ImmutableMap.of(postId, initPageScore));
                jedis.zadd(RANKING_ZSET, Long.parseLong(initPageScore), postId);
            }
            jedis.disconnect();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
