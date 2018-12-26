package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.List;
import org.black.lotus.marker.Google;
import org.black.lotus.marker.MySolutionSameWithAnswer;
import org.black.lotus.org.black.lotus.support.TreeNode;

@Google @MySolutionSameWithAnswer
public class SearchRangeInBinarySearchTree {

  public List<Integer> searchRange(TreeNode root, int k1, int k2) {
    List<Integer> res = new ArrayList<>();
    inOrder(root, k1, k2, res);

    return res;
  }

  private void inOrder(TreeNode root, int k1, int k2, List<Integer> res) {
    if (root == null) {
      return;
    }
    inOrder(root.left, k1, k2, res);
    if (k1 <= root.val && root.val <= k2) {
      res.add(root.val);
    }
    inOrder(root.right, k1, k2, res);
  }
}
