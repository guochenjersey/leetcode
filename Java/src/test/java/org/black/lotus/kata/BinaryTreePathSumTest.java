package org.black.lotus.kata;

import static org.junit.Assert.*;

import java.util.List;
import org.black.lotus.org.black.lotus.support.TreeNode;
import org.junit.Test;

public class BinaryTreePathSumTest {

  @Test
  public void should_find_binary_search_path() {
    TreeNode node = new TreeNode(1);
    node.val = 1;

    TreeNode two = new TreeNode(2);
    two.val = 2;

    TreeNode four = new TreeNode(4);
    four.val = 4;

    TreeNode two2 = new TreeNode(2);
    two2.val = 2;

    TreeNode three = new TreeNode(3);
    three.val = 3;

    node.left = two;
    node.right = four;
    two.left = two2;
    two.right = three;

    BinaryTreePathSum binaryTreePathSum = new BinaryTreePathSum();
    List<List<Integer>> res = binaryTreePathSum.binaryTreePathSum(node, 5);
  }
}
