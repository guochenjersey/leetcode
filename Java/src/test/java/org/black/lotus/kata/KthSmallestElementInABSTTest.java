package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.black.lotus.org.black.lotus.support.TreeNode;
import org.junit.Test;

public class KthSmallestElementInABSTTest {

  @Test
  public void should_find_kth_smallest() {
    KthSmallestElementInABST solution = new KthSmallestElementInABST();
    TreeNode root = new TreeNode(2);
    TreeNode left = new TreeNode(1);
    TreeNode right = new TreeNode(3);

    root.left = left;
    root.right = right;

    solution.kthSmallest(root, 1);
  }
}
