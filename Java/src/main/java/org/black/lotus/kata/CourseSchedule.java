package org.black.lotus.kata;

import java.util.*;
import org.black.lotus.marker.*;

@FirstRound
@LintCode
@Amazon
@Important
@Medium
public class CourseSchedule {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    DirectedGraph directedGraph = new DirectedGraph();
    directedGraph.buildGraph(prerequisites);
    return directedGraph.topSort();
  }
}

class DirectedGraph {
  private Map<Integer, Vertex> directedGraph;

  public DirectedGraph() {
    directedGraph = new LinkedHashMap<>();
  }

  public void buildGraph(int[][] graph) {
    Integer startNodeLabel, endNodeLabel;
    Edge edge;
    for (int[] i : graph) {
      endNodeLabel = i[0];
      startNodeLabel = i[1];
      directedGraph.computeIfAbsent(startNodeLabel, Vertex::new);
      directedGraph.computeIfAbsent(endNodeLabel, Vertex::new);
      edge = new Edge(directedGraph.get(endNodeLabel));
      directedGraph.get(startNodeLabel).addEdge(edge);
      directedGraph.get(endNodeLabel).increaseDegree();
    }
  }

  public boolean topSort() {
    int count = 0;
    Queue<Vertex> queue = new LinkedList<>();
    directedGraph.values().stream().filter(v -> v.getInDegree() == 0).forEach(queue::offer);

    while (!queue.isEmpty()) {
      Vertex vertex = queue.poll();
      System.out.println(vertex.getLabel());
      ++count;
      for (Edge e : vertex.getEdges()) {
        if (e.getEndVertex().decreaseInDegree() == 0) {
          queue.offer(e.getEndVertex());
        }
      }
    }

    return (count == directedGraph.size());
  }
}

class Vertex {
  private int label;
  private List<Edge> edges;
  private int inDegree;

  public int getLabel() {
    return label;
  }

  public List<Edge> getEdges() {
    return edges;
  }

  public int decreaseInDegree() {
    --inDegree;
    return inDegree;
  }

  public int getInDegree() {
    return inDegree;
  }

  public void addEdge(Edge edge) {
    edges.add(edge);
  }

  public void increaseDegree() {
    ++inDegree;
  }

  public Vertex(int label) {
    this.label = label;
    this.inDegree = 0;
    edges = new ArrayList<>();
  }
}

class Edge {
  private Vertex endVertex;

  public Vertex getEndVertex() {
    return endVertex;
  }

  public Edge(Vertex endVertex) {
    this.endVertex = endVertex;
  }
}
