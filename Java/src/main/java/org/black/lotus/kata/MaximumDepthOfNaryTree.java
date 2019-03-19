package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

@LeetCode
@FirstRound
@Easy
@Accepted
public class MaximumDepthOfNaryTree {

  public int maxDepth(Node root) {
    return depth(root, 0);
  }

  private int depth(Node node, int currDepth) {
    if (node == null) {
      return currDepth;
    }

    ++currDepth;
    if (node.children.size() > 0) {
      int d = depth(node.children.get(0), currDepth);
      for (int i = 1; i < node.children.size(); ++i) {
        d = Math.max(depth(node.children.get(i), currDepth), d);
      }

      return d;
    } else {
      return currDepth;
    }
  }
}
