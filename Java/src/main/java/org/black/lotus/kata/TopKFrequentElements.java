package org.black.lotus.kata;


import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;

import java.util.*;

@LeetCode
@Medium
@FirstRound
public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occuranceMap = new HashMap<>();
        for (int i : nums) {
            occuranceMap.put(i, occuranceMap.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Occurance> queue = new PriorityQueue<>((o1, o2) -> o2.occurance - o1.occurance);
        occuranceMap.entrySet()
                .stream()
                .forEach(entry -> {
                    queue.offer(new Occurance(entry.getKey(), entry.getValue()));
                });
        List<Integer> res = new ArrayList<>();
        while (k > 0) {
            res.add(queue.poll().num);
            --k;
        }

        return res;
    }

    private class Occurance {
        private int num;
        private int occurance;
        Occurance(int num, int occurance) {
            this.num = num;
            this.occurance = occurance;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || !(o instanceof Occurance)) {
                return false;
            }
            return ((Occurance) o).num == num
                    && ((Occurance) o).occurance == occurance;
        }

        @Override
        public int hashCode() {
            return num + occurance;
        }
    }
}
