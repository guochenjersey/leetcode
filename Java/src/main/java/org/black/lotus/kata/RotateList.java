package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;

@FirstRound
@LintCode
@Medium
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int length = 0;
        ListNode curr = head;
        ListNode headCopy = head;
        while (curr != null) {
            ++length;
            curr = curr.next;
        }

        k = k % length;

        ListNode slow = head;
        ListNode fast = head;
        int step = 0;
        while (fast.next != null) {
            if (step < k) {
                ++step;
                fast = fast.next;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }

        fast.next = headCopy;
        head = slow.next;
        slow.next = null;

        return head;
    }
}
