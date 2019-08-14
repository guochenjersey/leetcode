package org.black.lotus.kata;

import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

 Example:

 Input: 3
 Output: 5
 Explanation:
 Given n = 3, there are a total of 5 unique BST's:

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 * */
@LeetCode
@Medium
@NoIdeaOrBadIdeaInitially
public class UniqueBinarySearchTrees {

    private Map<Integer, Integer> res = new HashMap<>();

    public int numTrees(int n) {
        if (n < 1)
            return 1;
        if (res.containsKey(n)) {
            return res.get(n);
        }
        int sum = 0;
        for (int i = 1; i <= n; ++i) {
            int i1 = numTrees(i - 1);
            int ni = numTrees(n - i);
            sum += (i1 * ni);
        }
        res.put(n, sum);
        return sum;
    }
}
