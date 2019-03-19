package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.black.lotus.org.black.lotus.support.TreeNode;
import org.junit.Test;

public class CheckCompletenessOfBinaryTreeTest {

  @Test
  public void should_check_incompleteness_binary_tree() {
    TreeNode root = new TreeNode(1);
    TreeNode rootLeft = new TreeNode(2);
    TreeNode rootRight = new TreeNode(3);
    TreeNode rootLeftLeft = new TreeNode(4);
    TreeNode rootLeftRight = new TreeNode(5);
    TreeNode rootRightLeft = new TreeNode(6);

    root.left = rootLeft;
    root.right = rootRight;

    rootLeft.left = rootLeftLeft;
    rootLeft.right = rootLeftRight;

    rootRight.left = rootRightLeft;

    CheckCompletenessOfBinaryTree checkCompletenessOfBinaryTree =
        new CheckCompletenessOfBinaryTree();
    boolean completeTree = checkCompletenessOfBinaryTree.isCompleteTree(root);

    assertTrue(completeTree);
  }
}
