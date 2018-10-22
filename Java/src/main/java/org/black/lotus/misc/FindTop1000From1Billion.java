package org.black.lotus.misc;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * key part is to main a small top heap. After reading one new data, compares with the peek of the heap, if it is bigger,
 * remove the heap peek and push the new data into the heap and adjust the heap. The time O should be O(n * time(heap adjust));
 * */
public class FindTop1000From1Billion {

    public static void main(String... args) {
        Instant now = Instant.now();
        List<Integer> salesFigure = new ArrayList<>(1000000000);
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 100000000; ++i) {
            salesFigure.add(random.nextInt());
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        salesFigure.stream()
                .forEach(i -> {
                    if (queue.size() < 1000) {
                        queue.offer(i);
                    } else {
                        Integer peek = queue.peek();
                        if (peek < i) {
                            queue.poll();
                            queue.offer(i);
                        }
                    }
                });
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        Duration timeElapsed = Duration.between(now, Instant.now());
        System.out.println(4 * (1000000000 / 1024 / 1024) + " " + timeElapsed.toMillis());
    }
}
