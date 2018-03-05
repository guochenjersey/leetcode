package org.black.lotus.kata;

import org.black.lotus.marker.Amazon;
import org.black.lotus.marker.LintCode;

import java.util.*;

@Amazon
@LintCode
public class LRUCache {

    private int capacity;
    private PriorityQueue<KeyWrapper> keys = new PriorityQueue<>();
    private Map<Integer, KeyWrapper> keysMap = new HashMap<>();
    private Map<Integer, Integer> cache = new HashMap<>();

    static class KeyWrapper implements Comparable<KeyWrapper> {
        int key;
        int access;

        KeyWrapper(int key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            KeyWrapper that = (KeyWrapper) o;

            return key == that.key;
        }

        @Override
        public int hashCode() {
            return key;
        }

        @Override
        public int compareTo(KeyWrapper o) {
            return this.access = o.access;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        keysMap.computeIfPresent(key, (k, v) -> {
            ++v.access;
            return v;
        });

        return cache.get(key);
    }


    public void set(int key, int value) {
        int currentSize = cache.size();
        if (currentSize + 1 > capacity) {
            KeyWrapper keyToRemove = keys.poll();
            if (!keyToRemove.equals(new KeyWrapper(key))) {
                keysMap.remove(keyToRemove.key);
                cache.remove(keyToRemove.key);
            } else {
                cache.put(key, value);
                KeyWrapper wrapper = new KeyWrapper(key);
                keys.offer(wrapper);
                keysMap.put(key, wrapper);
                return;
            }
        }
        keysMap.computeIfAbsent(key, (v) -> {
            KeyWrapper keyWrapper = new KeyWrapper(key);
            keyWrapper.access = 0;
            return keyWrapper;
        });

        keys.offer(keysMap.get(key));
        cache.put(key, value);
    }

    public static void main(String... args) {
//        LRUCache lruCache = new LRUCache(10);
//        for (int i = 0 ; i < 11; ++i) {
//            lruCache.set(i, i);
//        }
//
//        Random random = new Random();
//        for (int i = 0; i < 10; ++i) {
//            lruCache.get(random.nextInt(10));
//        }

    }
}
