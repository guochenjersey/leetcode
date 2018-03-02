package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;
import org.black.lotus.marker.NotAccepted;

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
@NotAccepted
@NoIdeaOrBadIdeaInitially
public class LCAIII {

  class Result {
    TreeNode resNode;
  }

  public TreeNode lowestCommonAncestor3(TreeNode root,
      TreeNode node1,
      TreeNode node2) {
    if (node1 == node2) {
      return node1;
    }

    Result res = new Result();
    TreeNode lowerBound = node1.val < node2.val ? node1 : node2;
    TreeNode upperBound = node1.val > node2.val ? node1 : node2;
    dfs(lowerBound, upperBound, root, res);

    return res.resNode;
  }

  private void dfs(TreeNode lowerBound, TreeNode upperBound,
      TreeNode node, Result result) {
      if (node == null) {
          return;
      }

      if (node == upperBound || node == lowerBound) {
          return;
      }

      if (node.val > lowerBound.val && node.val < upperBound.val) {
          result.resNode = node;
          return;
      }

      if (node.val < upperBound.val) {
          dfs(lowerBound, upperBound, node.right, result);
      }

      if (node.val > lowerBound.val) {
          dfs(lowerBound, upperBound, node.left, result);
      }
  }
}
