package org.black.lotus.kata;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RemoveDuplicatesFromSortedListIITest {

    @Test
    public void should_remove_duplicate() {
        ListNode minus14 = new ListNode(-14);
        ListNode minus13 = new ListNode(-13);
        ListNode twleve = new ListNode(12);
        ListNode twleve2 = new ListNode(12);
        ListNode eleven = new ListNode(11);
        ListNode eleven2 = new ListNode(11);
        ListNode eleven3 = new ListNode(11);

        ListNode ten = new ListNode(10);

        minus14.next = minus13;
        minus13.next= twleve;
        twleve.next = twleve2;
        twleve2.next = eleven;
        eleven.next = eleven2;
        eleven2.next = eleven3;
        eleven3.next = ten;

        RemoveDuplicatesFromSortedListII removeDuplicatesFromSortedListII = new RemoveDuplicatesFromSortedListII();
        removeDuplicatesFromSortedListII.deleteDuplicates(minus14);
    }
}