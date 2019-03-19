package org.black.lotus.kata;

import java.util.ArrayList;
import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.org.black.lotus.support.TreeNode;

@LeetCode
@Medium
@FirstRound
@Accepted
public class ConvertSortedListToBinarySearchTree {
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }

    ArrayList<Integer> res = toArrayList(head);
    int[] nums = res.stream().mapToInt(i -> i).toArray();
    return sortedArrayToBST(nums);
  }

  private ArrayList<Integer> toArrayList(ListNode head) {
    ArrayList<Integer> res = new ArrayList<>();
    while (head != null) {
      res.add(head.val);
      head = head.next;
    }

    return res;
  }

  private TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0) {
      return null;
    }

    return create(nums, 0, nums.length - 1);
  }

  private TreeNode create(int[] nums, int start, int end) {
    if (start < 0 || end >= nums.length || start > end) {
      return null;
    }
    int mid = (start + end) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = create(nums, start, mid - 1);
    node.right = create(nums, mid + 1, end);

    return node;
  }
}
