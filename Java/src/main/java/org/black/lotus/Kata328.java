package org.black.lotus;

import org.black.lotus.org.black.lotus.support.ListNode;

public class Kata328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head, evenHead = null, evenNode = null;
        int counter = 0;
        while (node != null) {
            if (counter++ % 2 == 0) {
                if (evenHead == null) {
                    evenHead = node;
                    evenNode = evenHead;
                } else {
                    evenHead.next = node;

                }
            }
            node = node.next;
        }
        return head;
    }
}
