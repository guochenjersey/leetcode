package org.black.lotus.kata;

import java.util.HashSet;
import java.util.Set;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.UnionFind;

@LeetCode
@UnionFind
@FirstRound
@Medium
public class FriendCircles {

  public int findCircleNum(int[][] relationship) {
    if (relationship == null) {
      return 0;
    }

    int[] pre = new int[relationship.length];
    init(pre);
    for (int i = 0; i < relationship.length; ++i) {
      for (int j = i; j < relationship[i].length; ++j) {
        if (relationship[i][j] == 1) {
          union(pre, i, j);
        }
      }
    }

    Set<Integer> friends = new HashSet<>();
    for (int aPre : pre) {
      friends.add(aPre);
    }

    return friends.size();
  }

  private void init(int[] pre) {
    for (int i = 0; i < pre.length; ++i) {
      pre[i] = i;
    }
  }

  /**
   * @param i the ith student
   * @param j the jth student
   */
  private void union(int[] pre, int i, int j) {
    int iPre = find(pre, i);
    int jPre = find(pre, j);
    if (iPre != jPre) {
      for (int k = 0; k < pre.length; ++k) {
        if (pre[k] == jPre) {
          pre[k] = iPre;
        }
      }
    }
  }

  /** @return root precedessor of student */
  private int find(int[] pre, int student) {
    while (pre[student] != student) {
      student = pre[student];
    }

    return student;
  }
}
