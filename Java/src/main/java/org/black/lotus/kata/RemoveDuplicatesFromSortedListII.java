package org.black.lotus.kata;


import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

import java.util.*;


/**
 *
 *
 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 Example
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.
 *
 *
 * */
@FirstRound
@LintCode
@Medium
@NoIdeaOrBadIdeaInitially
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int val = head.next.val;
                while (head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}
