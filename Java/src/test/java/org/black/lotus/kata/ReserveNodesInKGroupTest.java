package org.black.lotus.kata;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReserveNodesInKGroupTest {

  private ReserveNodesInKGroup reserveNodesInKGroup;

  @Before
  public void setUp() {
    reserveNodesInKGroup = new ReserveNodesInKGroup();
  }

  @Test
  public void should_reverse_if_not_even() {
    ListNode first = new ListNode(1);
    ListNode second = new ListNode(2);
    ListNode third = new ListNode(3);
    first.next = second;
    second.next = third;

    ListNode listNode = reserveNodesInKGroup.reverseKGroup(first, 2);
    assertThat(listNode.val, equalTo(2));
  }

  @Test
  public void should_reverse() {
    ListNode first = new ListNode(1);
    ListNode second = new ListNode(2);
    first.next = second;

    ListNode listNode = reserveNodesInKGroup.reverseKGroup(first, 2);
    assertThat(listNode.val, equalTo(2));
  }

  @Test
  public void should_reverse_1_2() {
    ListNode first = new ListNode(1);
    ListNode second = new ListNode(2);
    first.next = second;

    ListNode listNode = reserveNodesInKGroup.reverseKGroup(first, 1);
    assertThat(listNode.val, equalTo(1));
    assertThat(listNode.next.val, equalTo(2));
  }

  @Test
  public void should_reverse_1_2_3_4() {
    ListNode first = new ListNode(1);
    ListNode second = new ListNode(2);
    ListNode third = new ListNode(3);
    ListNode four = new ListNode(4);
    first.next = second;
    second.next = third;
    third.next = four;

    ListNode res = reserveNodesInKGroup.reverseKGroup(first, 2);
    assertThat(res.val, equalTo(2));
    assertThat(res.next.val, equalTo(1));
    assertThat(res.next.next.val, equalTo(4));
    assertThat(res.next.next.next.val, equalTo(3));
  }
}
