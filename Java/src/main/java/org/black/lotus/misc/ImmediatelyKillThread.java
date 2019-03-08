package org.black.lotus.misc;

import com.sun.corba.se.spi.activation._InitialNameServiceStub;

import java.nio.file.Files;
import java.util.concurrent.*;

public class ImmediatelyKillThread {

    public static void main(String... args) {
        InfiniteThread infiniteThread = new InfiniteThread();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future = executorService.submit(infiniteThread);
        try {
            future.get(1000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }

}

class InfiniteThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        while (true) {
            Thread.sleep(1000);
        }
    }
}
