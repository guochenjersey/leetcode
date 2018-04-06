package org.black.lotus.kata;

import org.black.lotus.misc.ListNodeArrayHelper;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReOrderListTest {

    @Test
    public void should_reorder_list() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode head = ListNodeArrayHelper.create(nums);
        ReOrderList reOrderList = new ReOrderList();
        reOrderList.reorderList(head);
        assertEquals(1, head.val);
    }

    @Test
    public void should_handle_single_number_reorder_list() {
        int[] nums = {0};
        ListNode head = ListNodeArrayHelper.create(nums);
        ReOrderList reOrderList = new ReOrderList();
        reOrderList.reorderList(head);
        assertEquals(0, head.val);
    }

    @Test
    public void should_handle_three_number_reorder_list() {
        int[] nums = {2, 1, 0};
        ListNode head = ListNodeArrayHelper.create(nums);
        ReOrderList reOrderList = new ReOrderList();
        reOrderList.reorderList(head);
        assertEquals(2, head.val);
    }
}