package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;

/**
 * Description
 Given a linked list, determine if it has a cycle in it.



 Have you met this question in a real interview?
 Example
 Given -21->10->4->5, tail connects to node index 1, return true

 Challenge
 Follow up:
 Can you solve it without using extra space?

 Related Problems

 *
 * */

@FirstRound
@LintCode
@Medium
public class LinkedListCycle {

  public boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }
    ListNode slowNode = head;
    ListNode fastNode = head;

    while (slowNode != null) {

      slowNode = slowNode.next;
      if (fastNode != null && fastNode.next == null) {
        return false;
      }

      if (fastNode != null) {
        fastNode = fastNode.next.next;
      }

      if (slowNode != null
          && fastNode != null
          && slowNode.val == fastNode.val) {
        return true;
      }
    }

    return false;
  }
}
