package org.black.lotus.lintcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> paths = new ArrayList<>();
    helper(root, "", paths);
    return paths;
  }

  private void helper(TreeNode node, String path, List<String> paths) {
    if (node == null) {
      return;
    }
    if (node.left == null && node.right == null) {
      if ("".equalsIgnoreCase(path)) {
        paths.add(String.valueOf(node.val));
      } else {
        paths.add(path + "->" + node.val);
      }
    } else {
      if (!path.equalsIgnoreCase("")) {
        helper(node.left, path + "->" + node.val, paths);
        helper(node.right, path + "->" + node.val, paths);
      } else {
        helper(node.left, String.valueOf(node.val), paths);
        helper(node.right, String.valueOf(node.val), paths);
      }
    }
  }
}
