package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NotAccepted;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.

 Example:

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:

 Given n will always be valid.
 * */
@LeetCode
@NotAccepted
@FirstRound
@Medium
public class RemoveNthNodeFromEndOfList {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode forwardNode = head;
    ListNode node = head;
    int counter = 0;

    while (forwardNode != null) {
      if (counter < n) {
        forwardNode = forwardNode.next;
        counter++;
      } else {
          forwardNode = forwardNode.next;
          if (forwardNode != null) {
              node = node.next;
          }
      }
    }

    if (counter + 1 == n) {
      // if trying to remove head
      head = head.next;
      return head;
    }

      if (node.next == null) {
        return null;
      }
    node.next = node.next.next;
    return head;
  }
}
