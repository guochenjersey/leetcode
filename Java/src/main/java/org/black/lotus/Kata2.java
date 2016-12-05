package org.black.lotus;

import org.black.lotus.org.black.lotus.support.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class Kata2 {

    private ListNode res;
    private ListNode start;

    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        boolean shouldCarry = false;
        while (node1 != null || node2 != null) {
            if (node1 != null && node2 != null) {
                int value = shouldCarry ? node1.val + node2.val + 1 : node1.val + node2.val;
                if (value >= 10) {
                    shouldCarry = true;
                    toListNode(value - 10);
                } else {
                    shouldCarry = false;
                    toListNode(value);
                }

                node1 = node1.next;
                node2 = node2.next;
            } else {
                if (node1 != null) {
                    if (shouldCarry) {
                        int val = node1.val + 1;
                        if (val >= 10) {
                            toListNode(val - 10);
                            shouldCarry = true;
                        } else {
                            toListNode(val);
                            shouldCarry = false;
                        }
                    } else {
                        toListNode(node1.val);
                        shouldCarry = false;
                    }
                    node1 = node1.next;
                } else {
                    if (shouldCarry) {
                        int val = node2.val + 1;
                        if (val >= 10) {
                            toListNode(val - 10);
                            shouldCarry = true;
                        } else {
                            toListNode(val);
                            shouldCarry = false;
                        }
                    } else {
                        toListNode(node2.val);
                        shouldCarry = false;
                    }
                    node2 = node2.next;
                }
            }
        }

        if (shouldCarry) {
            toListNode(1);
        }

        return start;
    }

    private void toListNode(int value) {
        if (res == null) {
            res = new ListNode(value);
            start = res;
        } else {
            res.next = new ListNode(value);
            res = res.next;
        }
    }
}
