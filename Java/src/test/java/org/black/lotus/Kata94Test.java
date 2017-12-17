package org.black.lotus;

import static org.junit.Assert.*;

import java.util.List;
import org.black.lotus.org.black.lotus.support.TreeNode;
import org.junit.Test;

/** Created by chenguo on 11/12/16. */
public class Kata94Test {

  @Test
  public void should_traverse() {
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode3 = new TreeNode(3);

    treeNode1.right = treeNode2;
    treeNode2.left = treeNode3;

    Kata94 kata94 = new Kata94();
    List<Integer> inOrderTree = kata94.inorderTraversal(treeNode1);
  }
}
