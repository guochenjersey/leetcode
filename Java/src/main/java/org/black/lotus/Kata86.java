package org.black.lotus;

import org.black.lotus.org.black.lotus.support.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 */
public class Kata86 {

    public ListNode partition(ListNode node, int x) {
        if (node == null) {
            return null;
        }
        ListNode res = null, resHead = null, greaterThanNode = null,
                greatherOrEqualHead = null;
        while (node != null) {
            if (node.val < x) {
                if (res == null) {
                    res = node;
                    resHead = res;
                } else {
                    res.next = node;
                    res = res.next;
                }
            } else {
                if (greatherOrEqualHead == null) {
                    greatherOrEqualHead = node;
                    greaterThanNode = greatherOrEqualHead;
                } else {
                    greaterThanNode.next = node;
                    greaterThanNode = greaterThanNode.next;
                }
            }
            node = node.next;
        }

        if (greatherOrEqualHead != null && res != null) {
            res.next = greatherOrEqualHead;
        } else if (greatherOrEqualHead != null && res == null) {
            resHead = greatherOrEqualHead;
        }

        return resHead;
    }
}
