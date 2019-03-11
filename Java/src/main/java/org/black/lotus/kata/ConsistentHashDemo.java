package org.black.lotus.kata;

import com.google.common.hash.*;
import lombok.Data;
import org.black.lotus.marker.ConsistentHash;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 一致性哈希的关键.
 * 1. 当分布式集群中有新的机器加入, 通过和对象存储一样的哈希算法, 把机器也映射到哈希环中.
 * 通常可以对机器IP或者机器别名做法哈希算法的输入值.
 * 2. java int 是有符号数,那么我们可以把整个环的取值空间想象成 -2 31次方,到2的31次方减去1
 * 3. 虚拟节点的目的是让每个机器在整个HASH环上,更均匀的接受存储对象.
 * */
@ConsistentHash
public class ConsistentHashDemo<T> {

    private int virtualNodesNum;
    private List<CacheMachine> machines;
    private TreeMap<Integer, CacheMachine> cacheMachineMap;

    ConsistentHashDemo(int virtualNodesNum) {
        this.machines = new ArrayList<>();
        this.cacheMachineMap = new TreeMap<>();
        this.virtualNodesNum = virtualNodesNum;
    }

    public void addNewCacheMachine(CacheMachine machine) {
        machines.add(machine);
        HashFunction murMurHash = Hashing.murmur3_32();

        for (int i = 0; i < virtualNodesNum; ++i) {
            int machineHashVal = murMurHash.newHasher()
                    .putString(machine.getCacheAlias(), StandardCharsets.UTF_8)
                    .putString(machine.getCacheIP() + i, StandardCharsets.UTF_8)
                    .hash()
                    .asInt();

            cacheMachineMap.put(machineHashVal, machine);
        }

    }

    public CacheMachine findMachine(T t) {
        HashFunction murMurHashFunction = Hashing.murmur3_32();
        int targetHashVal = murMurHashFunction.newHasher()
                .putInt(hashCode())
                .hash()
                .asInt();
        // 试着顺时针查找,如果没有,就找最小的
        Integer ceilingKey = cacheMachineMap.ceilingKey(targetHashVal);
        if (ceilingKey == null) {
            ceilingKey = cacheMachineMap.firstKey();
        }

        return cacheMachineMap.getOrDefault(ceilingKey, CacheMachine.defaultMachine);
    }

    @Data
    static class CacheMachine {
        public static CacheMachine defaultMachine = new CacheMachine("", "");

        private String cacheIP;
        private String cacheAlias;

        CacheMachine(String cacheIP,
                            String cacheAlias) {
            this.cacheIP = cacheIP;
            this.cacheAlias = cacheAlias;
        }
    }
}
