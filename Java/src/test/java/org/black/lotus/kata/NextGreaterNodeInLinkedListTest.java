package org.black.lotus.kata;

import org.black.lotus.utils.ListNodeUtils;
import org.junit.Assert;
import org.junit.Test;

public class NextGreaterNodeInLinkedListTest {

    @Test
    public void should_find_next_greater_node() {
        int[] nodes = {2, 1, 5};

        ListNode head = ListNodeUtils.create(nodes);
        NextGreaterNodeInLinkedList linkedList = new NextGreaterNodeInLinkedList();
        int[] res = linkedList.nextLargerNodes(head);
        int[] expected = {5, 5, 0};

        Assert.assertArrayEquals(expected, res);

        int[] nodes2 = {2, 7, 4, 3, 5};
        ListNode head2 = ListNodeUtils.create(nodes2);
        int[] res2 = linkedList.nextLargerNodes(head2);
        int[] expected2 = {7, 0, 5, 5, 0};

        Assert.assertArrayEquals(expected2, res2);

        int[] nodes3 = {3, 3};
        ListNode head3 = ListNodeUtils.create(nodes3);
        int[] res3 = linkedList.nextLargerNodes(head3);
        int[] expected3 = {0, 0};

        Assert.assertArrayEquals(expected3, res3);
    }
}