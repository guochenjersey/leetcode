package org.black.lotus;

import java.util.ArrayDeque;
import java.util.Deque;
import org.black.lotus.org.black.lotus.support.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The most
 * significant digit comes first and each of their nodes contain a single digit. Add the two numbers
 * and return it as a linked list.
 *
 * <p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * <p>Follow up: What if you cannot modify the input lists? In other words, reversing the lists is
 * not allowed.
 *
 * <p>Example:
 *
 * <p>Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 8 -> 0 -> 7
 */
public class Kata445 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Deque<ListNode> l1Deque = new ArrayDeque<>();
    Deque<ListNode> l2Deque = new ArrayDeque<>();

    Deque<ListNode> res = new ArrayDeque<>();
    while (l1 != null) {
      l1Deque.push(l1);
      l1 = l1.next;
    }

    while (l2 != null) {
      l2Deque.push(l2);
      l2 = l2.next;
    }

    // check if there is anything need to carry
    boolean shouldCarry = false;
    while (!l1Deque.isEmpty() && !l2Deque.isEmpty()) {
      ListNode p1 = l1Deque.pop();
      ListNode p2 = l2Deque.pop();
      ListNode node;
      if (shouldCarry) {
        shouldCarry = p1.val + p2.val + 1 >= 10;
        node = new ListNode((p1.val + p2.val + 1) % 10);
      } else {
        shouldCarry = p1.val + p2.val >= 10;
        node = new ListNode((p1.val + p2.val) % 10);
      }
      res.push(node);
    }

    if (l1Deque.isEmpty() && l2Deque.isEmpty() && shouldCarry) {
      // if both stacks are empty, we create a head node.
      ListNode node = new ListNode(1);
      res.push(node);
    } else if (l1Deque.isEmpty() || l2Deque.isEmpty()) {
      // if one of stack is still available
      handleLeftOver(l1Deque, res, shouldCarry);
      handleLeftOver(l2Deque, res, shouldCarry);
    }

    // revert to backward
    ListNode head = res.peekFirst(), node;
    while (res.peekLast() != null) {
      ListNode tempNode;
      node = res.pollFirst();
      if ((tempNode = res.peekFirst()) != null) {
        node.next = tempNode;
      }
    }

    return head;
  }

  private void handleLeftOver(Deque<ListNode> l1Deque, Deque<ListNode> res, boolean shouldCarry) {
    boolean updated = false;
    while (!l1Deque.isEmpty()) {
      ListNode node;
      ListNode p1 = l1Deque.pop();
      if (shouldCarry) {
        shouldCarry = p1.val + 1 >= 10;
        node = new ListNode((p1.val + 1) % 10);
      } else {
        node = new ListNode(p1.val);
      }
      res.push(node);
      updated = true;
    }
    if (updated && shouldCarry) {
      // if the final node need to carry
      res.push(new ListNode(1));
    }
  }
}
