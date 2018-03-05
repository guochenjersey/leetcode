package org.black.lotus.system.design;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Ticketing {

  static final String ZSET_KEY = "ZSET_KEY";
  static final String HASH_KEY = "TICK_COLLECTION";
  static final String INCUR_KEY = "INCUR_KEY";
  static final String LAST_LOGIN = "RECENT_KEY";
  static final String[] LPS = {"BOFA", "CITI", "JPMC", "GS", "ST", "UOB", "OCBC", "BARC", "UBS"};
  static final String[] SYMBOLS = {"EUR/USD", "USD/JPY", "USD/CHF", "GBP/USD", "USD/CAD"};

  public static void main(String... args) {
    produce();
  }

  private static void produce() {
    Jedis jedis = new Jedis("172.27.0.104");
      Random random = new Random(System.currentTimeMillis());
      Pipeline pipelined = jedis.pipelined();
      Instant start = Instant.now();
      for (String lp : LPS) {
          Instant end = Instant.now();
          System.out.println(Duration.between(start, end).getSeconds());
          start = end;
          for (int i = 0; i < 100_000; i++) {
            for (String symbol : SYMBOLS) {
                StringBuilder keyBuilder = new StringBuilder();
                keyBuilder.append(lp);
                keyBuilder.append("-");
                keyBuilder.append(Instant.now());
                keyBuilder.append("-").append(symbol);

                pipelined.zadd(ZSET_KEY, System.currentTimeMillis(), String.valueOf(random.nextFloat()));
            }
            if (i % 10_000 == 0) {
                pipelined.sync();
            }
        }

    }

      try {
          Thread.sleep(1000 * 5000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
      jedis.disconnect();
  }
}