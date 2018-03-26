package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

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