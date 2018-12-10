package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 *
 *
 Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

 Example:

 Input: 1->2->4, 1->3->4
 Output: 1->1->2->3->4->4
 * */
@LeetCode
@FirstRound
@Easy
public class MergeTwoSortedLists {

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = null;
    ListNode node = null;
    if (l1 == null && l2 == null) {
      return null;
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
