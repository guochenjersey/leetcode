package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.NotAccepted;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * <p>Example 1:
 *
 * <p>Input: 1->2 Output: false Example 2:
 *
 * <p>Input: 1->2->2->1 Output: true Follow up: Could you do it in O(n) time and O(1) space?
 */
@LeetCode
@Easy
@FirstRound
@NotAccepted
public class PalindromeLinkedList {
  public boolean isPalindrome(ListNode head) {
    int length = 0;
    ListNode originalHead = head;
    while (head != null) {
      head = head.next;
      ++length;
    }

    int mid = length / 2;
    head = originalHead;
    int counter = 0;
    ListNode headCopy = originalHead;
    ListNode newRear = null;
    while (counter < mid) {
      if (newRear == null) {}

      ++counter;
    }

    return false;
  }

  public ListNode reverse(ListNode node) {
    ListNode prev = null;
    ListNode now = node;
    while (now != null) {
      ListNode next = now.next;
      now.next = prev;
      prev = now;
      now = next;
    }

    return prev;
  }
}
