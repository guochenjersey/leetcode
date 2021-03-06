package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.List;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * <p>Notice You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * <p>Have you met this question in a real interview? Example Given root = {1,#,2}, k = 2, return 2.
 *
 * <p>Challenge What if the BST is modified (insert/delete operations) often and you need to find
 * the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
@Medium
@FirstRound
@LintCode
@Important
public class KthSmallestElementInABST {

  public int kthSmallest(TreeNode root, int k) {
    List<TreeNode> treeNodes = new ArrayList<>();
    inOrder(root, treeNodes, k);

    return treeNodes.get(treeNodes.size() - 1).val;
  }

  private void inOrder(TreeNode node, List<TreeNode> treeNodes, int k) {
    if (node == null) {
      return;
    }
    inOrder(node.left, treeNodes, k);
    if (treeNodes.size() != k) {
      treeNodes.add(node);
    } else {
      return;
    }
    inOrder(node.right, treeNodes, k);
  }
}
