package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.LintCode;


/**
 *
 * Find the middle node of a linked list.
 *
 * <pre>
     Example
     Given 1->2->3, return the node with value 2.

     Given 1->2, return the node with value 1.
 </pre>
 *
 * */
@Important
@FirstRound
@LintCode
@Easy
public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
