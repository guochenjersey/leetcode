package org.black.lotus.bio;

import java.util.concurrent.*;

public class ThreadPoolExecutorMain {

  public static void main(String... args) throws InterruptedException {
    LinkedBlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();
    ExecutorService es =
        new ThreadPoolExecutor(
            2, 5, 0L, TimeUnit.MILLISECONDS, taskQueue, new ThreadPoolExecutor.AbortPolicy());

    for (int i = 0; i < 20; ++i) {
      es.submit(
          () -> {
            while (true) {
              Thread.sleep(1000);
            }
          });
    }

    Thread.sleep(1000 * 10 * 10);
  }
}
