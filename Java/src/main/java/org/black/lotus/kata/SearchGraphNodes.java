package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.LintCode;

/**
 * Given a undirected graph, a node and a target, return the nearest node to given node which value
 * of it is target, return NULL if you can't find.
 *
 * <p>There is a mapping store the nodes' values in the given parameters.
 *
 * <p>Notice It's guaranteed there is only one available solution
 *
 * <p>Have you met this question in a real interview? Example 2------3 5 \ | | \ | | \ | | \ | | 1
 * --4 Give a node 1, target is 50
 *
 * <p>there a hash named values which is [3,4,10,50,50], represent: Value of node 1 is 3 Value of
 * node 2 is 4 Value of node 3 is 10 Value of node 4 is 50 Value of node 5 is 50
 *
 * <p>Return node 4
 */
@Accepted
@Important
@LintCode
class UndirectedGraphNode {
  int label;
  ArrayList<UndirectedGraphNode> neighbors;

  UndirectedGraphNode(int x) {
    label = x;
    neighbors = new ArrayList<>();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    UndirectedGraphNode that = (UndirectedGraphNode) o;

    if (label != that.label) {
      return false;
    }
    return neighbors.equals(that.neighbors);
  }

  @Override
  public int hashCode() {
    int result = label;
    result = 31 * result + neighbors.hashCode();
    return result;
  }
}

public class SearchGraphNodes {

  public UndirectedGraphNode searchNode(
      ArrayList<UndirectedGraphNode> graph,
      Map<UndirectedGraphNode, Integer> values,
      UndirectedGraphNode node,
      int target) {

    List<UndirectedGraphNode> visitedNodes = new ArrayList<>();
    Queue<UndirectedGraphNode> queue = new LinkedList<>();
    queue.offer(node);
    visitedNodes.add(node);
    return findTarget(values, queue, visitedNodes, target);
  }

  private UndirectedGraphNode findTarget(
      Map<UndirectedGraphNode, Integer> valueMap,
      Queue<UndirectedGraphNode> queue,
      List<UndirectedGraphNode> visitedNodes,
      Integer target) {
    while (!queue.isEmpty()) {
      UndirectedGraphNode node = queue.poll();

      if (valueMap.get(node).equals(target)) {
        return node;
      }
      node.neighbors.forEach(
          n -> {
            if (!visitedNodes.contains(n)) {
              queue.offer(n);
              visitedNodes.add(n);
            }
          });
    }

    return null;
  }
}
