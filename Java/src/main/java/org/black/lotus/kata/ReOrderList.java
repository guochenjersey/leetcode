package org.black.lotus.kata;


import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.NeedToSubmit;

import java.util.ArrayDeque;
import java.util.Deque;

@FirstRound
@NeedToSubmit
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

        counter /= 2;

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
