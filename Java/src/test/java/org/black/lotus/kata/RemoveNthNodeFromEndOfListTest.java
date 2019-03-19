package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveNthNodeFromEndOfListTest {

  @Test
  public void should_remove_n_th_element() {
    ListNode one = new ListNode(1);
    ListNode two = new ListNode(2);
    ListNode three = new ListNode(3);
    ListNode four = new ListNode(4);
    ListNode five = new ListNode(5);
    one.next = two;
    two.next = three;
    three.next = four;
    four.next = five;

    RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
    ListNode listNode = removeNthNodeFromEndOfList.removeNthFromEnd(one, 2);
    System.out.println(listNode);
  }

  @Test
  public void should_remove_first_element() {
    ListNode one = new ListNode(1);
    ListNode two = new ListNode(2);
    one.next = two;
    RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
    ListNode listNode = removeNthNodeFromEndOfList.removeNthFromEnd(one, 1);
    System.out.println(listNode);
  }

  @Test
  public void should_remove_1() {
    ListNode one = new ListNode(1);
    RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
    ListNode listNode = removeNthNodeFromEndOfList.removeNthFromEnd(one, 1);
    System.out.println(listNode);
  }
}
