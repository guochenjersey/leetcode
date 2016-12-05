package org.black.lotus;

import org.black.lotus.org.black.lotus.support.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;


public class Kata2Test {
    @Test
    public void should_return_empty_list_node() {
        ListNode node1_1 = new ListNode(9);
        ListNode node1_2 = new ListNode(8);
//        ListNode node1_3 = new ListNode(3);
        node1_1.next = node1_2;
//        node1_2.next = node1_3;
        ListNode node2_8 = new ListNode(1);

        Kata2 kata2 = new Kata2();
        ListNode listNode = kata2.addTwoNumbers(node1_1, node2_8);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }
}