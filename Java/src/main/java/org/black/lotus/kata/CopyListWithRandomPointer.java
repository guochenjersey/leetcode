package org.black.lotus.kata;

import org.black.lotus.marker.*;

import java.util.HashMap;

@LeetCode
@Medium
@Accepted
@NoIdeaOrBadIdeaInitially
@Important
public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();
        Node resHead = null;
        Node node = head;
        Node dummy = new Node();
        while (node != null) {
            Node n = new Node();
            n.val = node.val;
            n.next = node.next;
            if (resHead == null) {
                resHead = n;
            }
            dummy.next = n;
            map.put(node, n);

            dummy = dummy.next;
            node = node.next;
        }

        node = head;
        dummy = resHead;
        while (node != null) {
            dummy.random = map.get(node.random);

            dummy = dummy.next;
            node = node.next;
        }

        return resHead;
    }

    private class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
