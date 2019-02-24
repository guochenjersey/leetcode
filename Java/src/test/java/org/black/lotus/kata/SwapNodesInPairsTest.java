package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwapNodesInPairsTest {

    @Test
    public void should_swap_nodes() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);

        SwapNodesInPairs swapNodesInPairs =  new SwapNodesInPairs();
        ListNode swappedNodes = swapNodesInPairs.swapPairs(root);
        assertEquals(2, swappedNodes.val);

    }
}