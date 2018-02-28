package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class SortList {

  /**
   * TODO
   * */
  public ListNode sortList(ListNode head) {
    return null;
  }

  /**
   * Quick sort version.
   * */
  public ListNode quickSort(ListNode head) {
    if (head == null) {
      return head;
    }

    List<ListNode> nodes = new ArrayList<>();

    while (head != null) {
      nodes.add(head);
      head = head.next;
    }

    nodes.sort(Comparator.comparingInt(o -> o.val));

    ListNode node = null;
    for (int i = 0; i < nodes.size(); ++i) {
      if (i == 0) {
        head = nodes.get(i);
        node = head;
      } else {
        node.next = nodes.get(i);
        node = node.next;
      }
    }

    if (node != null) {
      node.next = null;
    }
    return head;
  }

  private ListNode findMiddle(ListNode root) {
    if (root == null) {
      return null;
    }

    ListNode slow = root;
    ListNode fast = root.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  private ListNode mergeSort(ListNode root) {
    ListNode middle = findMiddle(root);
    ListNode left = mergeSort(middle.next);
    middle.next = null;
    ListNode right = mergeSort(root);
    return merge(left, right);
  }

  private ListNode merge(ListNode n1, ListNode n2) {
    return null;
  }
}
