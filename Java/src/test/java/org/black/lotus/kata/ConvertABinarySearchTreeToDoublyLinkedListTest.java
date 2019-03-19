package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.black.lotus.org.black.lotus.support.TreeNode;
import org.junit.Test;

public class ConvertABinarySearchTreeToDoublyLinkedListTest {

  @Test
  public void should_convert() {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right = new TreeNode(5);

    ConvertABinarySearchTreeToDoublyLinkedList c = new ConvertABinarySearchTreeToDoublyLinkedList();
    DoublyListNode res = c.bstToDoublyList(root);

    assertEquals(1, res.val);
  }
}
