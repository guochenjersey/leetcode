package org.black.lotus.kata;

import java.math.BigInteger;
import org.black.lotus.org.black.lotus.support.TreeNode;
import org.junit.Test;

public class LCATest {

  @Test
  public void should_find_lca() {
    TreeNode root = new TreeNode(0);
    root.val = 0;
    TreeNode left1 = new TreeNode(1);
    left1.val = 1;

    TreeNode right2 = new TreeNode(1);
    right2.val = 1;

    root.left = left1;
    root.right = right2;

    LCA lca = new LCA();
    TreeNode treeNode = lca.lowestCommonAncestor(root, left1, right2);
  }

  @Test
  public void should_handle_1() {
    TreeNode root = new TreeNode(1);
    root.val = 1;

    LCA lca = new LCA();
    TreeNode treeNode = lca.lowestCommonAncestor(root, root, root);
  }

  @Test
  public void should_handle_2() {
    BigInteger num = new BigInteger("21");
    BigInteger dividendum = num.divide(new BigInteger("9"));

    System.out.println(dividendum);
  }
}
