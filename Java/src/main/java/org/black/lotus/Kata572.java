package org.black.lotus;

import org.black.lotus.org.black.lotus.support.TreeNode;

public class Kata572 {

  // pre-order traverse to compare
  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null) {
      return false;
    }

    return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  public boolean isSame(TreeNode s, TreeNode t) {
    if (s == null && t == null) {
      return true;
    }
    if (s == null || t == null) {
      return false;
    }

    if (s.val != t.val) return false;

    return isSame(s.left, t.left) && isSame(s.right, t.right);
  }
}
