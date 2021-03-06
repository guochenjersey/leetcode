package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.List;
import org.black.lotus.marker.Facebook;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * Consider all the leaves of a binary tree. From left to right order, the values of those leaves
 * form a leaf value sequence.
 *
 * <p>For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * <p>Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * <p>Return true if and only if the two given trees with head nodes root1 and root2 are
 * leaf-similar.
 */
@LeetCode
@FirstRound
@Facebook
@Medium
public class LeafSimiliarTrees {

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> res1 = new ArrayList<>();
    List<Integer> res2 = new ArrayList<>();

    traverse(root1, res1);
    traverse(root2, res2);

    if (res1.size() != res2.size()) {
      return false;
    }

    for (int i = 0; i < res1.size(); ++i) {
      if (!res1.get(i).equals(res2.get(i))) {
        return false;
      }
    }

    return true;
  }

  private void traverse(TreeNode node, List<Integer> leaves) {
    if (node == null) {
      return;
    }

    if (node.left == null && node.right == null) {
      leaves.add(node.val);
    }

    traverse(node.left, leaves);
    traverse(node.right, leaves);
  }
}
