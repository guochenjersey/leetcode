package org.black.lotus.kata;

import org.black.lotus.marker.*;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
@LeetCode
@Medium
@FirstRound
@Accepted
@LinkedLists
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode next = head.next;
        ListNode resHead = head.next;
        ListNode prev = null;
        while (next != null) {
            ListNode nextNext = next.next;
            next.next = current;
            current.next = nextNext;
            if (prev != null) {
                prev.next = next;
            }
            prev = current;
            if (nextNext == null) {
                break;
            }
            current = nextNext;
            next = current.next;
        }

        return resHead;
    }
}
