package org.black.lotus.kata;

import org.black.lotus.misc.ListNodeArrayHelper;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReOrderListTest {

    @Test
    public void should_reorder_list() {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        ListNode head = ListNodeArrayHelper.create(nums);
        ReOrderList reOrderList = new ReOrderList();
        reOrderList.reorderList(head);
        assertEquals(0, head.val);
    }
}