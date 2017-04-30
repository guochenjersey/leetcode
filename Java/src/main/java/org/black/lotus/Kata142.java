package org.black.lotus;

import org.black.lotus.org.black.lotus.support.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 Note: Do not modify the linked list.

 Follow up:
 Can you solve it without using extra space?
 */
public class Kata142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next==null) {
            return null;
        }

        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while (fast != slow) {
            if(fast==null || fast.next==null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
        }

        // mathematic proof that pointer pos will be like below
        while (head != slow.next) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
