package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.List;
import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;

/**
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two
 * nodes. The lowest common ancestor is the node with largest depth which is the ancestor of both
 * nodes. The node has an extra attribute parent which point to the father of itself. The root's
 * parent is null.
 */
@LintCode
@FirstRound
@Accepted
public class LCAII {
  /*
   * @param root: The root of the tree
   * @param A: node in the tree
   * @param B: node in the tree
   * @return: The lowest common ancestor of A and B
   */
  public ParentTreeNode lowestCommonAncestorII(
      ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
    if (root == null) {
      return null;
    }

    List<ParentTreeNode> path1 = new ArrayList<>();
    List<ParentTreeNode> path2 = new ArrayList<>();
    findPath(A, path1);
    findPath(B, path2);

    ParentTreeNode prev = null;
    int index1 = path1.size() - 1;
    int index2 = path2.size() - 2;
    while (index1 >= 0 && index2 >= 0) {
      if (path1.get(index1) != path2.get(index2)) {
        break;
      }
      prev = path1.get(index1);
      index1--;
      index2--;
    }

    return prev;
  }

  private void findPath(ParentTreeNode node, List<ParentTreeNode> path) {
    ParentTreeNode temp = node;
    while (temp != null) {
      path.add(temp);
      temp = temp.parent;
    }
  }
}
