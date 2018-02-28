package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

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
