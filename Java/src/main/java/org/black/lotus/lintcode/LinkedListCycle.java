package org.black.lotus.lintcode;


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
