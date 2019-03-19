package org.black.lotus.kata;

import java.util.*;
import org.black.lotus.marker.*;

/**
 * Equations are given in the format A / B = k, where A and B are variables represented as strings,
 * and k is a real number (floating point number). Given some queries, return the answers. If the
 * answer does not exist, return -1.0.
 *
 * <p>Example: Given a / b = 2.0, b / c = 3.0. queries are: a / c = ?, b / a = ?, a / e = ?, a / a =
 * ?, x / x = ? . return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * <p>The input is: vector<pair<string, string>> equations, vector<double>& values,
 * vector<pair<string, string>> queries , where equations.size() == values.size(), and the values
 * are positive. This represents the equations. Return vector<double>.
 *
 * <p>According to the example above:
 *
 * <p>equations = [ ["a", "b"], ["b", "c"] ], values = [2.0, 3.0], queries = [ ["a", "c"], ["b",
 * "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. The input is always valid. You may assume that
 * evaluating the queries will result in no division by zero and there is no contradiction.
 */
@LeetCode
@Medium
@FirstRound
@Uber
@NoIdeaOrBadIdeaInitially
@Important
public class EvaluateDvision {

  public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    UndirectedMap undirectedMap = new UndirectedMap();
    Map<Symbol, Double> symbolMap = initMap(equations, values, undirectedMap);

    return handleQueries(queries, undirectedMap, symbolMap);
  }

  private double[] handleQueries(
      String[][] queries, UndirectedMap map, Map<Symbol, Double> symbolMap) {
    double[] res = new double[queries.length];
    for (int i = 0; i < queries.length; ++i) {
      String[] query = queries[i];
      if (map.knownString.contains(query[0]) && map.knownString.contains(query[1])) {
        res[i] = handleQuery(map, query, symbolMap);
      } else {
        res[i] = -1d;
      }
    }
    return res;
  }

  private double handleQuery(UndirectedMap map, String[] query, Map<Symbol, Double> symbolMap) {
    String base = query[0];
    String term = query[1];
    if (symbolMap.containsKey(new Symbol(base, term))) {
      return symbolMap.get(new Symbol(base, term));
    }

    return -1;
  }

  private double helper(
      Set<String> path,
      UndirectedMap map,
      String base,
      String term,
      Map<Symbol, Integer> symbolMap) {
    if (symbolMap.containsKey(new Symbol(base, term))) {
      return -1d;
    }

    return -1d;
  }

  private Map<Symbol, Double> initMap(
      String[][] equations, double[] values, UndirectedMap undirectedMap) {
    int i = 0;
    Map<Symbol, Double> symbolValueMap = new HashMap<>();
    for (String[] equation : equations) {
      String base = equation[0];
      String term = equation[1];
      symbolValueMap.put(new Symbol(base, term), values[i]);
      symbolValueMap.put(new Symbol(term, base), 1 / values[i]);
      undirectedMap.knownString.add(base);
      undirectedMap.knownString.add(term);
      Node baseNode = undirectedMap.find(base);
      if (baseNode != null) {
        baseNode.addTerm(term);
      } else {
        Node n = new Node(base);
        n.addTerm(term);
        undirectedMap.nodes.add(n);
      }

      Node termNode = undirectedMap.find(term);
      if (termNode != null) {
        termNode.addTerm(base);
      } else {
        Node n = new Node(term);
        n.addTerm(base);
        undirectedMap.nodes.add(n);
      }
      ++i;
    }

    return symbolValueMap;
  }

  class UndirectedMap {
    private Set<Node> nodes;
    private Set<String> knownString;

    UndirectedMap() {
      this.nodes = new HashSet<>();
      this.knownString = new HashSet<>();
    }

    Node find(String base) {
      Optional<Node> any = nodes.stream().filter(n -> base.equals(n.base)).findAny();
      return any.orElse(null);
    }
  }

  class Node {
    private String base;
    private Set<String> terms;

    Node(String base) {
      this.base = base;
      this.terms = new HashSet<>();
    }

    void addTerm(String term) {
      terms.add(term);
    }
  }

  class Symbol {
    private String base;
    private String term;

    public Symbol(String base, String term) {
      this.base = base;
      this.term = term;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Symbol symbol = (Symbol) o;

      if (base != null ? !base.equals(symbol.base) : symbol.base != null) return false;
      return term != null ? term.equals(symbol.term) : symbol.term == null;
    }

    @Override
    public int hashCode() {
      int result = base != null ? base.hashCode() : 0;
      result = 31 * result + (term != null ? term.hashCode() : 0);
      return result;
    }
  }
}
