package org.black.lotus;

import static org.junit.Assert.*;

import org.black.lotus.org.black.lotus.support.ListNode;
import org.junit.Test;

public class Kata92Test {
  @Test
  public void should_reverse_linked_list() {
    ListNode node1_1 = new ListNode(9);
    ListNode node1_2 = new ListNode(8);
    ListNode node1_3 = new ListNode(3);
    node1_1.next = node1_2;
    node1_2.next = node1_3;

    Kata92 kata92 = new Kata92();
    ListNode listNode = kata92.reverseBetween(node1_1, 2, 3);
  }
}
