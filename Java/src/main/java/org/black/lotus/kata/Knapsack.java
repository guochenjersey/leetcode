package org.black.lotus.kata;

import org.black.lotus.marker.DP;
import org.black.lotus.marker.Important;

import java.util.List;

@Important
@DP
public class Knapsack {

    //
    public int knapsack(List<Item> items, int maxWeight) {
        int[][] dp = new int[items.size()][maxWeight];
        return helper(0, maxWeight, items);
    }

    private int helper(int i, int j, List<Item> items) {
        int res = 0;
        if (i == items.size()) {
            res = 0;
        } else if (j < items.get(i).weight) {
            res = helper(i + 1, j, items);
        } else {
            int withItemI = helper(i + 1, j - items.get(i).weight, items) + items.get(i).value;
            int withoutItemI = helper(i + 1, j, items);
            res = Math.max(withItemI, withoutItemI);
        }

        return res;
    }

    class Item {
        public int value;
        public int weight;
    }
}
