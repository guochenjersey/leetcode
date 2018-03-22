package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 Notice
 You don't need to care the order of combinations, but you should make sure the numbers in a combination are sorted.

 Example
 Given n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4]
 ]
 *
 *
 * */
@FirstRound
@Medium
@LintCode
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        dfs(results, result, n, k, 1);
        return results;
    }

    private void dfs(List<List<Integer>> results, List<Integer> path, int n, int k, int startIndex) {
        if (path.size() == k) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n; ++i) {
            path.add(i);
            dfs(results, path, n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
