package org.black.lotus.kata;

import java.util.*;
import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.misc.DirectedGraphNode;

/**
 * Given an directed graph, a topological order of the graph nodes is defined as follow:
 *
 * <p>For each directed edge A -> B in graph, A must before B in the order list. The first node in
 * the order can be any node in the graph with no nodes direct to it. Find any topological order for
 * the given graph.
 *
 * <p>Notice You can assume that there is at least one topological order in the graph.
 *
 * <p>Have you met this question in a real interview? Clarification Learn more about representation
 * of graphs
 */
@FirstRound
@Medium
@LintCode
@Accepted
public class TopologicalSorting {

  public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
    DirectedGraph directedGraph = new DirectedGraph();
    directedGraph.buildGraph(graph);

    return directedGraph.topologicalSearch();
  }

  class DirectedGraph {
    private Map<Integer, Vertex> directedGraph;

    DirectedGraph() {
      directedGraph = new HashMap<>();
    }

    void buildGraph(ArrayList<DirectedGraphNode> graphNodes) {
      if (graphNodes == null || graphNodes.size() == 0) {
        return;
      }

      graphNodes
          .stream()
          .forEach(
              node ->
                  directedGraph.computeIfAbsent(
                      node.label,
                      k -> {
                        Vertex vertex = new Vertex(node.label);
                        vertex.neighbors.addAll(node.neighbors);
                        return vertex;
                      }));

      for (Map.Entry<Integer, Vertex> v : directedGraph.entrySet()) {
        v.getValue()
            .neighbors
            .stream()
            .forEach(
                neighbour -> {
                  ++directedGraph.get(neighbour.label).inDegree;
                });
      }
    }

    ArrayList<DirectedGraphNode> topologicalSearch() {
      ArrayList<DirectedGraphNode> result = new ArrayList<>();
      Queue<Vertex> queue = new LinkedList<>();
      directedGraph.values().stream().filter(v -> v.inDegree == 0).forEach(queue::offer);
      while (!queue.isEmpty()) {
        Vertex v = queue.poll();
        DirectedGraphNode node = new DirectedGraphNode(v.label);
        node.neighbors = v.neighbors;
        result.add(node);
        v.neighbors.forEach(
            neighbour -> {
              Vertex neibourVertex = directedGraph.get(neighbour.label);
              --neibourVertex.inDegree;
              if (neibourVertex.inDegree == 0) {
                queue.offer(neibourVertex);
              }
            });
      }

      return result;
    }
  }

  class Vertex extends DirectedGraphNode {
    int inDegree;

    Vertex(int label) {
      super(label);
    }
  }
}
