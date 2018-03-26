package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;

import java.util.List;

@LintCode
@FirstRound
@Medium
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode current = head;
        ListNode next = head.next;
        while (next != null) {
            if (next.val != current.val) {
                current.next = next;
                current = current.next;
                next = next.next;
            } else {
                next = next.next;
            }
        }

        current.next = null;
        return head;
    }
}
