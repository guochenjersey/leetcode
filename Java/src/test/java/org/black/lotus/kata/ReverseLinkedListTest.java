package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseLinkedListTest {

    @Test
    public void should_reverse_zero_one() {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode zero = new ListNode(0);
        ListNode one = new ListNode(1);
//        ListNode two = new ListNode(2);
        zero.next = one;
//        one.next = two;

        reverseLinkedList.reverse(zero);
    }
}