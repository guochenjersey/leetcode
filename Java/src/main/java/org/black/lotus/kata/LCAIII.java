package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;

/**
 * Given the root and two nodes in a Binary Tree.
 * Find the lowest common ancestor(LCA) of the two nodes.
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 * Return null if LCA does not exist.
 * Notice
 * node A or node B may not exist in tree.
 *
 * */
@LintCode
@FirstRound
public class LCAIII {

  class Result {
    TreeNode resNode;
    int level;
  }

  public TreeNode lowestCommonAncestor3(TreeNode root,
      TreeNode node1,
      TreeNode node2) {
    if (node1 == node2) {
      return node1;
    }

    Result res = new Result();
    res.level = -1;
    TreeNode lowerBound = node1.val < node2.val ? node1 : node2;
    TreeNode upperBound = node1.val > node2.val ? node1 : node2;
    dfs(lowerBound, upperBound, root, res, 0);

    return res.resNode;
  }

  private void dfs(TreeNode lowerBound, TreeNode upperBound,
      TreeNode node, Result result, int level) {

  }
}
