package org.black.lotus.kata;

/**
 * TODO
 * */
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
        node = node.next;
      }
    }

    if (counter == 1) {
      return null;
    }

    if (counter + 1 == n) {
      // if trying to remove head
      head = head.next;
      return head;
    }

    node.next = node.next.next;
    return head;
  }
}
