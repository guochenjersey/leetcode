package org.black.lotus;

import org.black.lotus.org.black.lotus.support.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * <p>For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 */
public class Kata83 {

  public ListNode deleteDuplicates(ListNode head) {
    ListNode current = head, prev = null;
    ListNode res = null, resHead = null;
    while (current != null) {
      if (res == null) {
        res = current;
        resHead = res;
      }
      if (prev == null) {
        prev = current;
        continue;
      }
      if (current.val != prev.val) {
        res.next = current;
        res = res.next;
      }

      prev = current;
      current = current.next;
    }

    return resHead;
  }
}
