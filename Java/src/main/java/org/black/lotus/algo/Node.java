package org.black.lotus.algo;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Node {

    private final int id;
    private final String name;
    private final Set<UUID> processedMessages;
    private final Set<Node> children;

    public Node(String name, int id) {
        this.name = name;
        this.id = id;
        this.processedMessages = new HashSet<>();
        this.children = new HashSet<>();
    }

    public void handleMessage(Message message) {
        if (processedMessages.contains(message.messageId())) {
            System.out.println(toString() + " processed message " + message.messageId() + " before, won't propagate");
            return;
        }
        System.out.println(String.format(toString() + " processed message %s", message));
        processedMessages.add(message.messageId());
        children.forEach(child -> child.handleMessage(message));
    }

    public void addChild(@Nonnull Node node) {
        children.add(node);
    }

    @Override
    public String toString() {
        return "node-" + id;
    }
}
