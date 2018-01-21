package org.black.lotus.lintcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReserveNodesInKGroup {

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null) {
      return null;
    }
    ListNode res = null;
    ListNode tmpNode = null;
    Deque<ListNode> deque = new ArrayDeque<>();
    while (head != null) {
      if (deque.size() < k) {
        deque.offerFirst(head);
      } else if (deque.size() == k) {
        ListNode tempHead = toReverse(deque);
        if (res == null) {
          res = tempHead;
          tmpNode = res;
          tmpNode = toRear(tmpNode);
        } else {
          tmpNode.next = tempHead;
          tmpNode = toRear(tmpNode);
        }
        deque.offerFirst(head);
      }
      head = head.next;
    }

    tmpNode = res;
    tmpNode = toRear(tmpNode);

    if (deque.size() == k) {
      if (tmpNode == null) {
        return toReverse(deque);
      } else {
        tmpNode.next = (toReverse(deque));
      }
    }

    while (!deque.isEmpty()) {
      if (res == null) {
        res = deque.pollLast();
        tmpNode = res;
      } else {
        tmpNode.next = deque.pollLast();
        tmpNode = tmpNode.next;
      }
    }

    return res;
  }

  private ListNode toReverse(Deque<ListNode> deque) {
    ListNode head = null;
    ListNode temp = null;
    while (!deque.isEmpty()) {
      if (head == null) {
        head = deque.pollFirst();
        temp = head;
      } else {
        temp.next = deque.pollFirst();
        temp = temp.next;
      }
    }
    // key part to unlock the last element.
    temp.next = null;

    return head;
  }

  private ListNode toRear(ListNode node) {
    while (node != null) {
      if (node.next == null) {
        return node;
      }
      node = node.next;
    }

    return null;
  }
}
