package org.black.lotus.system.design;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class Ticketing {

  static final String ZSET_KEY = "ZSET_KEY";
  static final String HASH_KEY = "TICK_COLLECTION";
  static final String INCUR_KEY = "INCUR_KEY";
  static final String LAST_LOGIN = "RECENT_KEY";
  static final String[] LPS = {"BOFA", "CITI", "JPMC", "GS", "ST", "UOB", "OCBC", "BARC", "UBS"};
  static final String[] SYMBOLS = {"EUR/USD", "USD/JPY", "USD/CHF", "GBP/USD", "USD/CAD"};
  static ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);

  public static void main(String... args) {
    produce();
  }

  private static void produce() {
    consume();

    ExecutorService es = Executors.newFixedThreadPool(10);
    Arrays.stream(LPS)
        .forEach(
            l -> {
              LP lp = new LP(l);
              List<Double> prices = lp.produceTicket(new Symbol("EUR/USD"), 10_000);
              es.submit(
                  () -> {
                    try {
                      Jedis jedis = new Jedis("192.168.1.8");
                      Pipeline pipelined = jedis.pipelined();
                      prices.forEach(
                          p -> {
                            pipelined.zadd("EUR/USD", System.currentTimeMillis(), p.toString());
                          });
                      pipelined.sync();
                      jedis.disconnect();
                    } catch (Exception e) {
                      e.printStackTrace();
                    }
                  });
            });
    try {
      Thread.sleep(1000 * 5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private static void consume() {
    ses.scheduleWithFixedDelay(
        () -> {
          try {
            Instant now = Instant.now();
            Jedis jedis = new Jedis("192.168.1.8");
            Set<String> prices = jedis.zrange("EUR/USD", 0, now.toEpochMilli());
            Instant oneSecAgo = now.minusSeconds(10);

            System.out.println("retrieved prices " + prices.size());
            Instant k = Instant.now();
            List<Double> l = new LinkedList<>();
            //                PriorityQueue<Double> pq = new PriorityQueue<>();
            prices.stream().map(Double::parseDouble).forEach(l::add);
            Collections.sort(l);
            for (int i = 0; i < 5; ++i) {
              System.out.println(l.get(i));
            }
            Instant end = Instant.now();
            System.out.println(Duration.between(k, end).toMillis() + " mills took");
            jedis.disconnect();
          } catch (Exception e) {
            e.printStackTrace();
          }
        },
        1,
        1,
        TimeUnit.SECONDS);
  }
}
