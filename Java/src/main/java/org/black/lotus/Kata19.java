package org.black.lotus;

import org.black.lotus.org.black.lotus.support.ListNode;

import java.util.ArrayDeque;

/**
 * TODO verify your thoughts in leet
  * <p>
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * For example,
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
public class Kata19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0) {
            return null;
        }

        if (n == 0) {
            return head;
        }

        ListNode current = head, lastNode = null;
        ArrayDeque<ListNode> nodeQueue = new ArrayDeque<ListNode>();
        int counter = 0;
        while (current != null) {
            nodeQueue.offer(current);
            ++counter;
            current = current.next;
        }

        int numToRetain = counter - n;
        while (numToRetain > 0) {
            lastNode = nodeQueue.pop();
        }

        if (lastNode != null) {
            lastNode.next = null;
        }

        return head;
    }
}
