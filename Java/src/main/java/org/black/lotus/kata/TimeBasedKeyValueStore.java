package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Lyft;
import org.black.lotus.marker.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;


/**
 * Leetcode 981
 */
@Lyft
@Medium
@LeetCode
@Accepted
public class TimeBasedKeyValueStore {

    private Map<String, TreeSet<Value>> store;

    public TimeBasedKeyValueStore() {
        this.store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        store.putIfAbsent(key, new TreeSet<>());
        store.compute(key, (s, values) -> {
            values.add(new Value(value, timestamp));
            return values;
        });

    }

    public String get(String key, int timestamp) {
        TreeSet<Value> values = store.get(key);
        if (values.isEmpty())
            return "";
        Value floor = values.floor(new Value("", timestamp));

        return floor == null ? "" : floor.value;
    }

    static class Value implements Comparable<Value> {
        String value;
        int timestamp;

        Value(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }

        @Override
        public String toString() {
            return value + " " + timestamp;
        }

        @Override
        public int compareTo(Value o) {
            return timestamp - o.timestamp; // this will make sure ascending order
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Value
                    && ((Value) obj).timestamp == timestamp
                    && ((Value) obj).value.equals(value);
        }

        @Override
        public int hashCode() {
            return value.hashCode() + timestamp;
        }
    }
}
