package org.black.lotus.kata;

public class MergeTwoSortedLists {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = null;
    ListNode node = null;
    if (l1 == null && l2 == null) {
      return head;
    }

    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        if (head == null) {
          head = l1;
          node = head;
        } else {
          node.next = l1;
          node = node.next;
        }
        l1 = l1.next;
      } else {
        if (head == null) {
          head = l2;
          node = head;
        } else {
          node.next = l2;
          node = node.next;
        }
        l2 = l2.next;
      }
    }

    if (l1 != null) {
      if (head == null) {
        head = l1;
      } else {
        node.next = l1;
      }
    }

    if (l2 != null) {
      if (head == null) {
        head = l2;
      } else {
        node.next = l2;
      }
    }


    return head;
  }

}
