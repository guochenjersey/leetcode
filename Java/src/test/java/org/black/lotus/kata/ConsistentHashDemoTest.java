package org.black.lotus.kata;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

public class ConsistentHashDemoTest {

    @Test
    public void should_find_consistent_hash() {
        ConsistentHashDemo<Object> consistentHashDemo = new ConsistentHashDemo<>(3);
        HashFunction murMurHash = Hashing.murmur3_32();
        int machine1Hash = murMurHash.newHasher()
                .putString("192.168.0.1", StandardCharsets.UTF_8)
                .hash()
                .asInt();
        int machine2Hash = murMurHash.newHasher()
                .putString("192.168.0.2", StandardCharsets.UTF_8)
                .hash()
                .asInt();

        int machine3Hash = murMurHash.newHasher()
                .putString("192.168.0.3", StandardCharsets.UTF_8)
                .hash()
                .asInt();

        int machine4Hash = murMurHash.newHasher()
                .putString("192.168.0.4", StandardCharsets.UTF_8)
                .hash()
                .asInt();

        System.out.println("Machine 1 hash :" + machine1Hash);
        System.out.println("Machine 2 hash :" + machine2Hash);
        System.out.println("Machine 3 hash :" + machine3Hash);
        System.out.println("Machine 4 hash :" + machine4Hash);
        System.out.println(Integer.MAX_VALUE);

        consistentHashDemo.addNewCacheMachine(new ConsistentHashDemo.CacheMachine("192.168.0.1", "alias1"));
        consistentHashDemo.addNewCacheMachine(new ConsistentHashDemo.CacheMachine("192.168.0.2", "alias1"));
        consistentHashDemo.addNewCacheMachine(new ConsistentHashDemo.CacheMachine("192.168.0.3", "alias1"));

        ConsistentHashDemo.CacheMachine machine = consistentHashDemo.findMachine(new Object());
        assertNotNull(machine);
    }
}