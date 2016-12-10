package org.black.lotus;

import org.black.lotus.org.black.lotus.support.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?

 Subscribe to see which companies asked this question
 *
 * */
public class Kata141 {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode current = head, next = head.next;
        while (current != null && next != null) {
            if (current == next) {
                return true;
            }
            current = current.next;
            if (next.next == null) {
                return false;
            } else {
                next = next.next.next;
            }
        }

        return false;
    }
}
