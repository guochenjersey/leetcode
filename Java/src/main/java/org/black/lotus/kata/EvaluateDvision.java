package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.Uber;

import java.util.*;

/**
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

 Example:
 Given a / b = 2.0, b / c = 3.0.
 queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 return [6.0, 0.5, -1.0, 1.0, -1.0 ].

 The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

 According to the example above:

 equations = [ ["a", "b"], ["b", "c"] ],
 values = [2.0, 3.0],
 queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 * */
@LeetCode
@Medium
@FirstRound
@Uber
public class EvaluateDvision {

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        UndirectedMap undirectedMap = new UndirectedMap();
        initMap(equations, values, undirectedMap);

        return handleQueries(queries, undirectedMap);
    }

    private double[] handleQueries(String[][] queries, UndirectedMap map) {
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            String[] query = queries[i];
            if (map.knownString.contains(query[0])
                    && map.knownString.contains(query[1])) {
                res[i] = handleQuery(map, query);
            } else {
                res[i] = -1d;
            }
        }
        return res;
    }

    private double handleQuery(UndirectedMap map, String[] query) {
        String base = query[0];
        String term = query[1];
        Queue<Term> queue = new LinkedList<>();
        
    }

    private void initMap(String[][] equations, double[] values, UndirectedMap undirectedMap) {
        int i = 0;
        for (String[] equation : equations) {
            String base = equation[0];
            String term = equation[1];
            undirectedMap.knownString.add(base);
            undirectedMap.knownString.add(term);
            Node baseNode = undirectedMap.find(base);
            if (baseNode != null) {
                baseNode.addTerm(new Term(term, values[i]));
            } else {
                Node n = new Node(base);
                n.addTerm(new Term(term, values[i]));
                undirectedMap.nodes.add(n);
            }

            Node termNode = undirectedMap.find(term);
            if (termNode != null) {
                termNode.addTerm(new Term(base, 1 / values[i]));
            } else {
                Node n = new Node(term);
                n.addTerm(new Term(base, 1/ values[i]));
                undirectedMap.nodes.add(n);
            }
            ++i;
        }
    }

    class UndirectedMap {
        private Set<Node> nodes;
        private Set<String> knownString;

        UndirectedMap() {
            this.nodes = new HashSet<>();
            this.knownString = new HashSet<>();
        }

        Node find(String base) {
            Optional<Node> any = nodes.stream()
                    .filter(n -> base.equals(n.base))
                    .findAny();
            return any.orElse(null);
        }
    }

    class Node {
        private String base;
        private Set<Term> terms;

        Node(String base) {
            this.base = base;
            this.terms = new HashSet<>();
        }

        void addTerm(Term term) {
            terms.add(term);
        }

    }

    class Term {
        private String term;
        private double value;

        Term(String term, double value) {
            this.term = term;
            this.value = value;
        }
    }
}
