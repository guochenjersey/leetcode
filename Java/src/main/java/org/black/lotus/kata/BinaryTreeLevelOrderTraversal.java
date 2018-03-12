package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 Have you met this question in a real interview?
 Example
 Given binary tree {3,9,20,#,#,15,7},

 3
 / \
 9  20
 /  \
 15   7


 return its level order traversal as:

 [
 [3],
 [9,20],
 [15,7]
 ]
 Challenge
 Challenge 1: Using only 1 queue to implement it.

 Challenge 2: Use DFS algorithm to do it.

 Tags
 * */
@FirstRound
@Accepted
@LintCode
public class BinaryTreeLevelOrderTraversal {

  class LevelNode {
    int level;
    TreeNode node;

    LevelNode(int level, TreeNode node) {
      this.level = level;
      this.node = node;
    }
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    Map<Integer, List<Integer>> resultMap = new TreeMap<>();
    Queue<LevelNode> queue = new LinkedList<>();
    queue.offer(new LevelNode(0, root));
    traverse(queue, resultMap);
    return resultMap.values().stream().collect(Collectors.toList());
  }

  private void traverse(Queue<LevelNode> queue, Map<Integer, List<Integer>> resultMap) {
    while (!queue.isEmpty()) {
      LevelNode levelNode = queue.poll();
      resultMap.putIfAbsent(levelNode.level, new ArrayList<>());
      resultMap.get(levelNode.level).add(levelNode.node.val);

      if (levelNode.node.left != null) {
        queue.offer(new LevelNode(levelNode.level + 1, levelNode.node.left));
      }

      if (levelNode.node.right != null) {
        queue.offer(new LevelNode(levelNode.level + 1, levelNode.node.right));
      }
    }
  }
}
