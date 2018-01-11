package org.black.lotus.lintcode;

/**
 * TODO: The last check not understand properly.
 * */
public class SubtreeWithMaximumAverage {

  private int maxSum = Integer.MIN_VALUE;
  private TreeNode maxSumNode;

  class Tuple {
    int sum;
    int nodeNum;

    Tuple(int sum, int nodeNum) {
      this.sum = sum;
      this.nodeNum = nodeNum;
    }
  }
  /*
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
         */
  public TreeNode findSubtree2(TreeNode root) {
    // write your code here
    if (root == null) {
      return null;
    }

    helper(root);
    return maxSumNode;
  }

  private Tuple helper(TreeNode node) {
    if (node == null) {
      return new Tuple(0, 0);
    }

    Tuple leftTuple = helper(node.left);
    Tuple rightTuple = helper(node.right);

    int sum = leftTuple.sum + rightTuple.sum + node.val;
    int nodeNumFromSubTree = leftTuple.nodeNum + rightTuple.nodeNum + 1;
    int average = sum / nodeNumFromSubTree;

    if (average > maxSum) {
      maxSum = average;
      maxSumNode = node;
    }

    return new Tuple(sum, nodeNumFromSubTree);
  }

}
