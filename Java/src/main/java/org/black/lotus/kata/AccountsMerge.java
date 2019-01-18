package org.black.lotus.kata;


import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.UnionFind;

import java.util.*;

/**
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
 * <p>
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 * <p>
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 * <p>
 * Example 1:
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation:
 * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 * Note:
 * <p>
 * The length of accounts will be in the range [1, 1000].
 * The length of accounts[i] will be in the range [1, 10].
 * The length of accounts[i][j] will be in the range [1, 30].
 * <p>
 * Algorithm
 *
 * @link https://zh.wikipedia.org/wiki/%E5%B9%B6%E6%9F%A5%E9%9B%86 https://blog.csdn.net/liujian20150808/article/details/50848646
 */
@FirstRound
@LeetCode
@Medium
@UnionFind
public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> m = new HashMap<>();
        int[] adj = new int[accounts.size()];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = i;  //这里最好不设成-1
        }

        for (int i = 0; i < accounts.size(); i++) {
            List<String> l = accounts.get(i);
            // union，这里可能会发生多次的union
            for (int k = 1; k < l.size(); k++) {
                if (m.containsKey(l.get(k))) {
                    union(adj, i, m.get(l.get(k)));
                }
                m.put(l.get(k), i);
            }
        }

        List<List<String>> ret = new ArrayList<>();
        boolean[] marked = new boolean[adj.length];
        for (int i = 0; i < adj.length; i++) {
            if (!marked[i]) {
                Set<String> t = new HashSet<>();
                // 这里需要遍历一遍
                for (int j = 0; j < adj.length; j++) {
                    if (adj[j] == i) {
                        marked[j] = true;
                        for (int k = 1; k < accounts.get(j).size(); k++)
                            t.add(accounts.get(j).get(k));
                    }
                }

                if (t.size() == 0) continue;
                List<String> l = new ArrayList<>();
                l.add(accounts.get(i).get(0));
                List<String> l2 = new ArrayList<>(t);
                Collections.sort(l2);
                l.addAll(l2);
                ret.add(l);
            }
        }
        return ret;
    }

    private void union(int[] adj, int i, int j) {
        int f1 = find(adj, i), f2 = find(adj, j);
        for (int k = 0; k < adj.length; k++)
            if (adj[k] == f1) adj[k] = f2;    // set
    }

    private int find(int[] adj, int i) {
        while (adj[i] != i) i = adj[i];
        return i;
    }
}
