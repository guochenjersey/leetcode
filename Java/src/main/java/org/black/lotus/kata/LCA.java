package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.List;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;
import org.black.lotus.marker.Twitter;

@Twitter
@FirstRound
@LintCode
@NoIdeaOrBadIdeaInitially
public class LCA {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
    List<TreeNode> result1 = new ArrayList<>();
    List<TreeNode> result2 = new ArrayList<>();
    List<TreeNode> path1 = new ArrayList<>();
    List<TreeNode> path2 = new ArrayList<>();
    findPath(result1, path1, root, node1);
    findPath(result2, path2, root, node2);

    TreeNode prev = null;
    for (int i = 0, j = 0; i < result1.size() && j < result2.size(); ++i, ++j) {
      TreeNode n1 = result1.get(i);
      TreeNode n2 = result2.get(j);
      if (n1 == n2) {
        prev = n1;
      } else {
        return prev;
      }
    }
    return prev;
  }


  /**
   * DFS a binary tree and record the path.
   * */
  private boolean findPath(List<TreeNode> result, List<TreeNode> path,
      TreeNode root, TreeNode node) {

    if (root == null) {
      return false;
    }

    path.add(root);
    if (root == node) {
      result.addAll(new ArrayList<>(path));
      return true;
    }

    return findPath(result, new ArrayList<>(path), root.left, node) ||
        findPath(result, new ArrayList<>(path), root.right, node);
  }
}
