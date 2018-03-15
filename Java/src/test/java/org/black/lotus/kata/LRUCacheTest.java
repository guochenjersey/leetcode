package org.black.lotus.kata;

import org.black.lotus.kata.LRUCache.KeyWrapper;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.Assert.*;

public class LRUCacheTest {

    @Test
    public void should_priority_queue_ascend() {
        PriorityQueue<KeyWrapper> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.key));
        KeyWrapper one = new KeyWrapper(2);
        KeyWrapper two = new KeyWrapper(3);
        KeyWrapper three = new KeyWrapper(4);
        KeyWrapper four = new KeyWrapper(5);

        pq.offer(one);
        pq.offer(two);
        pq.offer(three);
        pq.offer(four);

        two.key = 1;
        pq.offer(two);
        System.out.println(pq.poll().key);
    }


}