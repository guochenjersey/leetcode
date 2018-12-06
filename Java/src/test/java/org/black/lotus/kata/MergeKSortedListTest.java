package org.black.lotus.kata;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeKSortedListTest {

    @Test
    public void should_merge_k_sorted_list() {
        ListNode root1 = new ListNode(5);
        ListNode root2 = new ListNode(8);
        ListNode root3 = new ListNode(7);
        root1.next = root2;
        root2.next = root3;

        ListNode node1 = new ListNode(13);
        ListNode node2 = new ListNode(14);
        ListNode node3 = new ListNode(10);
        node1.next = node2;
        node2.next = node3;

        MergeKSortedList sortedList = new MergeKSortedList();
        ListNode head = sortedList.mergeKLists(Arrays.asList(node1, root1));

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}