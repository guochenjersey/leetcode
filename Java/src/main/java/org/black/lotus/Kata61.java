package org.black.lotus;

import org.black.lotus.org.black.lotus.support.ListNode;

public class Kata61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        // the most important point is here
        k = findK(head, k);

        if (k == 0) {
            return head;
        }


        ListNode fast = head, slow = head, prev = head;
        int j = k;
        while (j > 1) {
            fast = fast.next;
            --j;
        }

        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        fast.next = head;
        prev.next = null;

        return slow;
    }

    private int findK(ListNode head, int k) {
        ListNode node = head;
        int length = 0;
        while (node != null) {
            ++length;
            node = node.next;
        }

        k = k % length;
        return k;
    }
}
