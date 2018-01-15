package org.black.lotus.lintcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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

  public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
      Map<UndirectedGraphNode, Integer> values,
      UndirectedGraphNode node,
      int target) {

    List<UndirectedGraphNode> visitedNodes = new ArrayList<>();
    Queue<UndirectedGraphNode> queue = new LinkedList<>();

    return null;
  }

  private UndirectedGraphNode findTarget(ArrayList<UndirectedGraphNode> graph,
      Map<UndirectedGraphNode, Integer> valueMap, Queue<UndirectedGraphNode> queue,
      List<UndirectedGraphNode> visitedNodes) {
    while (!queue.isEmpty()) {
      UndirectedGraphNode node = queue.poll();
      if (visitedNodes.contains(node)) {
        return null;
      }
    }

    return null;
  }
}
