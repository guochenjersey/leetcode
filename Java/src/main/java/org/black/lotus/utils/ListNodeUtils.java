package org.black.lotus.utils;

import org.black.lotus.kata.ListNode;

public class ListNodeUtils {

    public static ListNode create(int[] vals) {
        if (vals == null || vals.length == 0) {
            return null;
        }
        ListNode sentinel = new ListNode(0);
        ListNode dummy = sentinel;
        for (int i : vals) {
            sentinel.next = new ListNode(i);
            sentinel = sentinel.next;
        }

        return dummy.next;
    }
}
