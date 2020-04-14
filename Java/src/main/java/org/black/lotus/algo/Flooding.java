package org.black.lotus.algo;

import org.apache.commons.lang3.RandomUtils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Flooding algo is used to broadcast the message to every node of the entire network.
 * */
public class Flooding {
    private static final List<Node> nodes = new ArrayList<>();

    public static void main(String... args) {
        formNetwork();
        Message m = new MessageImpl("hello world".getBytes(StandardCharsets.UTF_8));
        nodes.get(2).handleMessage(m);
    }

    private static void formNetwork() {
        int nodeNumber = RandomUtils.nextInt(1, 10);
        for (int i = 0; i < nodeNumber; ++i) {
            Node node = new Node("node-", i);
            int children = 1;
            if (nodes.size() == 0) {
                nodes.add(node);
                continue;
            }
            children = RandomUtils.nextInt(1, nodes.size());
            for (int j = 0; j < children; ++j) {
                Node child = nodes.get(j);
                node.addChild(child);
            }
            nodes.add(node);
        }
    }
}
