package org.black.lotus.kata;

import org.black.lotus.marker.*;

@FirstRound
@Easy
@LintCode
@Yelp
@Accepted
public class ReverseLinkedList {

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode prev = null, resHead = null;
        while (head != null) {
            if (prev == null) {
                prev = head;
                head = head.next;
                prev.next = null;
            } else {
                ListNode temp = head.next;
                if (temp != null) {
                    head.next = prev;
                    prev = head;
                    head = temp;
                } else {
                    resHead = head;
                    head.next = prev;
                    head = null;
                }
            }
        }

        return resHead;
    }
}
