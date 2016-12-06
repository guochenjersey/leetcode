package org.black.lotus;

import org.black.lotus.org.black.lotus.support.ListNode;

import java.util.Stack;

/**
 *
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.
 */
public class Kata92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m < 0 || n < 0 || m > n) {
            return null;
        }

        Stack<ListNode> nodes = new Stack<ListNode>();
        int counter = 0;
        ListNode res = null, resHead = null;
        ListNode node = head;
        while (node != null) {
            ++counter;

            if (counter >= m && counter <= n) {
                nodes.push(node);
            } else {
                if (res == null) {
                    res = new ListNode(node.val);
                    resHead = res;
                } else {
                    res.next = new ListNode(node.val);
                    res = res.next;
                }
            }

            if (counter == n) {
                while (!nodes.isEmpty()) {
                    ListNode poped = nodes.pop();
                    if (res == null) {
                        res = new ListNode(poped.val);
                        resHead = res;
                    } else {
                        res.next = new ListNode(poped.val);
                        res = res.next;
                    }
                }
            }

            node = node.next;
        }

        return resHead;
    }
}
