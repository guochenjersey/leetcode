package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseLinkedListTest {

  @Test
  public void should_reverse_zero_one() {
    ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
    ListNode zero = new ListNode(0);
    ListNode one = new ListNode(1);
    //        ListNode two = new ListNode(2);
    zero.next = one;
    //        one.next = two;

    reverseLinkedList.reverseList(zero);
  }
}
