package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.black.lotus.org.black.lotus.support.TreeNode;
import org.junit.Test;

public class FlipEquivalentBinaryTreesTest {

  @Test
  public void should_flip() {
    TreeNode node1 = new TreeNode(0);
    node1.left = new TreeNode(3);
    node1.right = new TreeNode(1);
    node1.right.right = new TreeNode(2);

    TreeNode node2 = new TreeNode(0);
    node2.left = new TreeNode(3);
    node2.right = new TreeNode(1);
    node2.left.left = new TreeNode(2);

    FlipEquivalentBinaryTrees flipEquivalentBinaryTrees = new FlipEquivalentBinaryTrees();

    boolean res = flipEquivalentBinaryTrees.flipEquiv(node1, node2);
    assertFalse(res);
  }
}
