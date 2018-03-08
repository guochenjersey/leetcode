package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

import java.util.*;

/**
 *  Design and implement a TwoSum class. It should support the following operations: add and find.

 add - Add the number to an internal data structure.
 find - Find if there exists any pair of numbers which sum is equal to the value.

 Have you met this question in a real interview?
 Example
 add(1); add(3); add(5);
 find(4) // return true
 find(7) // return false
 */

@FirstRound
@LeetCode
@Accepted
public class TwoSumDataStructureDesign {

    private int numberIndex = 0;
    private Map<Integer, List<Integer>> reverseNumberMap = new HashMap<>();

    public void add(int number) {
        reverseNumberMap.putIfAbsent(number, new ArrayList<>());
        reverseNumberMap.computeIfPresent(number, (k, v) -> {
            v.add(numberIndex);
            return v;
        });

        ++numberIndex;
    }

    /*
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        final MutableObject<Boolean> res = new MutableObject<>();
        res.set(false);
        for (Map.Entry<Integer, List<Integer>> entry : reverseNumberMap.entrySet()) {
            if (reverseNumberMap.containsKey(value - entry.getKey())) {
                List<Integer> keyList = reverseNumberMap.get(entry.getKey());
                List<Integer> valueKeyList = reverseNumberMap.get(value - entry.getKey());
                if (keyList == valueKeyList) {
                    if (keyList.size() > 1) {
                        res.set(true);
                        break;
                    }
                } else {
                    res.set(true);
                    break;
                }
            }
        }
        return res.get();
    }

    class MutableObject<T> {
        T obj;
        public void set(T obj) {
            this.obj = obj;
        }

        public T get() {
            return obj;
        }
    }

    public static void main(String... args) {
        TwoSumDataStructureDesign twoSumDataStructureDesign = new TwoSumDataStructureDesign();
        twoSumDataStructureDesign.add(1);
        twoSumDataStructureDesign.add(3);
        twoSumDataStructureDesign.add(5);

        System.out.println(twoSumDataStructureDesign.find(4));
        System.out.println(twoSumDataStructureDesign.find(7));
    }
}
