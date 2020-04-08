package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeBasedKeyValueStoreTest {

    @Test
    public void test_time_based_key_value_test() {
        TimeBasedKeyValueStore store = new TimeBasedKeyValueStore();
        store.set("foo", "bar", 1);
        store.set("foo", "bar", 2);
        assertEquals("bar", store.get("foo", 1));
        assertEquals("bar", store.get("foo", 3));
        store.set("foo", "bar2", 5);
        assertEquals("bar2", store.get("foo", 6));
    }
}