package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.Medium;

import java.util.*;

@FirstRound
@Medium
@LintCode
public class InsertDeleteGetRandom {

    private ArrayList<Integer> values;
    private Map<Integer, Integer> map;
    private Random random;

    public InsertDeleteGetRandom() {
        values = new ArrayList<>();
        map = new HashMap<>();
        random = new Random(System.currentTimeMillis());
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        if (map.get(val) == null) {
            return false;
        }
        values.add(val);
        map.put(val, values.size() - 1);
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        return false;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        return 0;
    }
}
