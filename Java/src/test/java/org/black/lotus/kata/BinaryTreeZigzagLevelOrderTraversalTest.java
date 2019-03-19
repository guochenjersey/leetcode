package org.black.lotus.kata;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.black.lotus.org.black.lotus.support.TreeNode;
import org.junit.Test;

public class BinaryTreeZigzagLevelOrderTraversalTest {

  @Test
  public void should_traverse_zig_zag() {
    TreeNode root = new TreeNode(3);
    TreeNode rootLeft = new TreeNode(9);
    TreeNode rootRight = new TreeNode(20);
    TreeNode rootRightLeft = new TreeNode(15);
    TreeNode rootRightRight = new TreeNode(7);
    root.left = rootLeft;
    root.right = rootRight;

    root.right.left = rootRightLeft;
    root.right.right = rootRightRight;

    BinaryTreeZigzagLevelOrderTraversal binaryTreeZigzagLevelOrderTraversal =
        new BinaryTreeZigzagLevelOrderTraversal();
    List<List<Integer>> res = binaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(root);

    List<List<Integer>> expectedRes = new ArrayList<>();
    expectedRes.add(Arrays.asList(3));
    expectedRes.add(Arrays.asList(20, 9));
    expectedRes.add(Arrays.asList(15, 7));

    res.forEach(
        l -> {
          l.forEach(
              k -> {
                System.out.print(k + ", ");
              });
          System.out.println();
        });
  }
}
