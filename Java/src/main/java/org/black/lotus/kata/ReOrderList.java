package org.black.lotus.kata;


import org.black.lotus.marker.FirstRound;

import java.util.ArrayDeque;
import java.util.Deque;

@FirstRound
public class ReOrderList {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode node = head;
        if (node.next == null || node.next.next == null) {
            return;
        }

        ListNode slow = node;
        ListNode fast = node.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Deque<ListNode> stack = new ArrayDeque<>();
        while (slow != null) {
            stack.offerFirst(slow);
            slow = slow.next;
        }

        while (!stack.isEmpty()) {
            ListNode reverseNode = stack.pollFirst();
            ListNode headNext = head.next;
            reverseNode.next = headNext;
            head.next = reverseNode;
            head = headNext;
        }

        head.next = null;
    }
}
