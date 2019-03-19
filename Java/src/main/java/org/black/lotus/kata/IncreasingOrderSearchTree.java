package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.List;
import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the
 * root of the tree, and every node has no left child and only 1 right child.
 *
 * <p>Example 1: Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 * <p>5 / \ 3 6 / \ \ 2 4 8 / / \ 1 7 9
 *
 * <p>Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 * <p>1 \ 2 \ 3 \ 4 \ 5 \ 6 \ 7 \ 8 \ 9 Note:
 *
 * <p>The number of nodes in the given tree will be between 1 and 100. Each node will have a unique
 * integer value from 0 to 1000.
 */
@LeetCode
@Easy
@FirstRound
@Accepted
public class IncreasingOrderSearchTree {

  public TreeNode increasingBST(TreeNode root) {
    List<TreeNode> nodes = new ArrayList<>();
    inOrder(root, nodes);
    for (int i = 0; i < nodes.size(); ++i) {
      if (i + 1 < nodes.size()) {
        nodes.get(i).right = nodes.get(i + 1);
        nodes.get(i).left = null;
      }
    }
    nodes.get(nodes.size() - 1).right = null;
    nodes.get(nodes.size() - 1).left = null;
    return nodes.get(0);
  }

  private void inOrder(TreeNode node, List<TreeNode> nodes) {
    if (node == null) {
      return;
    }

    inOrder(node.left, nodes);
    nodes.add(node);
    inOrder(node.right, nodes);
  }
}
