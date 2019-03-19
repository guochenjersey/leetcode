package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.black.lotus.org.black.lotus.support.TreeNode;
import org.junit.Test;

public class ConvertSortedArrayToBinarySearchTreeTest {

  @Test
  public void should_be_able_to_create_binary_search_tree() {
    ConvertSortedArrayToBinarySearchTree convertSortedArrayToBinarySearchTree =
        new ConvertSortedArrayToBinarySearchTree();
    int[] nums = {0, 1, 2};
    TreeNode res = convertSortedArrayToBinarySearchTree.sortedArrayToBST(nums);

    assertEquals(res.val, 1);
    assertEquals(res.left.val, 0);
    assertEquals(res.right.val, 2);
  }
}
