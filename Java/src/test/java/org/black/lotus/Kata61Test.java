package org.black.lotus;

import static org.junit.Assert.*;

import org.black.lotus.org.black.lotus.support.ListNode;
import org.junit.Before;
import org.junit.Test;

public class Kata61Test {

  private ListNode node;

  @Before
  public void setup() {
    ListNode one = new ListNode(1);
    ListNode two = new ListNode(2);
    ListNode three = new ListNode(3);
    ListNode four = new ListNode(4);
    ListNode five = new ListNode(5);

    one.next = two;
    two.next = three;
    three.next = four;
    four.next = five;

    node = one;
  }

  @Test
  public void should_handle_k_greater_than_list_length() {
    Kata61 kata61 = new Kata61();
    ListNode head = kata61.rotateRight(node, 6);
    head.println();
  }

  @Test
  public void should_rotate_when_k_less_than_list_length() {
    Kata61 kata61 = new Kata61();
    ListNode head = kata61.rotateRight(node, 2);
    head.println();
  }

  @Test
  public void should_handle_only_1_element() {
    Kata61 kata61 = new Kata61();
    ListNode one = new ListNode(1);
    ListNode two = new ListNode(2);
    one.next = two;

    ListNode node = kata61.rotateRight(one, 2);
    node.println();
  }
}
