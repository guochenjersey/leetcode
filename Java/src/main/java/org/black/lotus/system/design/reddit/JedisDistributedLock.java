package org.black.lotus.system.design.reddit;

import redis.clients.jedis.Jedis;

import java.util.concurrent.Callable;

public class JedisDistributedLock implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        Jedis jedis = new Jedis("node1");
        // create key_res and set the value to be 1 only when key_res doesn't exist. NX means only
        // set when key doesn't exist, px means the expiry time. This means a distributed lock
        String statusCodeReply = jedis.set("key_res", "1", "NX", "PX", 3000l);
        jedis.del("key_res"); // delete the lock
        return null;
    }
}
