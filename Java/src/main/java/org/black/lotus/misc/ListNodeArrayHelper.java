package org.black.lotus.misc;

import org.black.lotus.kata.ListNode;

public class ListNodeArrayHelper {

    public static ListNode create(int[] nums) {
        ListNode dummyhead = new ListNode(0);
        ListNode node = dummyhead;

        for (int i : nums) {
            node.next = new ListNode(i);
            node = node.next;
        }

        return dummyhead.next;
    }
}
