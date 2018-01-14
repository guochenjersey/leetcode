package org.black.lotus.lintcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/**
 * Difference between Tree and Graph are
 * 1) graph has circle.
 * 2) visited nodes equals all nodes number. All nodes must be reachable.
 *
 * */
public class GraphValidTree {

  class Path {
    Integer from;
    Integer to;

    Path(Integer from, Integer to) {
      this.from = from;
      this.to = to;
    }

    @Override
    public boolean equals(Object toCheck) {
      if (toCheck == null || !(toCheck instanceof Path)) {
        return false;
      }

      /*
       * undirected graph route comparision.
       * */
      Path that = (Path) toCheck;
      return (that.from.equals(from) && that.to.equals(to)) ||
          (that.from.equals(to) && that.to.equals(from));
    }

    @Override
    public int hashCode() {
      return from + to;
    }
  }

  public boolean validTree(int n, int[][] edges) {
    // check special case.
    if (n == 1 && edges.length == 0) {
      return true;
    } else if (n > 1 && edges.length == 0) {
      return false;
    }
    Queue<Integer> queue = new LinkedList<>();
    Map<Integer, Set<Integer>> map = toMap(edges);
    Set<Integer> visitedNodes = new HashSet<>();
    Set<Path> visitedPaths = new HashSet<>();
    queue.offer(0);
    return helper(map, queue, visitedNodes, visitedPaths) && visitedNodes.size() == n;
  }

  private boolean helper(Map<Integer, Set<Integer>> map,
      Queue<Integer> queue,
      Set<Integer> visitedNodes,
      Set<Path> visitedPaths) {
    // BFS search
    while (!queue.isEmpty()) {
      Integer node = queue.poll();
      if (visitedNodes.contains(node)) {
        return false;
      }
      visitedNodes.add(node);
      Set<Integer> successorNodes = map.get(node);
      successorNodes.forEach(successor -> {
        /*
         * Say if 0 -> 1 visited, 1 as successor shouldn't add 1 -> 0 anymore.
         * */
        if (!visitedPaths.contains(new Path(node, successor))) {
          visitedPaths.add(new Path(node, successor));
          queue.offer(successor);
        }
      });
    }

    return true;
  }

  /**
   * convert from edges to node -> nodes it can reach
   */
  private Map<Integer, Set<Integer>> toMap(int[][] edges) {
    Map<Integer, Set<Integer>> res = new HashMap<>();
    for (int[] edge : edges) {
      res.putIfAbsent(edge[0], new TreeSet<>());
      res.get(edge[0]).add(edge[1]);

      res.putIfAbsent(edge[1], new TreeSet<>());
      res.get(edge[1]).add(edge[0]);
    }
    return res;
  }

  public static void main(String... args) {
    GraphValidTree graphValidTree = new GraphValidTree();
    int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 3}};
    System.out.println(graphValidTree.validTree(5, edges));
  }
}
