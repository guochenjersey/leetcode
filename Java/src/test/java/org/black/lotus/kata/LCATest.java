package org.black.lotus.kata;

import java.math.BigInteger;
import org.junit.Test;

public class LCATest {

  @Test
  public void should_find_lca() {
    TreeNode root = new TreeNode();
    root.val = 0;
    TreeNode left1 = new TreeNode();
    left1.val = 1;

    TreeNode right2 = new TreeNode();
    right2.val = 1;


    root.left = left1;
    root.right = right2;

    LCA lca = new LCA();
    TreeNode treeNode = lca.lowestCommonAncestor(root, left1, right2);

    assertEquals(new Integer(0), treeNode.val);
  }


  @Test
  public void should_handle_1() {
    TreeNode root = new TreeNode();
    root.val = 1;

    LCA lca = new LCA();
    TreeNode treeNode = lca.lowestCommonAncestor(root, root, root);
    assertEquals(new Integer(1), treeNode.val);
  }

  @Test
  public void should_handle_2() {
    BigInteger num = new BigInteger("21");
    BigInteger dividendum = num.divide(new BigInteger("9"));

    System.out.println(dividendum);
  }
}