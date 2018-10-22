package org.black.lotus.kata;


import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a singly linked list L: L0 → L1 → … → Ln-1 → Ln
 * <p>
 * reorder it to: L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * <p>
 * Have you met this question in a real interview?
 * Example
 * Given 1->2->3->4->null, reorder it to 1->4->2->3->null.
 * <p>
 * Challenge
 * Can you do this in-place without altering the nodes' values?
 * <p>
 * Tags
 */
@FirstRound
@LintCode
public class ReOrderList {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode node = head;
        int counter = 0;
        while (node != null) {
            ++counter;
            node = node.next;
        }
        if (counter % 2 == 0) {
            counter /= 2;
        } else {
            counter = counter / 2 + 1;
        }

        Deque<ListNode> stack = new ArrayDeque<>();
        int step = 0;
        ListNode slow = head;
        while (slow != null) {
            if (step >= counter && counter != 0) {
                stack.offerFirst(slow);
            }
            slow = slow.next;
            ++step;
        }
        ListNode temp = head;
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
