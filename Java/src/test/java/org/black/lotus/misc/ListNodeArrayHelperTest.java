package org.black.lotus.misc;

import org.black.lotus.kata.ListNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.*;

public class ListNodeArrayHelperTest {

    @Test
    public void should_create_list_nodes() {
        int[] nums = {0, 1, 2};
        ListNode head = ListNodeArrayHelper.create(nums);
        assertEquals(0, head.val);
        assertEquals(1, head.next.val);
        assertEquals(2, head.next.next.val);
        assertNull(head.next.next.next);
    }

    @Test
    public void array_deque_should_push_pull_nodes() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(0);
        deque.offerFirst(1);
        deque.offerFirst(2);

        assertEquals(new Integer(2), deque.pollFirst());
        assertEquals(new Integer(1), deque.pollFirst());
        assertEquals(new Integer(0), deque.pollFirst());
    }
}