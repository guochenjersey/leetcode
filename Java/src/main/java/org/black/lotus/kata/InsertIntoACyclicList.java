package org.black.lotus.kata;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 * */
public class InsertIntoACyclicList {

  public ListNode insert(ListNode node, int x) {
    if (node == null) {
      ListNode n = new ListNode(x);
      n.next = n;
      return n;
    }
    ListNode slow = node;
    ListNode fast = node.next;
    ListNode insertNode;
    ListNode minNode = node;
    ListNode maxNode = node;
    Set<ListNode> visitedNodes = new HashSet<>();
    while (true) {
      if (fast.val >= x && slow.val <= x) {
        insertNode = new ListNode(x);
        slow.next = insertNode;
        insertNode.next = fast;
        return insertNode;
      }

      minNode = minNode.val < slow.val ? minNode : slow;
      maxNode = maxNode.val > slow.val ? maxNode : slow;

      if (visitedNodes.contains(slow)) {
        if (x <= minNode.val && fast.val == minNode.val) {
          insertNode = new ListNode(x);
          slow.next = insertNode;
          insertNode.next = fast;
          return insertNode;
        }

        if (x >= maxNode.val && slow.val == maxNode.val ) {
          insertNode = new ListNode(x);
          slow.next = insertNode;
          insertNode.next = fast;
          return insertNode;
        }
      }

      slow = slow.next;
      fast = fast.next;
      visitedNodes.add(slow);
    }
  }
}
