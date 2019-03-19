package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class PartitionListTest {

  @Test
  public void should_complete() {
    ListNode two = new ListNode(2);
    ListNode one = new ListNode(1);
    two.next = one;

    PartitionList partitionList = new PartitionList();
    partitionList.partition(two, 2);
  }
}
